package timecomplexity;

/**
 * 常见时间复杂度代码实例
 */
public class CommonTimeComplexity {

    // ========== O(1) ==========
    private static void swap(Object[] arr, int i, int j) {
        assert i > 0 || i < arr.length;
        assert j > 0 || j < arr.length;

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ========== O(n) ==========
    private static int sum(int n) {
        assert n >= 0;

        int ret = 0;
        for (int i = 0; i <= n; i++) {
            ret += i;
        }
        return ret;
    }

    // ========== O(n) ==========
    private static void reverse(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, n - 1 - i);
        }
    }

    // ========== O(n^2) ==========
    private static void selectionSort(Comparable[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // ========== O(n) ==========
    private static void printInformation(int n) {
        for (int i = 1; i <= n; i++) {
            // 内层常数级循环，所以即使双层循环，时间复杂度也是 O(n)
            for (int j = 1; j <= 30; j++) {
                System.out.println("Class " + i + " - " + "No. " + j);
            }
        }
    }

    // ========== O(logn) ==========
    private static int binarySearch(Comparable[] arr, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // ========== O(logn) ==========
    private static String intToString(int num) {
        StringBuilder sb = new StringBuilder("");
        String sign = "+";
        if (num < 0) {
            num = -num;
            sign = "-";
        }

        while (num != 0) {
            sb.append(num % 10);
            num /= 10;
        }

        if (sb.length() == 0) {
            sb.append('0');
        }

        sb.reverse();
        if (sign.equals("-")) {
            return sign + sb.toString();
        } else {
            return sb.toString();
        }
    }

    // ========== O(nlogn) ==========
    private static void hello(int n) {
        // 第一层循环, sz 每次都乘 2, 所以循环次数 sz^x=n  ->  x=logsz(n)
        // 所以外层循环是 log(n) 级别的, 整体操作是 O(nlogn) 级别的
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 1; i < n; i++) {
                System.out.println("Hello, Algorithm!");
            }
        }
    }

    // ========== O(sqrt(n)) ==========
    private static boolean isPrime2(int num) {
        // 判断 num 是不是素数
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        // 循环次数 x^2 <= num   ->   x <= sqrt(num)
        for (int x = 3; x * x <= num; x += 2) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(intToString(123));
        System.out.println(intToString(0));
        System.out.println(intToString(-123));

        System.out.println();

        if (isPrime2(137)) System.out.println("137 is a prime.");
        else System.out.println("137 is not a prime.");

        if (isPrime2(121)) System.out.println("121 is a prime.");
        else System.out.println("121 is not a prime.");
    }
}
