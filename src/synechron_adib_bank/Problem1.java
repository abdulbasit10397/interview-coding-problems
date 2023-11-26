package synechron_adib_bank;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem1 {
    /**
     * Question: Sort a hashmap in descending order by value using Java 8 features
     */
    public static void main(String[] args) {
        Map<String, Integer> studentNameMarksMap = new HashMap<>();
        studentNameMarksMap.put("Abdul", 80);
        studentNameMarksMap.put("John", 90);
        studentNameMarksMap.put("Ruksana", 80);
        studentNameMarksMap.put("Amit", 75);
        studentNameMarksMap.put("Danish", 40);

        sortMyMap(studentNameMarksMap);
    }

    public static void sortMyMap(Map<String, Integer> studentNameMarksMap) {
        studentNameMarksMap = studentNameMarksMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                                LinkedHashMap::new));

        System.out.println(studentNameMarksMap);
    }

}
