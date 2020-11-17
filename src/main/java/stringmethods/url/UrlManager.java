package stringmethods.url;

public class UrlManager {


    //https://earthquake.usgs.gov:80/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02
    //protocol://host:port/path?query-string
    private String protocol; // :// előtt
    private Integer port; //host és : után, az első /-ig
    private String host; // protocol és // után, pontokkal elválasztva, az első /-ig, kivéve, ha van port
    private String path; // az első simpla /-től a ?-ig
    private String query; // a ? után végig



    public UrlManager(String url) {
        protocol = findProtocol(url);

        if (isEmpty(protocol)) {
            throw new IllegalArgumentException("Invalid url");
        }
        host = findHost(url);
        if (isEmpty(host)) {
            throw new IllegalArgumentException("Invalid url");
        }
        port = findPort(url);
        path = findPath(url);
        query = findQuery(url);
    }

    public boolean hasProperty(String key) {
        if (isEmpty(key)) {
            throw new  IllegalArgumentException();
        }
        boolean hasIt = false;
        for (String property:splitProperties(query)) {
            if (property.startsWith(key)) {
                hasIt = true;
                break;
            }
        }
        return hasIt;
    }

    public String getProperty(String key) {
        if (isEmpty(key)) {
            throw new  IllegalArgumentException();
        }
        String value = null;
        for (String property:splitProperties(query)) {
            if (property.startsWith(key)) {
                value = property.substring(property.indexOf("=") + 1);
            }
        }
        return value;
    }

    private String findProtocol(String url) {
        String protocol = null;
        if (url.indexOf("://") != -1) {
            protocol = url.toLowerCase().substring(0, url.indexOf("://"));
        }
        return protocol;
    }

    private Integer findPort(String url) {
        int startPos = url.indexOf(":",  url.indexOf(":") + 1);
        int endPos = 0;
        Integer port = null;
        if (startPos != -1) {
            startPos += 1;
            if (url.indexOf("/", startPos) != -1) {
                endPos = url.indexOf("/", startPos);
            } else {
                endPos = url.length();
            }
            port = Integer.parseInt(url.substring(startPos, endPos));
        }
        return port;
    }

    private String findHost(String url) {
        int startPos = url.indexOf("://") + 3;
        int endPos = 0;
        String host = null;
        if (startPos <= url.length() - 1) {
            if (url.indexOf(":", startPos) != -1) {
                endPos = url.indexOf(":", startPos);
            } else if (url.indexOf(":", startPos) == -1) {
                endPos = url.indexOf("/", startPos);
            } else {
                endPos = url.length();
            }
            host = url.toLowerCase().substring(startPos, endPos);
        }
        return host;
    }

    private String findPath(String url) {
        int startPos = url.indexOf("/",  url.indexOf("://") + 3);
        int endPos = 0;
        String path = "";
        if (startPos != -1) {
            if (url.contains(Character.toString('?'))) {
                endPos = url.indexOf(Character.toString('?'), startPos);
                path = url.substring(startPos, endPos);
            }
        }
        return path;
    }

    private String findQuery(String url) {
        int startPos = url.indexOf(Character.toString('?')) + 1;
        //int endPos = 0;
        String query = "";
        if (url.contains(Character.toString('?'))) {
            //endPos = url.indexOf(url.length() - 1);
            query = url.substring(startPos);
        }
        return query;
    }

    private String[] splitProperties(String properties) {
        return properties.split("&");
    }

    private boolean isEmpty(String str) {
        boolean isEmpty = false;
        if (str != null) {
            if(str.trim().equals("")) {
                isEmpty = true;
            }
        } else {
            isEmpty = true;
        }

        return isEmpty;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }
}
