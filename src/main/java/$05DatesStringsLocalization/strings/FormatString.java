package $05DatesStringsLocalization.strings;

public class FormatString {
    public static void main(String[] args) {
        String number = "36204322342";
        String format = String.format("+%.2s-", number);
        System.out.println(format);

        String code = number.substring(0, 2);
        String substring = number.substring(2, number.length());
        System.out.println(code + "-" + substring);

    }
}
