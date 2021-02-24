package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement(
                     "insert into activities (start_time, activity_desc, activity_type) values (?, ?, ?)")) {
            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().toString());
            pstmt.executeUpdate();

        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect data source", se);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities where id = ?")) {
            pstmt.setLong(1, id);
            return getPreparedStatement(pstmt);

        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load datasouce", se);
        }
    }

    private Activity getPreparedStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
            }
            throw new IllegalArgumentException("Cannot find Activity");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect");
        }
    }

    public List<Activity> listActivities() {
        List<Activity> activities = new ArrayList<>();
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select * from activities");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                activities.add(new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))));
            }
            if (activities.isEmpty()) {
                throw new IllegalArgumentException("Cannot find any Activity");
            }
            return activities;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load datasource", se);
        }
    }

}
