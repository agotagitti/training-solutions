package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private Properties properties = new Properties();

    public JavaTools() {
        try(InputStream is = JavaTools.class.getResourceAsStream("/javatools.properties")) {
            properties.load(new InputStreamReader(is, StandardCharsets.UTF_8));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> propertiesKeys = new HashSet<>();
        for (String actualKey : properties.stringPropertyNames()) {
            if (actualKey.contains("name")) {
                propertiesKeys.add(actualKey.substring(0, actualKey.indexOf(".")));
            }
        }
        return propertiesKeys;
    }

    public Set<String> getTools() {
        Set<String> propertiesTools = new HashSet<>();
        for (String actualKey : getToolKeys()) {
            propertiesTools.add(getName(actualKey));
        }
        return propertiesTools;
    }

    public String getName(String name) {
        return properties.getProperty(name + ".name");
    }

    public String getUrl(String url) {
        return properties.getProperty(url + ".url");
    }

}
