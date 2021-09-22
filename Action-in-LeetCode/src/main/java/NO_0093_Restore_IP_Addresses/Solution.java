package NO_0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 0093. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * <p>
 * 回溯
 * 时间复杂度: 复杂，不会算
 * 空间复杂度: O(4)，表示需要 4 个网段，递归深度是 4
 */
class Solution {

    // 存放计算过程中的 4 个网段
    private final String[] segments = new String[4];
    // 存放最终由 4 个网段拼成的 ip 地址
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dfs(s, 0, 0);
        return res;
    }

    /**
     * 从 s 的 start 位置开始找出一个网段加入 segments 中，
     * 直到 segCount 够 4 个，并且 s 恰好用完就加入结果集中
     *
     * @param s        原始字符串
     * @param start    新网段开始位置
     * @param segCount 已经凑好的网段个数
     */
    private void dfs(String s, int start, int segCount) {
        // 递归结束条件：网段数够 4 个了
        if (segCount == 4) {
            if (start == s.length())  // 如果此时 s 正好用完，加到结果集中
                res.add(String.join(".", segments));
            return;
        }
        
        int unallocated = s.length() - start;   // 未分配的子串长度
        int needSeg = 4 - segCount;             // 还需要几个网段
        // 不够分配 或者 分配不下了，不用继续考察了，剪枝
        if (unallocated < needSeg || unallocated > needSeg * 3) 
            return;

        // 继续拼入网段，截取 s[start, i] 作为下一个网段，可以截 1~3 位，但是不能超过 s 的长度
        for (int i = start + 1; i <= Math.min(start + 3, s.length()); i++) {
            String segment = s.substring(start, i);
            int len = i - start;
            // 如果是有效网段（没有先导 0，且不大于 255）, 拼入网段
            if (!(len > 1 && segment.startsWith("0")) && (len < 3 || segment.compareTo("255") <= 0)) {
                segments[segCount] = segment;
                dfs(s, i, segCount + 1);  // 继续拼入下一个网段
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("1253"));
    }

}