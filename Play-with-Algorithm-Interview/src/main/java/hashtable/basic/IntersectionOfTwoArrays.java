package hashtable.basic;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> recordSet = new HashSet<>();
        for (int item : nums1) {
            recordSet.add(item);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int item : nums2) {
            if (recordSet.contains(item)) {
                resultSet.add(item);
            }
        }

        int[] arr = new int[resultSet.size()];
        int index = 0;
        for (Integer resultItem : resultSet) {
            arr[index++] = resultItem;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] result1 = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] result2 = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(result1));   // [2]
        System.out.println(Arrays.toString(result2));   // [9, 4]
    }
}
