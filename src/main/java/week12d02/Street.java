package week12d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Street {

    private List<Site> sites = new ArrayList<>();

    public int sellSite(Site site) {
        int sumSiteNumber = site.getSide() == 0 ? 2 : 1;
        for(Site actual: sites) {
            if (actual.getSide() == site.getSide()) {
                sumSiteNumber += 2;
            }
        }
        sites.add(site);
        return sumSiteNumber;
    }

    public int[] soldSiteFence() {
        int[] soldSites = new int[Fence.values().length];
        for (Site actual: sites) {
            soldSites[actual.getFence().ordinal()]++;
        }
        return soldSites;
    }

}
