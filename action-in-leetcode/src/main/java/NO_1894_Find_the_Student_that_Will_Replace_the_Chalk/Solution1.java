package NO_1894_Find_the_Student_that_Will_Replace_the_Chalk;

import com.journey.algorithm.common.annotation.Complexity;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 * <p>
 * 求和遍历
 */
@Complexity(time = "n", space = "1")
class Solution1 {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int item : chalk)
            total += item;
        k %= total;

        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k)
                return i;
            k -= chalk[i];
        }
        return -1;
    }
}
