package model;

public class RegexCheck {

    //String
    //data

    public static boolean checkInt(String data) {

        return data.matches("\\d+");
    }

    public static boolean checkDate(String data) {

        String pattern = "(?:\\d{2}-){2}\\d{4}";

        return data.matches(pattern);
    }

    public static boolean checkString(String data) {

        String pattern = "\\p{L}*";

        return data.matches(pattern);
    }

}
