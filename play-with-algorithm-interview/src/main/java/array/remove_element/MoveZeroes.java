package array.remove_element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *   输入: [0,1,0,3,12]
 *   输出: [1,3,12,0,0]
 */
public class MoveZeroes {

    /**
     * 借助新列表
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public static void solution1(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();

        // 将 vec 中所有非 0 元素放入 nonZeroElements中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements.add(nums[i]);
            }
        }

        // 将 nonZeroElements 中的所有元素依次放入到 nums 开始的位置
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        // 将 nums 剩余的位置放置为 0
        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    /**
     * 不借助辅助空间，原地排序
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public static void solution2(int[] nums) {
        // 标识临界索引
        int k = 0;
        
        // 第一次完全遍历，将非 0 元素填充到前面，同时维护 k
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // 从 k 开始遍历，填充 0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 通过交换，不需要最后的填充 0 操作
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public static void solution3(int[] nums) {
        // k 指向当前第一个 0 元素
        int k = 0;
        // 完全遍历，如果遇到非 0 元素，和 k 指向的 0 元素交换，k++
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, k);
                k++;
            }
        }
    }

    /**
     * 在 solution3 的基础上避免了如果没有遇到 0 元素，k 和 i 同步前进，需要自己和自己交换的操作
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public static void solution4(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {   // k、i 不相等才交换
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        solution4(arr);
        System.out.println(Arrays.toString(arr));
    }
}
