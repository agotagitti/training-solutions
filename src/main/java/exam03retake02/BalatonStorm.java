package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {


    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<Station> stations = new ArrayList<>();
        List<String> dataForStation = new ArrayList<>();
        String line;
        reader.readLine();
        while((line = reader.readLine()) != null) {
            if (line.contains("]")) {
                break;
            }
            for (int i = 0; i < 10; i++) {
                getLineDataWithIf(line, dataForStation);
                if (i < 9 ) {
                    line = reader.readLine();
                }
            }
            addLineDataToStation(stations, dataForStation);
            dataForStation.clear();
        }
        List<String> stationsInStorm = getStormyStations(stations);
        Collections.sort(stationsInStorm, Collator.getInstance(new Locale("hu", "HU")));
        return stationsInStorm;
    }

    private List<String> getStormyStations(List<Station> stations) {
        List<String> stationsInStorm = new ArrayList<>();
        for (Station actualStation : stations) {
            if (actualStation.getLevel() == 3) {
                stationsInStorm.add(actualStation.getName());
            }
        }
        return stationsInStorm;
    }

    private void addLineDataToStation(List<Station> stations, List<String> dataForStation) {
        int id = Integer.parseInt(dataForStation.get(1));
        String name = dataForStation.get(2);
        double lat = Double.parseDouble(dataForStation.get(3));
        double lng = Double.parseDouble(dataForStation.get(4));
        String description = dataForStation.get(5);
        int level = Integer.parseInt(dataForStation.get(6));
        GroupId groupId = GroupId.valueOf(dataForStation.get(7));
        StationType stationType = StationType.valueOf(dataForStation.get(8));
        stations.add(new Station(id, name, lat, lng, description, level, groupId, stationType));
    }

    private void getLineDataWithIf(String line, List<String> dataForStation) {
        if (line.contains("{") || line.contains("}")) {
            dataForStation.add(line);
        } else if (line.lastIndexOf("\"") == line.length() - 2  || line.endsWith("\"")){
            dataForStation.add(line.substring(line.indexOf(":") + 3, line.lastIndexOf("\"")));
        } else {
            dataForStation.add(line.substring(line.indexOf(":") + 2, line.indexOf(",")));
        }
    }
}
