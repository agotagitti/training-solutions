package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement(
                     "insert into activities (start_time, activity_desc, activity_type) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().toString());
            pstmt.executeUpdate();
            Activity result = findActivityById(getGeneratedKey(pstmt));
            saveActivityTrackPoints(activity.getTrackPoints(), result.getId());
            return result;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect data source", se);
        }
    }

    private void saveActivityTrackPoints(List<TrackPoint> trackPoints, long activityId) {
        try (Connection cnx = dataSource.getConnection()) {
            cnx.setAutoCommit(false);
            getPrepStatementWithTrackPoint(trackPoints, activityId, cnx);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect data source", se);
        }
    }

    private void getPrepStatementWithTrackPoint(List<TrackPoint> trackPoints, long activityId, Connection cnx) throws SQLException {
        try (PreparedStatement pstmt = cnx.prepareStatement(
                "insert into track_points (activ_time, lat, lon, activ_id) values (?, ?, ?, ?)")) {
            for (TrackPoint actual : trackPoints) {
                if (!isValidTrackPoint(actual)) {
                    throw new IllegalArgumentException("Invalid trackpoint");
                }
                pstmt.setDate(1, Date.valueOf(actual.getTime()));
                pstmt.setDouble(2, actual.getLat());
                pstmt.setDouble(3, actual.getLon());
                pstmt.setLong(4, activityId);
                pstmt.executeUpdate();
            }
            cnx.commit();
        }
        catch (IllegalArgumentException iae) {
            cnx.rollback();
            throw new IllegalStateException("Cannot insert data", iae);
        }
    }

    private boolean isValidTrackPoint(TrackPoint trackPoint) {
        if ((trackPoint.getLat() >= -90 && trackPoint.getLat() <= 90) &&
                (trackPoint.getLon() >= -180 && trackPoint.getLon() <= 180)) {
            return true;
        }
        return false;
    }

    private long getGeneratedKey(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.getGeneratedKeys()){
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key generated");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities where id = ?");
             PreparedStatement pstmt2 = cnx.prepareStatement("select * from track_points where activ_id = ?")) {
            pstmt.setLong(1, id);
            List<Activity> activities = getActivityByPreparedStatement(pstmt);
            if (activities.size() == 1) {
                pstmt2.setLong(1, id);
                activities.get(0).addTrackPointList(getTrackPointsByPreparedStatement(pstmt2));
            }
            return activities.get(0);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load data source", se);
        }
    }

    private List<TrackPoint> getTrackPointsByPreparedStatement(PreparedStatement pstmt) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                trackPoints.add(new TrackPoint(
                            rs.getLong("id"),
                            rs.getDate("activ_time").toLocalDate(),
                            rs.getDouble("lat"),
                            rs.getDouble("lon")));

            }
            return trackPoints;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Wrong statement", se);
        }
    }

    private List<Activity> getActivityByPreparedStatement(PreparedStatement pstmt) {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                activities.add(new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))));
            }
            return activities;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    public List<Activity> listActivities() {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities")) {
             return getActivityByPreparedStatement(pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load datasource", se);
        }
    }

    public List<Activity> activitiesBefore(LocalDateTime dateTime)  {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities where start_time < ?")) {
            pstmt.setTimestamp(1, Timestamp.valueOf(dateTime));
           return getActivityByPreparedStatement(pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect database", se);
        }

    }

    public List<Activity> activitiesBeforeDate(LocalDate date)  {
        return activitiesBefore(date.atStartOfDay());
    }

}
