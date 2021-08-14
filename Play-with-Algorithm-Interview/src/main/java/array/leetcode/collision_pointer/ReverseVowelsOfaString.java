package array.leetcode.collision_pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowelsOfaString {

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            while (i < j && !isVowel(chars[i])) {
                i++;
            }
            while (j > i && !isVowel(chars[j])) {
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    private static boolean isVowel(char x) {
        return (x == 'a') || (x == 'e') || (x == 'i') || (x == 'o') || (x == 'u') 
                || (x == 'A') || (x == 'E') || (x == 'I') || (x == 'O') || (x == 'U');
    }
    
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "leetcode";
        System.out.println(reverseVowels(s1).equals("holle"));
        System.out.println(reverseVowels(s2).equals("leotcede"));
    }
}
