package array;

/**
 * 生成数组工具类
 */
public class ArrayGenUtil {

    private ArrayGenUtil() {
    }

    /**
     * 生成随机数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        return arr;
    }

    /**
     * 生成有序数组
     */
    public static Integer[] generateOrderedArray(int n) {
        assert n > 0;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}