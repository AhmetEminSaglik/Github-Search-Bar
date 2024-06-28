import data.Database;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBar {

    private final Scanner scanner = new Scanner(System.in);

    private final Database database = new Database();
    private final List<String> processList = new ArrayList<>();

    public SearchBar() {
        fillProcessList();
    }

    private void fillProcessList() {
        processList.add("Print All Data ");
        processList.add("Add Data ");
        processList.add("Remove All Data ");
        processList.add("Remove Single Data ");
        processList.add("Search Data");
        processList.add("Update Print Settings");
    }

    public void start() {
        int result = 1;
        while (result != -1) {
            printMajorDivideDesign();
            printProcess();
            result = selectProcess();
            if (result != -1) {
                doSelectedProcess(result);
            }
            Utility.nextLine();
            Utility.nextLine();

        }

    }

    private void doSelectedProcess(int selectedId) {
        printMinorDivideDesign();

        switch (selectedId) {
            case 1:
                printAllData();
                break;
            case 2:
                add();
                break;
            case 3:
                removeAll();
                break;
            case 4:
                remove();
                break;
            case 5:
                search();
                break;
            case 6:
                settings();
                break;
            default:
                System.out.println("Invalid Choice : " + selectedId);
        }

    }

    private void settings() {
        System.out.println("Updating Search Data printing Result. Please Select one of the following items number : ");

        System.out.println("1-) Colorful Print (For any Java IDE)");
        System.out.println("2-) Normal Print (For any Java IDE)");
        System.out.println("2-) Normal Print (For any Java IDE)");
      /*  try {
            int selectedId= scanner.nextInt();
           if (selectedId <= 0 || selectedId > processList.size()) {
                throw new InvalidNumberException(selectedId);
            }
            return selectedId;
        } catch (NumberFormatException e) {
            printTodoInputError();
            return selectProcess();
        } catch (InvalidNumberException e) {
            printTodoInputError(e.getMessage());
            return selectProcess();
        }
*/


    }

    private void printAllData() {

        String extraText = "";

        List<String> list = database.getList();

        if (list.size() == 0) {
            extraText = "(Not found any data)";
        }
        System.out.println("--> Print All Data :" + extraText);
        System.out.println("_____________________");

        for (int i = 0; i < list.size(); i++) {
            System.out.print("|   ");
            System.out.print((i + 1) + "-) " + list.get(i));
            if (i < list.size() - 1) {
                System.out.println();
            }
        }
    }


    private void add() {
        System.out.print("Type to add data : ");
        String data = getInputText();
        database.add(data);
    }

    private void removeAll() {
        database.removeAll();
    }

    private void remove() {
        System.out.print("Type to remove data : ");
        String data = getInputText();
        database.remove(data);
    }

    private void search() {
        System.out.print("Type to search data : ");
        String data = getInputText();
        List<String> foundItems = searchItemFromList(data, database.getList());
        Utility.printResult(data, foundItems);

    }

    private String getInputText() {
        return scanner.nextLine();
    }


    private void printProcess() {
        System.out.println("PROCESS LIST  :");
        for (int i = 0; i < processList.size(); i++) {
            System.out.println((i + 1) + "-) " + processList.get(i));
        }
        System.out.print("Please type the number of process :");
    }


    private int selectProcess() {
        try {
            String inputText = scanner.nextLine();
            int selectedId = -1;
            if (inputText.equalsIgnoreCase("exit")) {
                System.out.println("Exiting from the program...");
                return -1;
            } else {
                selectedId = Integer.parseInt(inputText);
            }
            if (selectedId <= 0 || selectedId > processList.size()) {
                throw new InvalidNumberException(selectedId);
            }
            return selectedId;
        } catch (NumberFormatException e) {
            printTodoInputError();
            return selectProcess();
        } catch (InvalidNumberException e) {
            printTodoInputError(e.getMessage());
            return selectProcess();
        }

    }

    private void printTodoInputError() {
        printTodoInputError("");
    }

    private void printTodoInputError(String extraMsg) {
        if (!extraMsg.equalsIgnoreCase("")) {
            extraMsg += " .";
        }
        System.out.println(extraMsg + "Please type a number between 1-" + processList.size());
    }


    private List<String> searchItemFromList(String text, List<String> list) {
        List<String> foundListItems = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean itemFound = isListItemContainsSearchingWords(0, text, list.get(i));
            if (itemFound) {
                foundListItems.add(list.get(i));
            }
        }
        return foundListItems;
    }

    private boolean isListItemContainsSearchingWords(int index, String text, String item) {
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

    private void printMinorDivideDesign() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }

    private void printMajorDivideDesign() {
        System.out.println("**************************************************");
    }
}
