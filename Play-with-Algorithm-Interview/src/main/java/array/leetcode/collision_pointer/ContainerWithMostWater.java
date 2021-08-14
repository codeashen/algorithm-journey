package array.leetcode.collision_pointer;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class ContainerWithMostWater {

    /**
     * 指针碰撞思路
     */
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;

        while (i < j) {
            area = Math.max(area, getArea(height, i, j));
            // 把高度低的往中间挪
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            } 
        }

        return area;
    }

    /**
     * 求容积方法
     */
    private static int getArea(int[] height, int i, int j) {
        return (j - i) * (Math.min(height[i], height[j]));
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr2 = {1, 1};
        int[] arr3 = {4, 3, 2, 1, 4};
        int[] arr4 = {1, 2, 1};
        int[] arr5 = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(arr1) == 49);
        System.out.println(maxArea(arr2) == 1);
        System.out.println(maxArea(arr3) == 16);
        System.out.println(maxArea(arr4) == 2);
        System.out.println(maxArea(arr5) == 17);
    }
}
