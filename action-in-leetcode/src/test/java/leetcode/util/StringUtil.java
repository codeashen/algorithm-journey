package leetcode.util;

public class StringUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 获取字符串 s 中第一个出现的整数数字，没有返回 0
     */
    public static int getInt(String s) {
        if (isBlank(s)) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (num > 0) {
                break;
            }
        }
        return num;
    }

    /**
     * 返回字符串序列中第一个不为空的
     */
    public static String getNotNull(String... items) {
        for (String item : items) {
            if (!isBlank(item)) {
                return item;
            }
        }
        return "";
    }
}
