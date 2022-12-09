package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

    /**
     * 回溯法，二叉树
     * 分叉为宣布选取元素 candidates[i]，有两种选择
     */
    class Solution {
        private List<List<Integer>> res;  // 存放结果

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            res = new ArrayList<>();
            dfs(candidates, target, 0, new LinkedList<>());
            return res;
        }

        /**
         * 考虑将 candidates[index] 加入组合 list 中，使得组合的总和为 target
         */
        private void dfs(int[] candidates, int target, int index, LinkedList<Integer> list) {
            if (index >= candidates.length)
                return;
            if (target == 0) {
                res.add(new LinkedList<>(list));
                return;
            }

            // 情况一：不包含 index 元素
            dfs(candidates, target, index + 1, list);
            // 情况二：包含 index 元素，加入到 list，需要回溯
            if (candidates[index] <= target) {
                list.addLast(candidates[index]);
                dfs(candidates, target - candidates[index], index, list);
                list.removeLast();
            }
        }
    }

    /**
     * 回溯法，多叉树
     * 分叉为 candidates 的元素个数，每次选 i 极其之后的元素
     */
    class Solution2 {
        private List<List<Integer>> res;  // 存放结果

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            res = new ArrayList<>();
            Arrays.sort(candidates);  // 排序，方便剪枝
            dfs(candidates, target, 0, new LinkedList<>());
            return res;
        }

        /**
         * 考虑将 candidates 数组 start 及以后的元素加入组合 list 中，使得组合的总和为 target
         */
        private void dfs(int[] candidates, int target, int start, LinkedList<Integer> list) {
            if (target == 0) {
                res.add(new LinkedList<>(list));
                return;
            }
            
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target)  // 后面的单个数字都大于 target，没必要考虑了
                    break;
                list.addLast(candidates[i]);
                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, target - candidates[i], i, list);
                list.removeLast();  // 重置状态
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new CombinationSum().new Solution2();

        int[] candidates1 = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(candidates1, 7));
    }
    
}
