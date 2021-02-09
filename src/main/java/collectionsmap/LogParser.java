package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {

    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> result = new HashMap<>();
        for (String actual: log.split("\n")) {
            Entry entry = processLine(actual);
            if (!result.containsKey(entry.getIpAddress())) {
                result.put(entry.getIpAddress(), new ArrayList<>());
            }
            List<Entry> entries = result.get(entry.getIpAddress());
            entries.add(entry);
            result.put(entry.getIpAddress(), entries);
        }
        return result;
    }

    private Entry processLine(String line) {
        String[] lineElements = line.split(":");
        if (lineElements.length != 3) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate logDate = LocalDate.parse(lineElements[1], dtf);
            return new Entry(lineElements[2], lineElements[0], logDate);
        }
        catch (DateTimeParseException dtp) {
            throw new IllegalArgumentException("Incorrect log: incorrect date", dtp);
        }
    }

}
