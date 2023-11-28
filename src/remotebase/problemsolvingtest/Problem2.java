package remotebase.problemsolvingtest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'mergePalindromes' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    //Solution:
    // 1. Find all palindromes of a string or substrings of s1,s2(shuffled variations too)
    // 2. Store in a set
    // 3. Get longest from the set
    // 4. Try merging them and make a new set of merged ones
    // 5. Pick the longest one from the set

    public static boolean checkPalindrome(String str) {
        for(int i=0;i<=str.length()/2;i++)
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        return true;
    }

    public static Set<String> findAllPalindromeSubstrings(String s) {
        Set<String> stringPalindromes = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {

                String subStr = s.substring(i, j);
                if(checkPalindrome(subStr)) {
                    stringPalindromes.add(subStr);
                }
            }
        }

        return stringPalindromes;
    }

    public static String getLongestString(Set<String> strSet) {
        String longestString = "";
        int maxLength = -1;
        for(String s : strSet) {
            if(s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }

        return longestString;
    }
    public static String mergePalindromes(String s1, String s2) {
        String mergedPalindromes = "";

        //To store all palindromes of s1 and s2 respectively
        Set<String> s1Palindromes = findAllPalindromeSubstrings(s1);
        Set<String> s2Palindromes = findAllPalindromeSubstrings(s2);

        return mergedPalindromes;
    }

}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        String result = Result1.mergePalindromes(s1, s2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
