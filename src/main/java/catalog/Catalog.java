package catalog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double averagePageOver = 0;
        int numberOfItems = 0;
        for (CatalogItem actual: catalogItems) {
            if (actual.numberOfPagesAtOneItem() > pageNumber) {
                averagePageOver += actual.numberOfPagesAtOneItem();
                numberOfItems++;
            }
        }
        if (numberOfItems == 0) {
            throw new IllegalArgumentException("No page");
        }

        return averagePageOver / numberOfItems;
    }

//    public void deleteItemByRegistrationNumber(String regNumber) {
//        CatalogItem toRemove = null;
//        for (CatalogItem actual: catalogItems) {
//            if (actual.getRegistrationNumber().equals(regNumber)) {
//                toRemove = actual;
//            }
//        }
//        catalogItems.remove(toRemove);
//    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        catalogItems.removeIf(catalogItem -> catalogItem.getRegistrationNumber().equals(regNumber));
    }


    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> foundCatItems = new ArrayList<>();
        for (CatalogItem actual: catalogItems) {
            boolean found = true;
            if ((searchCriteria.hasContributor() && !actual.getContributors().contains(searchCriteria.getContributor())) ||
                    (searchCriteria.hasTitle() && !actual.getTitles().contains(searchCriteria.getTitle()))) {
                    found = false;
            }
            if (found) {
                foundCatItems.add(actual);
            }
        }
        return foundCatItems;
    }

    public int getAllPageNumber() {
        int sumPages = 0;
        for (CatalogItem actual: catalogItems) {
                sumPages += actual.numberOfPagesAtOneItem();
        }
        return sumPages;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audios = new ArrayList<>();
        for (CatalogItem actual: catalogItems) {
            if (actual.hasAudioFeature()) {
                audios.add(actual);
            }
        }
        return  audios;
    }

    public int getFullLength() {
        int sumLength = 0;
        for(CatalogItem actual: catalogItems) {
                sumLength += actual.fullLengthAtOneItem();
        }
        return sumLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> prints = new ArrayList<>();
        for (CatalogItem actual: catalogItems) {
            if (actual.hasPrintedFeature()) {
                prints.add(actual);
            }
        }
        return prints;
    }


}
