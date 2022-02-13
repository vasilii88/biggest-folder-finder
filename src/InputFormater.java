import java.text.DecimalFormat;

public class InputFormater {

    public static String getHumanViewOfSize(long size) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (size <= 1024 && size >= 0) {
            return size + " b";
        }

        if (size > 1024 && size < 1024 * 1024) {
            return decimalFormat.format(size / 1024.00) + " Kb";
        }

        if (size >= 1024 * 1024 && size < 1024 * 1024 * 1024) {
            return decimalFormat.format(size / 1048576.00) + " Mб";
        }
        if (size >= 1024 * 1024 * 1024) {
            return decimalFormat.format(size / 1073741824.00) + " Г";
        }

        return String.valueOf(size);
    }

    public static long getLimitFromString(String limit) {

        String strDidital = limit.replaceAll("\\D","");
        String str = limit.replaceAll("\\d","");

            if (str.equals("b")) {
                return Long.parseLong(strDidital);
            }

            if (str.equals("Kb")) {
                return Long.parseLong(strDidital) * 1024l;
            }

            if (str.equals("Mb")) {
                return Long.parseLong(strDidital) * 1048576l;
            }

            if (str.equals("G")) {
                return Long.parseLong(strDidital) * 1073741824l;
            }
            return -1;
        }

}