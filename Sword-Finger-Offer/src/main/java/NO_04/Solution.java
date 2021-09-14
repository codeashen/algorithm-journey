package NO_04;

/**
 * [剑指 Offer 04] 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * 线性查找
 * 时间复杂度: O(N + M)
 * 空间复杂度: O(1)
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}
