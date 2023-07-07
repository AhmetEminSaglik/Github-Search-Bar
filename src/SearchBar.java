import java.util.ArrayList;
import java.util.List;

public class SearchBar {
    public List<String> searchItemFromList(String text, List<String> list) {
        List<String> foundListItems = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean itemFound = isListItemContainsSearchingWords(0, text, list.get(i));
            if (itemFound) {
                foundListItems.add(list.get(i));
            }
        }
        return foundListItems;
    }
    public boolean isListItemContainsSearchingWords(int index, String text, String item) {
        StringBuilder itemBuilder = new StringBuilder(item);
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < item.length(); i++) {
            if (Character.toLowerCase(sb.charAt(index)) == Character.toLowerCase(itemBuilder.charAt(i))) {
                if (index == text.length() - 1) {
                    return true;
                }
                String newItem = itemBuilder.substring(i + 1);
                return isListItemContainsSearchingWords(index + 1, text, newItem);
            }
        }
        return false;
    }
}
