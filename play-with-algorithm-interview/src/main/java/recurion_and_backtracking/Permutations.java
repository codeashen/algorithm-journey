package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    
    class Solution {
        private List<List<Integer>> res;  // 保存排列结果
        private boolean[] used;           // 记录 nums[i] 是否已经在排列中

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            used = new boolean[nums.length];
            // 初始调用，目前排列中有 0 个元素
            generatePermutation(nums, 0, new LinkedList<>());
            return res;
        }

        /**
         * list 中保存了一个有 count 个元素的排列，向这个排列的末尾添加第 count + 1 个元素,
         * 获得一个有 count + 1 个元素的排列
         *
         * @param nums  原始数组
         * @param count 已经加入到 list 中排列的元素个数
         * @param list  存放了有 count 个元素的排列
         */
        private void generatePermutation(int[] nums, int count, LinkedList<Integer> list) {
            // 如果排列中保存了全部个数，直接保存结果返回
            if (count == nums.length) {
                res.add(new LinkedList<>(list));  // 必须存副本
                return;
            }

            // 遍历所有元素
            for (int i = 0; i < nums.length; i++) {
                // 如果没参与过排列，将其加入到排列中，并记录使用过
                if (!used[i]) {
                    list.addLast(nums[i]);
                    used[i] = true;
                    generatePermutation(nums, count + 1, list);  // 将下一个元素放到排列中
                    // 回溯，将元素复位，再进行下一轮循环
                    used[i] = false;
                    list.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.permute(nums1));
        int[] nums2 = {1, 2};
        System.out.println(solution.permute(nums2));
        int[] nums3 = {1};
        System.out.println(solution.permute(nums3));
    }
}
