package segmenttree;

/**
 * 线段树基本实现
 *
 * @param <E>
 */
public class SegmentTree<E> {

    /**
     * 线段树对应的数组
     */
    private E[] tree;
    /**
     * 存放数据的数组
     */
    private E[] data;
    /**
     * 融合器用于融合左右孩子得到父节点的值
     */
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        /*
         * 假设区间有 n 个元素，
         * 如果 n = 2^k，则只需要大概 2n 的空间
         * 如果 n = 2^k + 1，则需要大概 4n 的空间，比上一种情况再多一行叶子节点（空间浪费）
         */
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建表示区间 [l...r] 的线段树
     *
     * @param treeIndex 构建线段树的位置
     * @param l         构建线段树的区间左边界
     * @param r         构建线段树的区间右边界
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        // 递归退出条件
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        
        // 计算左右孩子所在的索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        
        int mid = l + (r - l) / 2;  // 求 l 和 r 的平均数，不用 (l + r) / 2 防止整型溢出
        // 递归创建左右子树根节点对应的线段树
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        
        // 综合左右子树获得根节点的值（不同业务有不同实现）
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int size() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
