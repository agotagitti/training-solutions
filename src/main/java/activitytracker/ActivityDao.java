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
            return findActivityById(getGeneratedKey(pstmt));
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect data source", se);
        }
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
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities where id = ?")) {
            pstmt.setLong(1, id);
            return getPreparedStatement(pstmt).get(0);

        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load data source", se);
        }
    }

    private List<Activity> getPreparedStatement(PreparedStatement pstmt) {
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
             return getPreparedStatement(pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load datasource", se);
        }
    }

    public List<Activity> activitiesBefore(LocalDateTime dateTime)  {
        List<Activity> activities = new ArrayList<>();
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities where start_time < ?")) {
            pstmt.setTimestamp(1, Timestamp.valueOf(dateTime));
           return getPreparedStatement(pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect database", se);
        }

    }

    public List<Activity> activitiesBeforeDate(LocalDate date)  {
        return activitiesBefore(date.atStartOfDay());
    }


}
