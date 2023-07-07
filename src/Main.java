import data.Database;
import utility.Utility;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String searchText = "";
        SearchBar searchBar = new SearchBar();
        Database db = new Database();

        while (!searchText.equals("exit")) {
            Utility.nextLine();
            Utility.nextLine();
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
}
