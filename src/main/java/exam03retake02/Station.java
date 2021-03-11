package exam03retake02;

public class Station {

    private int id;
    private String name;
    private double lat;
    private double lng;
    private String description;
    private int level;
    private GroupId groupId;
    private StationType stationType;

    public Station(int id, String name, double lat, double lng, String description, int level, GroupId groupId, StationType stationType) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.description = description;
        this.level = level;
        this.groupId = groupId;
        this.stationType = stationType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public StationType getStationType() {
        return stationType;
    }

}
