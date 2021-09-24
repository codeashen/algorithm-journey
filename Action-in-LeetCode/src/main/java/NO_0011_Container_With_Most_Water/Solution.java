package NO_0011_Container_With_Most_Water;

/**
 * 0011. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * 双指针对撞
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(area, getArea(height, l, r));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
    
    // 求容积
    private int getArea(int[] height, int l, int r) {
        return (r - l) * Math.min(height[l], height[r]);
    }
}