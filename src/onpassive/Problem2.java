package onpassive;

public class Problem2 {

    /**
     * Question: You have a method that takes an array of passwords and check string.
     * You have to verify if all the passwords in password array comply with rules
     * Also have to check if check string is in valid format or not.
     * Note: I forgot the exact rules for this.
     */

    public static String password(String[] passwords, String checkString) {
        String bestPassword = "";
        if (isCheckStringProper(checkString)) return "";

        for(String password: passwords) {
            if(verifyPassword(password)) bestPassword = password;
        }

        return bestPassword;
    }

    public static void main(String[] args) {
        String[] passwords = {"", "", ""};
        String checkString = "";
        System.out.println(password(passwords, checkString));
    }

    public static int verifyDigit(String firstChar) {
        try {
            return Integer.parseInt(firstChar);
        } catch (ArithmeticException e) {
            return -1;
        }
    }

    public static boolean verifyMiddleChars(String middleChars) {
        for(int i=0; i<middleChars.length(); i++) {
            try {
                Integer.parseInt(String.valueOf(middleChars.charAt(i)));
                return false;
            } catch (ArithmeticException e) {
            }
        }

        return true;
    }

    public static boolean isCheckStringProper(String checkString) {
        //Rule 1
        String firstChar = String.valueOf(checkString.charAt(0));
        if(verifyDigit(firstChar) == -1) return false;

        //Rule 2
        String mid3Chars = checkString.substring(1, checkString.length() - 1);
        if(!verifyMiddleChars(mid3Chars)) return false;

        //Rule 3
        String lastChar = String.valueOf(checkString.charAt(checkString.length()-1));
        if(verifyDigit(lastChar) == -1) return false;

        return true;
    }

    public static boolean verifyPassword (String password) {
        String firstChar = String.valueOf(password.charAt(0));
        int firstDigit = verifyDigit(firstChar);
        int upperCaseCount = 0;
        for(int i=0; i<password.length(); i++) {
            String value = String.valueOf(password.charAt(i));
            if(value.equals(value.toUpperCase())) upperCaseCount++;
        }
        if(upperCaseCount != firstDigit) return false;

        String lastChar = String.valueOf(password.charAt(password.length()-1));
        int lastDigit = verifyDigit(lastChar);
        for(int i=0; i<password.length(); i++) {
            String value = String.valueOf(password.charAt(i));
            /** Time's up so submitting as it is*/
        }



        return true;
    }
}
