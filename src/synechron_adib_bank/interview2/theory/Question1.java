package synechron_adib_bank.interview2.theory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Question: Write a java 8 code to find numbers starting with 2 from a list of numbers
 */
public class Question1 {
    public static void main (String[] args) {
        List<Integer> numbers = Arrays.asList(21, 2, 3, 24, 5);

        List<Integer> numbersThatStartWith2 = numbers.stream()
                .filter(n1 -> String.valueOf(n1).charAt(0)=='2')
                .collect(Collectors.toList());

        System.out.println(numbersThatStartWith2);
    }
}
