package properties;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {

    private final Properties properties = new Properties();
    private static final String ENCODING = "UTF-8";

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
            properties.load(new InputStreamReader(is, ENCODING));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    public DatabaseConfiguration(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(new InputStreamReader(fis, ENCODING));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");

    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }

}
