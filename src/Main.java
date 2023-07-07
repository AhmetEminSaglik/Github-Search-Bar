import data.Database;
import utility.ConsoleColors;
import utility.Utility;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        List<String> textList = new ArrayList<>();
//        textList.add("Furkan Cetin");
//        textList.add("Furkan Emin Cetin");
//        textList.add("Ahmet Emin Saglik");

//        String searchText = "launc";
        String searchText = "";
        SearchBar searchBar = new SearchBar();
        Database db = new Database();

        while (!searchText.equals("exit")) {
            System.out.println("");
            System.out.println("");
            System.out.println("Please enter text : ");
            searchText = getInputFromUser();
            Utility.print("Searched text : " + searchText);
            searchText = searchText.replace(" ", "");
            List<String> foundItems = searchBar.searchItemFromList(searchText, db.getList());
            Utility.nextLine();
            Utility.print("-----------------------");
            Utility.nextLine();
            Utility.print("Found items : ");
            Utility.nextLine();
            Utility.printResult(searchText, foundItems);
        }
    }


    public static String getInputFromUser() {
        return scanner.nextLine();
    }


/*
    public List<String> searchList(String text, List<String> list) {
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
    }*/
}
