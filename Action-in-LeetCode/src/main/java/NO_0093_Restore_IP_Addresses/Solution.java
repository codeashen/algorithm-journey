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
    private List<String> res;       // 存放所有可能的 ip 地址
    private List<String> segments;  // 存放已经拼入的网段

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        segments = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    /**
     * 从 s 的 start 位置开始找出一个网段加入 segments 中，
     * 直到 segments 中够 4 个，并且 s 恰好用完就加入结果集 res 中
     *
     * @param s     原始字符串
     * @param start 新网段开始位置
     */
    private void dfs(String s, int start) {
        // 只要 segments 满 4 个了就要结束递归
        if (segments.size() == 4) {
            // 如果 s 正好用完，表示成功解析 ip，加入结果集
            if (start == s.length())
                res.add(String.join(".", segments));
            return;
        }

        int unallocated = s.length() - start;   // 剩余未分配的字符个数
        int need = 4 - segments.size();         // 还需要几个网段
        // 不够分配或者分配不下了，结束递归（剪枝）
        if (unallocated < need || unallocated > need * 3) return;

        // 继续拼入网段，长度 length 可取 1 到 Math.min(3, unallocated)
        for (int length = 1; length <= Math.min(3, unallocated); length++) {
            String segment = s.substring(start, start + length);  // 新网段
            // 判断 segment 是否为有效网段：不能有先导零且数值不大于 255
            if (!(length > 1 && segment.startsWith("0")) && Integer.parseInt(segment) <= 255) {
                segments.add(segment);  // 拼入网段
                dfs(s, start + length);  // 继续递归
                segments.remove(segments.size() - 1);  // 回溯，拿出网段
            }
        }
    }

}