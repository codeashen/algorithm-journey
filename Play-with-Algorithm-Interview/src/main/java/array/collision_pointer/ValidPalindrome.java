package array.collision_pointer;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class ValidPalindrome {

    /**
     * 指针对撞
     * 时间复杂度 O(n)
     * 空间复杂的 O(1)
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !isLetter(s.charAt(i))) {
                i++;
            }
            while (j > i && !isLetter(s.charAt(j))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            } 
        }
        return true;
    }

    /**
     * 验证是不是一个有效字符
     */
    private static boolean isLetter(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >= '0' && x <= '9');
    }
    
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = ".,";
        String str4 = "";
        String str5 = "0P";
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));
        System.out.println(isPalindrome(str4));
        System.out.println(isPalindrome(str5));
    }
}
