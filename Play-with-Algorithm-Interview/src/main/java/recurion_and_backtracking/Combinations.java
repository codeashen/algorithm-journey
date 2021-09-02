package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 时间复杂度: O()
 * 空间复杂度: O()
 */
public class Combinations {

    class Solution {
        private List<List<Integer>> res;  // 存放结果

        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            generateCombinations(n, k, 1, new LinkedList<>());
            return res;
        }

        /**
         * 求解 C(n,k)，当前已经找到的组合存储在 list 中，需要从 start 开始搜索新的元素
         *
         * @param n     区间大小 [1...n]（固定）
         * @param k     求 k 个元素的组合（固定）
         * @param start 从 start 开始往后找（递增）
         * @param list  存放组合元素（元素个数递增）
         */
        private void generateCombinations(int n, int k, int start, LinkedList<Integer> list) {
            // 如果已经找到了 k 个元素，保存返回
            if (list.size() == k) {
                res.add((List<Integer>) list.clone());
                return;
            }

            // 在 [start...n] 的区间内选出元素作为第 list.size + 1 个元素
            for (int i = start; i <= n; i++) {
                list.addLast(i);    // 向组合中加入一个元素
                generateCombinations(n, k, i + 1, list);  // 继续递归
                list.removeLast();  // 回溯，遍历下一个
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();

        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1));
    }
}
