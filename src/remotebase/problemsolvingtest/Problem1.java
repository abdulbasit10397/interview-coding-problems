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


class Result {

    private static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }
    public static String getString(String s) {
        String smallestString = s;

        for(int i =0; i<s.length() ; i++) {
            for(int j=1; j < (s.length()-i); j++) {
                String sOfI = String.valueOf(smallestString.charAt(j-1));
                String sOfJ = String.valueOf(smallestString.charAt(j));

                if (sOfI.compareTo(sOfJ) > 0) {
                    smallestString = swapChars(smallestString, j-1, j);
                }
            }
        }

        return smallestString;
    }
}

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.getString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
