package data;

import java.util.ArrayList;
import java.util.List;

public class Database {
    static List<String> list = new ArrayList<>();
    boolean initialized = false;

    public List<String> getList() {
        if (!initialized) {
            fillList();
            initialized = true;
        }
        return list;
    }

    public void fillList() {
        list.add("Thirdparty/g2o/g2o/core/optimization_algorithm_gauss_newton.cpp");
        list.add("Karadeniz Technical University");
        list.add("Furkan CETIN");
        list.add("Ahmet Emin SAGLIK");
        list.add("Java Developer");
        list.add("Flutter Developer");
        list.add("I scream, you scream, we all scream for ice cream");
        list.add("3.141592653589793");
    }

    public void add(String word) {
        if (list.contains(word)) {
            System.out.print(getWordWithQuotes(word) + " has been already added.");
            return;
        }
        list.add(word);
        System.out.print(getWordWithQuotes(word) + " is added to the list");
    }

    public void remove(String word) {
        if (!list.contains(word)) {
            System.out.print(getWordWithQuotes(word) + " has not been added yet.");
            return;
        }
        list.remove(word);
        System.out.print(getWordWithQuotes(word) + " is removed from the list");
    }

    public void removeAll() {
        list.clear();
        System.out.print("All data is removed");
    }

    private String getWordWithQuotes(String word) {
        return "\"" + word + "\"";
    }
}
