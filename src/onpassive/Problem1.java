package onpassive;

public class Problem1 {
    /**
     * Question: Problem is to print string based on input number considering following scenarios:
     * 1) If number ends with 0, print "zero"
     * 2) If number ends with 5, print "five"
     * 3) If number is even and doesn't end with 0, print "even"
     * 4) If number is odd and doesn't end with 5, print "odd"
     */
    public static String number_cardinality( Integer my_number ) {
       String numStr = my_number.toString();
       String lastNumStr = String.valueOf(numStr.charAt(numStr.length()-1));

       int lastChar = Integer.parseInt(lastNumStr);

       if(lastChar==0) return "zero";
       else if (lastChar== 5) return "five";

       if(lastChar%2==0 && lastChar!=0) return "even";
       if(lastChar%2 != 0 && lastChar!=5 ) return "odd";

       return "";
    }

    public static void main(String[] args) {
        System.out.println(number_cardinality(17));
    }
}
