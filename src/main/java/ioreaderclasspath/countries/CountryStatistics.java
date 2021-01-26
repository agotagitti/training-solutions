package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(
                CountryStatistics.class.getResourceAsStream("/country.txt")))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] countryData = line.split(" ");
                countryList.add(new Country(countryData[0], Integer.parseInt(countryData[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        int countBorderCountries = 0;
        Country mostNeighbours = null;
        for (Country actual: countryList) {
            if (actual.getBorderCountries() > countBorderCountries) {
                countBorderCountries = actual.getBorderCountries();
                mostNeighbours = actual;
            }
        }
        return mostNeighbours;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
