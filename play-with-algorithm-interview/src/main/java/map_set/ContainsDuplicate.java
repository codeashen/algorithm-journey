package map_set;

import java.util.HashSet;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int item : nums) {
            if (set.contains(item))
                return true;
            set.add(item);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));  // true
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));  // false
        System.out.println(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));  // true
    }
}
