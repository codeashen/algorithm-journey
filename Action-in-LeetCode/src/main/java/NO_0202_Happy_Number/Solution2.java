package NO_0202_Happy_Number;

import java.util.HashSet;

/**
 * 0202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * <p>
 * 快慢指针
 * 时间复杂度: O(logN)
 * 空间复杂度: O(1)
 */
class Solution2 {
    public boolean isHappy(int n) {
        // 定义快慢指针
        int slow = n;
        int fast = getNext(n);
        
        // 快指针先到达 1（快乐数），或者快慢指针重叠（循环），结束
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);           // 满指针走一步
            fast = getNext(getNext(fast));  // 快指针走两步
        }
        return fast == 1;
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