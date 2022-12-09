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

    /**
     * 返回区间 [queryL, queryR] 的值
     *
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length
                || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以 treeIndex 为根, l 和 r 为左右边界的线段树里，
     * 搜索区间 [queryL, queryR] 的值
     *
     * @param treeIndex 线段树根节点索引
     * @param l         线段树左边界索引
     * @param r         线段树右边界索引
     * @param queryL    查找区间左边界
     * @param queryR    查找区间右边界
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        // 递归终止条件，区间边界和线段树边界相等，直接返回本线段树结果
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        // 计算当前线段树的左右子树索引
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            // 查询区间全在右子树，查右子树对应区间
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            // 查询区间全在左子树，查左子树对应区间
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            // 查询区间跨左右子树，分别查左右子树对应子区间
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            // 左右结果融合
            return merger.merge(leftResult, rightResult);
        }
    }

    /**
     * 将 index 位置的元素更新为 e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        data[index] = e;
        // 更新线段树
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以 treeIndex 为根, l 和 r 为左右边界的线段树里，
     * 将 index 位置的元素更新为 e
     *
     * @param treeIndex 线段树根节点索引
     * @param l         线段树左边界索引
     * @param r         线段树右边界索引
     * @param index     更新元素的索引位置
     * @param e         更新的新元素
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        // 递归结束条件，到了叶子节点了，直接更新当前节点的元素
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        // 计算当前线段树的左右子树索引
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            // 元素在右子树，去右子树更新
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            // 元素在左子树，去左子树更新
            set(leftTreeIndex, l, mid, index, e);
        }
        
        // 子树更新了，更新当前节点的值
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
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
