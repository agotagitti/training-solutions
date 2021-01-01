package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.features = Arrays.asList(feature);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int sumAudio = 0;
        if (hasAudioFeature()) {
            for (Feature actual: features) {
                if (actual instanceof AudioFeatures) {
                    sumAudio += ((AudioFeatures) actual).getLength();
                }
            }
        }
        return sumAudio;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature actual: features) {
            contributors.addAll(actual.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature actual: features) {
            titles.add(actual.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature actual: features) {
            if (actual instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature actual: features) {
            if (actual instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int sumPages = 0;
        if (hasPrintedFeature()) {
             for (Feature actual: features) {
                 if (actual instanceof PrintedFeatures) {
                     sumPages += ((PrintedFeatures) actual).getNumberOfPages();
                 }
             }
         }
        return sumPages;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

}
