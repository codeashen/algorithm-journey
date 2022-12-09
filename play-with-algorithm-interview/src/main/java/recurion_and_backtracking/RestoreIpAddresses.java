package recurion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

    class Solution {
        private List<String> res;  // 存放结果 
        private final int[] segments = new int[4];  // 存4个网段

        public List<String> restoreIpAddresses(String s) {
            res = new ArrayList<>();
            dfs(s, 0, 0);
            return res;
        }

        /**
         * 在字符串 s 中 start 位置开始，拼接网段构成 ip 地址，目前已经拼好了 segCount 个网段
         */
        private void dfs(String s, int start, int segCount) {
            if (segCount == 4) {  // 递归结束条件：网段数够 4 个了
                if (start == s.length())  // 如果此时 s 正好用完，加到结果中
                    res.add(concatSegments());
                return;
            }

            // i 表示要截取的网段长度，网段最大 255，三位数，所以 i <= 3
            // 截取的长度不能超过 s 总长度，所以 start + i <= s.length ==> i <= s.length() - start
            // 综上有:  i <= Math.min(3, s.length() - start)
            for (int i = 1; i <= Math.min(3, s.length() - start); i++) {
                int segment = parseSegment(s.substring(start, start + i));  // 截出网段
                if (segment != -1) {  // 如果是有效网段
                    segments[segCount] = segment;
                    segCount++;  // 拼入网段
                    dfs(s, start + i, segCount);  // 继续拼入下一个网段
                    segCount--;  // 回溯网段
                }
            }
        }

        /**
         * 辅助函数，将字符串转换为网段数字，如果不符合要求，返回 -1
         */
        private int parseSegment(String segStr) {
            if (segStr.length() > 1 && segStr.startsWith("0"))  // 判断是否有先导 0
                return -1;
            int segment = 0;
            try {
                segment = Integer.parseInt(segStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return segment <= 255 ? segment : -1;
        }

        /**
         * 辅助方法，segments 网段数组拼接成 ip 地址
         */
        private String concatSegments() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < segments.length; i++) {
                sb.append(segments[i]);
                if (i != segments.length - 1)
                    sb.append(".");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("1111"));
        System.out.println(solution.restoreIpAddresses("010010"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }
}
