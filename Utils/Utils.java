package Utils;

public class Utils {
    public static int COUNTER = 0; // For AutoIncrement

    public static String[] getSplitQuery(String query, String delimeter) {
        return query.trim().split(delimeter);
    }

    public static String removeBrackets(String props) {
        return props.replaceAll("[\\(\\)]", "");
    }
}
