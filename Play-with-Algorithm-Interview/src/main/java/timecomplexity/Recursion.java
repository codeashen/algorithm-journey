package timecomplexity;

public class Recursion {

    // binarySearch
    private static int binarySearch(Comparable[] arr, int l, int r, int target) {
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0)
            return mid;
        else if (arr[mid].compareTo(target) > 0)
            return binarySearch(arr, l, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, r, target);
    }

    /**
     * 递归求和
     * 递归深度: n, 时间复杂度: O(n)
     */
    private static int sum(int n) {

        assert n >= 0;

        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }

    /**
     * 计算 x 的 n 次方
     * 递归深度: logn, 时间复杂度: O(logn)
     */
    private static double pow(double x, int n) {
        assert n >= 0;

        if (n == 0) {
            return 1.0;
        }

        double t = pow(x, n / 2);
        
        if (n % 2 == 1) {
            return x * t * t;
        } else {
            return t * t;
        }
    }

    /**
     * 两次调用递归函数
     * 时间复杂度不再跟递归深度成正比，而是跟递归调用次数成正比
     * 时间复杂度: O(2^n)
     */
    private static int f(int n){
        assert( n >= 0 );
        if(n == 0)
            return 1;

        return f(n - 1) + f(n - 1);
    }

    /*
    // 归并排序
    // 虽然是两次调用递归函数，但是递归操作处理的数据越来越少，是一种分治的算法
    // 时间复杂度: O(nlogn)
    private static void mergeSort(Comparable[] arr, int l, int r){

        if(l >= r)
            return;

        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    */

    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(pow(2, 10));
    }
}
