package data;

import java.util.ArrayList;
import java.util.List;

public class Database {
    static List<String> list = new ArrayList<>();

    public List<String> getList() {
        if (list.size() == 0) {
            fillList();
        }
        return list;
    }

    public void fillList() {
        list.add("Thirdparty/g2o/g2o/core/optimization_algorithm_gauss_newton.cpp");
        list.add("Karadeniz Technical University");
        list.add("Furkan CETIN");
        list.add("Ahmet Emin SAGLIK");
        list.add("Java developer");
        list.add("I scream, you scream, we all scream for ice cream");
    }
}
