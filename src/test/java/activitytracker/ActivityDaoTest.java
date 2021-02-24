package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource mDataSource;

        try {
            mDataSource = new MariaDbDataSource();
            mDataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            mDataSource.setUser("activitytracker");
            mDataSource.setPassword("activitytracker");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot connect datasouce", se);
        }

        Flyway flyway = Flyway.configure().dataSource(mDataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(mDataSource);
    }

    @Test
    void testSaveLoadActivities() {
        Activity ac1 = new Activity(LocalDateTime.of(2019, 6, 6, 10, 30), "Budai tura", ActivityType.HIKING);
        Activity ac2 = new Activity(LocalDateTime.of(2020, 4, 10, 6, 30), "Napi futas", ActivityType.RUNNING);
        Activity ac3 = new Activity(LocalDateTime.of(2021, 2, 20, 14, 15), "Teli bringaut", ActivityType.BIKING);

        activityDao.saveActivity(ac1);
        activityDao.saveActivity(ac2);
        activityDao.saveActivity(ac3);

       assertEquals(activityDao.listActivities().size(), 3);
    }

    @Test
    void testFindActivityById() {
        Activity ac1 = new Activity(LocalDateTime.of(2019, 6, 6, 10, 30), "Budai tura", ActivityType.HIKING);
        Activity ac2 = new Activity(LocalDateTime.of(2020, 4, 10, 6, 30), "Napi futas", ActivityType.RUNNING);
        Activity ac3 = new Activity(LocalDateTime.of(2021, 2, 20, 14, 15), "Teli bringaut", ActivityType.BIKING);

        activityDao.saveActivity(ac1);
        activityDao.saveActivity(ac2);
        activityDao.saveActivity(ac3);

        assertEquals(activityDao.findActivityById(2).getType(), ActivityType.RUNNING);
    }

}