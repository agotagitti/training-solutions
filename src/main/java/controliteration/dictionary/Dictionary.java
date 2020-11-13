package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations) {
        DictionaryItem item = null;
        for (DictionaryItem dictItem: dictionaryItems) {
            if (word.equals(dictItem.getWord())) {
                item = dictItem;
            }
        }
        if (item == null) {
            dictionaryItems.add(new DictionaryItem(word, translations));
        } else {
            item.addTranslations(translations);
        }
    }

    public List<String> findTranslations(String word) {
        List<String> foundTranslations = new ArrayList<>();
        for (DictionaryItem item: dictionaryItems) {
            if (item.getWord().equals(word)) {
                foundTranslations = item.getTranslations();
            }
        }
        return foundTranslations;
    }
}
