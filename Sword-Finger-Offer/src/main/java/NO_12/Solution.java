package NO_12;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * <p>
 * 回溯法
 * 时间复杂度: 复杂
 * 空间复杂度: O(K), 其中 K 表示单词长度，递归深度不会超过单词长度
 */
class Solution {

    // 记录 memo[x][y] 是否在已经匹配的路径上
    private boolean[][] memo;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        memo = new boolean[row][col];
        // 每一个点都能作为起点，所以遍历矩阵选取起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 任一起点匹配成功则成功
                if (dfs(board, i, j, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 递归考察矩阵 board 的 (x, y) 位置是否等于 word[k]，
     * 递归结束到 word 考察完全部匹配则返回 true，否则返回 false
     */
    private boolean dfs(char[][] board, int x, int y, char[] word, int k) {
        if (x >= board.length || x < 0              // 横坐标越界
                || y >= board[0].length || y < 0    // 纵坐标越界
                || memo[x][y]                       // 路径上已经匹配过了
                || board[x][y] != word[k])          // 本节点不匹配
            return false;

        // 如果匹配到最后一个字符了，返回匹配成功
        if (k == word.length - 1)
            return true;

        // 还没到终点，继续匹配下一个
        memo[x][y] = true;  // 记录本节点在在改路径下已经匹配过了
        boolean res = dfs(board, x + 1, y, word, k + 1)
                || dfs(board, x - 1, y, word, k + 1)
                || dfs(board, x, y + 1, word, k + 1)
                || dfs(board, x, y - 1, word, k + 1);
        memo[x][y] = false; // 回溯
        return res;
    }
    
}