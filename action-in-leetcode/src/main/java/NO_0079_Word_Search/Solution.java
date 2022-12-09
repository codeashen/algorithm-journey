package NO_0079_Word_Search;

/**
 * 0079. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * <p>
 * 回溯
 */
class Solution {
    // used[i][j] == true 表示 board[i][j] 已经被使用
    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];
        // 选取起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从任一起点出发能找到符合的路径，就成功
                if (check(board, i, j, word, 0))
                    return true;
            }
        }
        return false;  // 所有路径都查找失败
    }

    /**
     * 从 board[i][j] 开始，匹配单词 word 从 k 到末尾的部分
     */
    private boolean check(char[][] board, int i, int j, String word, int k) {
        // 角标越界，不成功
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        // 字符已被使用，或字符不匹配，不成功
        if (used[i][j] || board[i][j] != word.charAt(k))
            return false;
        // 匹配且已经查找到单词末尾了，成功
        if (k == word.length() - 1)
            return true;

        used[i][j] = true;    // 标记已使用
        // 递归到上下左右匹配单词剩余部分，任一匹配成功则成功
        if (check(board, i + 1, j, word, k + 1)) return true;
        if (check(board, i - 1, j, word, k + 1)) return true;
        if (check(board, i, j + 1, word, k + 1)) return true;
        if (check(board, i, j - 1, word, k + 1)) return true;
        used[i][j] = false;   // 回溯，清除使用标志
        
        return false;  // 四个方向都没匹配成功，失败
    }
}