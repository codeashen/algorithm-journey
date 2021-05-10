package sort.advance;

/**
 * 三路快速排序法
 * <p>
 * 双路快速排序基础上进一步优化，partition 操作将元素分成三个部分，左中右分别为小于、等于、大于标的的元素，
 * 下次只需要对小于和大于的部分进行递归，减少了处理的元素个数，对存在大量重复元素的情况处理更快。
 */
public class QuickSort3 {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用快速排序,对数组 arr [l, r] 区间进行排序
     * 
     *     阶段                        区间详情                                     状态
     * +---------+----------------------------------------------------+---------------------------+
     * |         |     [v][e                                 *]*      |                           |
     * |   init  |      ↑  ↑                                 ↑ ↑      |                           |
     * |    ↓    |    l,lt i                                 r gt     |                           |
     * +---------+----------------------------------------------------+                           |
     * |         |     [v][   <v  *][   ==v   ][e   ][*  >v  *]       |    arr[l+1, lt] < v       |
     * |partition|      ↑         ↑             ↑     ↑      ↑        |    arr[lt+1, i-1] == v    |
     * |    ↓    |      l         lt            i     gt     r        |    arr[gt, r] > v         |
     * +---------+----------------------------------------------------+                           |
     * |         |     [v][     <v    *][  ==v  ][*    >v    *]       |                           |
     * |  after  |      ↑             ↑           ↑          ↑        |                           |
     * |    ↓    |      l             lt         i,gt        r        |                           |
     * +---------+----------------------------------------------------+---------------------------+
     * |  swap   |     [*     <v    ][v    ==v  ][*    >v    *]       |    arr[l, lt-1] < v       |
     * |  l, lt  |      ↑             ↑           ↑          ↑        |    arr[lt, gt-1] == v     |
     * |         |      l             lt         i,gt        r        |    arr[gt, r] > v         |
     * +---------+----------------------------------------------------+---------------------------+
     *
     * @param arr 待排序数组
     * @param l   排序左区间
     * @param r   排序右区间
     */
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 在 arr[l, r] 中随机选择一个值作为分界标的
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];

        // 以下操作可结合文档注释理解
        // 1. 初始阶段(init)
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        // 2. 划分阶段(partition), 逐个考察元素
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;   // 注意，此时从待考察区间右端元素换到了 i 处，不需要 i--
            } else {
                i++;
            }
        }
        // 3. 结束划分(after), 交换l、lt位置元素
        swap(arr, l, lt);
        // 4. 递归快排小部和大部
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
