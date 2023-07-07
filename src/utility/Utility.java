package utility;

import java.util.List;

public class Utility {
    public static void print(String text) {
        System.out.print(text);
    }

    public static void nextLine() {
        System.out.println();
    }

    public static void printSpecial(int index, String text, String foundItem) {
        StringBuilder tb = new StringBuilder(text);
        StringBuilder fib = new StringBuilder(foundItem);
        for (int i = 0; i < foundItem.length(); i++) {

            if ((index < text.length()) && (Character.toLowerCase(tb.charAt(index)) == Character.toLowerCase(fib.charAt(i)))) {
                String specialText = String.valueOf(fib.charAt(i));
                specialText = getRangedTextRequestedColor(specialText, ConsoleColors.GREEN_BOLD_BRIGHT, ConsoleColors.WHITE);
                print(specialText);

                String newFoundItem = fib.substring(i + 1, fib.length());
                printSpecial(index + 1, text, newFoundItem);
                return;
            } else {
                print(fib.charAt(i) + "");
            }
        }
    }

    public static String getRangedTextRequestedColor(String requestedColorfulText, String requestedColor, String standartTextColor) {
        return requestedColor + requestedColorfulText + standartTextColor;
    }

    public static void printResult(String searchText, List<String> foundItems) {
        if (foundItems.size() == 0) {
            Utility.print("Not found any thing as searched");
        }
        for (String tmp : foundItems) {
            Utility.nextLine();
            print("-> ");
            Utility.printSpecial(0, searchText, tmp);
        }
    }
}
