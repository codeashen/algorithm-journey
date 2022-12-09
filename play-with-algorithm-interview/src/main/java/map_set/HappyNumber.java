package map_set;

import java.util.HashSet;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */
public class HappyNumber {
    
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            n = getSum(n);
            if (n == 1) {
                return true;
            } else if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
    }

    public static int getSum(int a) {
        int sum = 0;
        while (a > 0) {
            sum += (a % 10) * (a % 10);
            a /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));    // true
        System.out.println(isHappy(2));     // false
    }
}
