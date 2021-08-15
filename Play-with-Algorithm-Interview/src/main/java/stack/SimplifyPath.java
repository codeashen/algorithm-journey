package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String item : arr) {
            switch (item) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                    break;
                default:
                    deque.addLast(item);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/").equals("/home"));
        System.out.println(simplifyPath("/../").equals("/"));
        System.out.println(simplifyPath("/home//foo/").equals("/home/foo"));
        System.out.println(simplifyPath("/a/./b/../../c/").equals("/c"));
    }
}
