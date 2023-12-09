package synechron_adib_bank.interview1;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    /**
     * Question: Find unique elements from 2 strings.
     */

    public static void main (String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "geeksquiz";

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i=0; i<str1.length(); i++) {
            charCountMap.put(str1.charAt(i), 1);
        }

        for (int i=0; i<str2.length(); i++) {
            Character key = str2.charAt(i);
            if(charCountMap.containsKey(key)) {
                int count = charCountMap.get(key);
                charCountMap.put(key, count+1);
            }
            else
                charCountMap.put(key, 1);
        }

        for (Map.Entry<Character, Integer> entry: charCountMap.entrySet()) {
            if(entry.getValue()==1) {
                System.out.println(entry.getKey());
            }
        }

    }
}
