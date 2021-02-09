package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private String login;
    private String ipAddress;
    private LocalDate entryDate;

    public Entry(String login, String ipAddress, LocalDate entryDate) {
        this.login = login;
        this.ipAddress = ipAddress;
        this.entryDate = entryDate;
    }

    public String getLogin() {
        return login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}
