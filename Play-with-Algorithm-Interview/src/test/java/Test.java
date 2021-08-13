import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        // test binary search
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = 6;
        int target1 = arr[index];
        int target2 = 0;
        System.out.println(binarySearch(arr, target1));;
        System.out.println(binarySearch2(arr, 0, arr.length - 1, target1));
        System.out.println(binarySearch(arr, target2));
        System.out.println(binarySearch2(arr, 0, arr.length - 1, target2));
        
        // selection sort
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        // selectionSort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * while 二分搜索
     */
    public static int binarySearch(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分搜索
     */
    public static int binarySearch2(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return target.equals(arr[l]) ? l : -1;
        }

        int mid = l + (r - l) / 2;
        if (target.compareTo(arr[mid]) == 0) {
            return mid;
        } else if (target.compareTo(arr[mid]) > 0) {
            return binarySearch2(arr, mid + 1, r, target);
        } else {
            return binarySearch2(arr, l, mid - 1, target);
        }
    }

    public static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        assert i > 0 || i < arr.length;
        assert j > 0 || j < arr.length;

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
