package map_set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    static class Node implements Comparable<Node> {
        public int element;
        public int index;

        public Node(int element) {
            this.element = element;
        }

        public Node(int element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.element - o.element;
        }
    }

    /**
     * 解法一: 排序 + 二分搜索
     */
    public static int[] twoSum1(int[] nums, int target) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {  // O(N)
            nodes[i] = new Node(nums[i], i);
        }
        
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.element));  // O(NlogN)
        for (int i = 0; i < nodes.length; i++) {
            int otherNodeIndex = Arrays.binarySearch(nodes, i + 1, nodes.length, 
                    new Node(target - nodes[i].element));   // O(logN)
            if (otherNodeIndex > 0) {
                return new int[]{nodes[i].index, nodes[otherNodeIndex].index};
            }
        }

        throw new IllegalArgumentException("No result");
    }

    public static int[] twoSum2(int[] nums, int target) {
        // k: nums 中元素,  v: 元素对应的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            } 
        }
        throw new IllegalArgumentException("No result");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));    // [0,1]
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6))); // [1,2]
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));    // [0,1]
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 3}, 6)));    // [0,2]
    }
}