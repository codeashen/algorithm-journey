package hashtable.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class IntersectionOfTwoArraysII {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // HashMap 记录 nums1 元素和频次
        HashMap<Integer, Integer> recordMap = new HashMap<>();
        for (int item : nums1) {
            recordMap.put(item, recordMap.containsKey(item) ? recordMap.get(item) + 1 : 1);
        }

        // 遍历 nums2 找出 map 中有的元素，加到 list中
        ArrayList<Integer> list = new ArrayList<>();
        for (int item : nums2) {
            if (recordMap.containsKey(item) && recordMap.get(item) > 0) {
                list.add(item);
                recordMap.put(item, recordMap.get(item) - 1);
            }
        }
        
        int[] arr = new int[list.size()];
        int index = 0;
        for (Integer resultItem : list) {
            arr[index++] = resultItem;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] result1 = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] result2 = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(result1));   // [2, 2]
        System.out.println(Arrays.toString(result2));   // [9, 4]
    }
}
