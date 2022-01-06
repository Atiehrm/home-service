package ir.maktab.util;

/**
 * @author arm
 */
public class ValidationUtil {
    public static boolean isNumeric(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        }
        throw new RuntimeException("number is not integer number");
    }

    public static boolean isAlphabetic(String input) {
        if (input.matches("[a-zA-Z]+")) {
            return true;
        }
        throw new RuntimeException("name is not alphabetic");
    }

    public static boolean isValidEmail(String input) {
        if (input.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) { // permitted by RFC 5322
            return true;
        }
        throw new RuntimeException("email is not valid ");
    }

    public static boolean isValidNationalCode(String input) {
        if (input.matches("^([0-9]){10}$")) {
            return true;
        }
        throw new RuntimeException("nationalCode is not valid ");
    }

    public static boolean isValidPassword(String input) {
        if (input.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8}$")) {
            return true;
        }
        throw new RuntimeException("password must be less than 8 chars,include uppercase,lowercase,no whitespace");
    }
}
