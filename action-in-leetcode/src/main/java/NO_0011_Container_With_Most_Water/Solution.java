package NO_0011_Container_With_Most_Water;

import com.journey.algorithm.common.annotation.Complexity;
import com.journey.algorithm.common.annotation.LeetCode;

@LeetCode(id = 11, title = "盛最多水的容器", solution = "双指针碰撞")
@Complexity(time = "n", space = "1")
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