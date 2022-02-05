import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static boolean regex(String format, String value) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static void printError(String error) {
        System.out.println("================ Error ================");
        System.out.println(error);
        System.out.println("=======================================");
    }

    public static String validation(String value) {
        String error = "";
        try {
            boolean match = regex("^[0-9]+$", value);
            if (!match) {
                throw new InputMismatchException("Hanya boleh berupa angka");
            }
        } catch (InputMismatchException e) {
            error = e.toString();
        }
        return error;
    }
}
