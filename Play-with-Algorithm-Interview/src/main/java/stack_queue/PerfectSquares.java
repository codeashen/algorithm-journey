package stack_queue;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * 时间复杂度: O()
 * 空间复杂度: O()
 */
public class PerfectSquares {

    /**
     * 用图论的 BFS
     * 时间复杂度: O(2^n)
     * 空间复杂度: O(2^n)
     */
    class Solution {
        public int numSquares(int n) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(n);

            int step = 0;  // 经过几步到当前层级
            while (!queue.isEmpty()) {
                int currentBreadthSize = queue.size();  // 当前层级的节点数
                for (int i = 0; i < currentBreadthSize; i++) {  // 遍历当前层级的节点
                    Integer num = queue.poll();
                    if (num == 0) return step;  // 当前层级出现 0 节点，说明可达了，返回经过步数 step
                    
                    // 如果不是 0 节点，将该节点的下一层级节点入队列（但不不在本轮遍历，下一轮才到它们）
                    for (int j = 1; num - j * j >= 0; j++) {
                        queue.offer(num - j * j);
                    } 
                }
                step++;  // 一个层级的遍历完了，step+1 进入下一层级
            }

            throw new IllegalStateException("No Solution.");
        }
    }

    /**
     * 用图论的 BFS 改进
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    class Solution2 {
        public int numSquares(int n) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(n);
            
            // 记录节点是否被访问过，visited[i] == true 表示节点 i 入过队列
            boolean[] visited = new boolean[n + 1];
            visited[n] = true;

            int step = 0;  // 经过几步到当前层级
            while (!queue.isEmpty()) {
                int currentBreadthSize = queue.size();  // 当前层级的节点数
                for (int i = 0; i < currentBreadthSize; i++) {  // 遍历当前层级的节点
                    Integer num = queue.poll();
                    if (num == 0) return step;  // 当前层级出现 0 节点，说明可达了，返回经过步数 step

                    // 如果不是 0 节点，将该节点的下一层级节点入队列（但不不在本轮遍历，下一轮才到它们）
                    for (int j = 1; num - j * j >= 0; j++) {
                        // 还没入过队列则加入队列并标记，否则说明之前就已经访问过了，并且比这条路短
                        int next = num - j * j;
                        if (next == 0) 
                            return step + 1;   // 入队前判断下一节点是否为 0，如果是说明再走一步就到了
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
                step++;  // 一个层级的遍历完了，step+1 进入下一层级
            }

            throw new IllegalStateException("No Solution.");
        }
    }


    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();

        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
    }
}

