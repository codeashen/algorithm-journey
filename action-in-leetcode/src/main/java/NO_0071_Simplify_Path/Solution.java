package NO_0071_Simplify_Path;

import com.journey.algorithm.common.annotation.Complexity;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0071. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 * <p>
 * 双端队列
 */
@Complexity(time = "n", space = "n")
class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String dir : dirs) {
            switch (dir) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!deque.isEmpty())
                        deque.removeLast();
                    break;
                default:
                    deque.addLast(dir);
            }
        }

        if (deque.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty())
            sb.append("/").append(deque.pop());
        return sb.toString();
    }
}