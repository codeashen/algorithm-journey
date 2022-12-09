package NO_1894_Find_the_Student_that_Will_Replace_the_Chalk;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 * <p>
 * 前缀 + 二分搜索
 */
@Complexity(time = "n", space = "1")
class Solution2 {
    public int chalkReplacer(int[] chalk, int k) {
        if (chalk[0] > k)
            return 0;
        int n = chalk.length;
        for (int i = 1; i < n; i++) {
            chalk[i] = chalk[i - 1] + chalk[i];
            // 每次都检测是否超过 k，这样就不会出现计算到最后超过 int 最大值的情况了
            if (chalk[i] > k)
                return i;
        }
        k %= chalk[n - 1];

        // 使用二分搜索，最后 l 来到大于 k 的第一个索引
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 注意二分搜索的条件
            if (chalk[mid] <= k)  // 小于等于 k，都够的
                l = mid + 1;
            else
                r = mid;  // 不是 mid - 1
        }

        return l;
    }
}
