import data.Database;
import utility.PrintableConfiguration;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBar {

    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();
    private final List<String> processList = new ArrayList<>();
    private final List<String> settingOptionList = new ArrayList<>();

    public SearchBar() {
        fillProcessList();
        fillSettingOptionList();
    }

    private void fillProcessList() {
        processList.add("Print All Data ");
        processList.add("Add Data ");
        processList.add("Search Data");
        processList.add("Remove Single Data ");
        processList.add("Remove All Data ");
        processList.add("Update Searching-Printing Settings");
    }

    private void fillSettingOptionList() {
        settingOptionList.add("Get Colors for IDE");
        settingOptionList.add("Get Colors for CMD");
        settingOptionList.add("Get Standart Colors");
    }

    public void start() {
        int result = 1;
        while (result != -1) {
            printDivideDesign();
            printDivideDesign();
            Utility.nextLine();
            printOptions("Process List".toUpperCase(), processList);
            result = selectProcess(processList);
            if (result != -1) {
                Utility.nextLine();
                printDivideDesign();
                Utility.nextLine();
                doSelectedProcess(result);
            }
            Utility.nextLine();
            Utility.nextLine();

        }

    }

    private void doSelectedProcess(int selectedId) {
        switch (selectedId) {
            case 1:
                printAllData();
                break;
            case 2:
                add();
                break;
            case 3:
                search();
                break;
            case 4:
                remove();
                break;
            case 5:
                removeAll();
                break;
            case 6:
                settings();
                break;
            default:
                System.out.println("Invalid Choice : " + selectedId);
        }

    }


    private void printAllData() {

        String extraText = "";

        List<String> list = database.getList();

        if (list.size() == 0) {
            extraText = " (Not found any data)";
        }
        printProcessTitle(processList.get(0) + extraText);

        for (int i = 0; i < list.size(); i++) {
            System.out.print("|   ");
            System.out.print((i + 1) + "-) " + list.get(i));
            if (i < list.size() - 1) {
                System.out.println();
            }
        }
    }


    private void add() {
        printProcessTitle(processList.get(1));
        System.out.print("Type to add data : ");
        String data = getInputText();
        database.add(data);
    }

    private void search() {
        printProcessTitle(processList.get(2));
        System.out.println("!!! NOTE : If you get meaningless text please go to Option 6 (\"Update Print Settings\")" +
                "\nand update printable Options for your working environment.");
        System.out.print("Type to search data : ");
        String data = getInputText();
        List<String> foundItems = searchItemFromList(data, database.getList());
        Utility.printResult(data, foundItems);

    }

    private void remove() {
        printProcessTitle(processList.get(3));
        System.out.print("Type to remove data : ");

        String data = getInputText();
        database.remove(data);
    }

    private void removeAll() {
        printProcessTitle(processList.get(4));
        database.removeAll();
    }

    private void settings() {
        printProcessTitle(processList.get(5));
        printSettingOptions();
        updateSettings();

    }

    private void printSettingOptions() {
        System.out.println("Updating Search Data printing Result. Please Select one of the following items number : ");
        printOptions("Setting Option List ".toUpperCase(), settingOptionList);

    }

    private void updateSettings() {
        int result = selectProcess(settingOptionList);
        PrintableConfiguration.updatePrintableService(result);
    }


    private String getInputText() {
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("You cannot add empty text. Please type something");
            return getInputText();
        }
        return input;
    }


    private void printOptions(String title, List<String> optionList) {
        System.out.println(title + "  :");
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 1) + "-) " + optionList.get(i));
        }
        Utility.nextLine();
        System.out.print("Please type the number of process :");
    }


    private int selectProcess(List<String> optionList) {
        try {
            String inputText = scanner.nextLine();
            int selectedId = -1;
            if (inputText.equalsIgnoreCase("exit")) {
                System.out.println("Exiting from the program...");
                return -1;
            } else {
                selectedId = Integer.parseInt(inputText);
            }
            if (selectedId <= 0 || selectedId > optionList.size()) {
                throw new InvalidNumberException(selectedId);
            }
            return selectedId;
        } catch (NumberFormatException e) {
            printTodoInputError(optionList.size());
            return selectProcess(optionList);
        } catch (InvalidNumberException e) {
            printTodoInputError(e.getMessage(), optionList.size());
            return selectProcess(optionList);
        }

    }

    private void printTodoInputError(int listSize) {
        printTodoInputError("", listSize);
    }

    private void printTodoInputError(String extraMsg, int listSize) {
        if (!extraMsg.equalsIgnoreCase("")) {
            extraMsg += " .";
        }
        System.out.println(extraMsg + "Please type a number between 1-" + listSize);
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

    private void printDivideDesign() {
        System.out.println("**************************************************");
    }

    private void printProcessTitle(String title) {
        System.out.println("=> " + title + ":");
        System.out.println("------------------");
    }
}
