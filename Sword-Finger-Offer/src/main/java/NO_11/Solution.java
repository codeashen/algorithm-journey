package NO_11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 二分搜索法
 * 时间复杂度: O(logN)
 * 空间复杂度: O(1)
 */
class Solution {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {  // min 在左边
                r = mid;
            } else if (numbers[mid] > numbers[r]){  // min 在右边
                l = mid + 1;
            } else {   // numbers[mid] == numbers[r]
                r--;
            }
        }
        return numbers[l];
    }
}
