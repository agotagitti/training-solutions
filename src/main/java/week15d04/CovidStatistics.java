package week15d04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidStatistics {

    private List<WeeklyData> weeklyDataList = new ArrayList<>();

    public List<WeeklyData> getWeeklyDataList() {
        return new ArrayList<>(weeklyDataList);
    }

    public void readLineFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(FileReader.class.getResourceAsStream("data.csv")))) {
            String line;
            while ((line = reader.readLine())  != null) {
                if (line.contains("Hungary")) {
                    weeklyDataList.add(splitData(line));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public WeeklyData splitData(String line) {
        String[] lineData = line.split(",");
        int caseNumber = Integer.parseInt(lineData[2]);
        return new WeeklyData(lineData[1], caseNumber);
    }

    public List<String> worstThreeWeeks() {
        List<String> result = new ArrayList<>();
        List<WeeklyData> sortedList = getSortedWeeklyDataList();
        for (int i = 0; i < 3; i++) {
            result.add(sortedList.get(i).getWeekNumber());
        }
        return result;
    }

    private List<WeeklyData> getSortedWeeklyDataList() {
        List<WeeklyData> sortedWeeklyData = new ArrayList<>(weeklyDataList);
        Collections.sort(sortedWeeklyData);
        return sortedWeeklyData;
    }

}
