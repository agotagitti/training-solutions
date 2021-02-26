package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityMain {


    public static void main(String[] args) {
        MariaDbDataSource mDataSource;

        try {
            mDataSource = new MariaDbDataSource();
            mDataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            mDataSource.setUser("activitytracker");
            mDataSource.setPassword("activitytracker");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot create datasource", se);
        }

        Flyway flyway = Flyway.configure().dataSource(mDataSource).load();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(mDataSource);

        Activity ac1 = new Activity(LocalDateTime.of(2019, 6, 6, 10, 30), "Budai tura", ActivityType.HIKING);
        Activity ac2 = new Activity(LocalDateTime.of(2020, 4, 10, 6, 30), "Napi futas", ActivityType.RUNNING);
        Activity ac3 = new Activity(LocalDateTime.of(2021, 2, 20, 14, 15), "Teli bringaut", ActivityType.BIKING);

        ac1.addTrackPointList(List.of(new TrackPoint(LocalDate.now(), 45.0, 12.0),
                new TrackPoint(LocalDate.now(), 85.0, 122.0)));

        activityDao.saveActivity(ac1);
        activityDao.saveActivity(ac2);
        activityDao.saveActivity(ac3);

        System.out.println(activityDao.findActivityById(3));

        System.out.println(activityDao.listActivities());
    }

}
