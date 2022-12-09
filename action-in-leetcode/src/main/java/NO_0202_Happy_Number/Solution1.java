package NO_0202_Happy_Number;

import java.util.HashSet;

/**
 * 0202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * <p>
 * 使用哈希集
 * 时间复杂度: O(logN)
 * 空间复杂度: O(logN)
 */
class Solution1 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            n = getNext(n);
            if (n == 1) 
                return true;    // 出现 1，返回 true
            else if (set.contains(n)) 
                return false;   // 出现循环，返回 false
            else 
                set.add(n);     // 平方和结果加到 set 中
        }
    }

    // 计算数字 a 每个数位上的数字的平方和
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int k = n % 10;
            sum += k * k;
            n /= 10;
        }
        return sum;
    }
}