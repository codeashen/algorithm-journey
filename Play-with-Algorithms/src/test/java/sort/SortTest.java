package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sort.basic.SelectionSort;

import static org.junit.Assert.*;

public class SortTest {

    private Integer[] arr;
    private long sortStartTime;
    
    @Before
    public void initArr() {
        int n = 20000;
        int rangeL = 0;
        int rangeR = 100000;
        
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }

        sortStartTime = System.currentTimeMillis();
    }

    @After
    public void printArr() {
        System.out.println("Completed, takes " + (System.currentTimeMillis() - sortStartTime) + " ms");
        // for (Integer integer : arr) {
        //     System.out.print(integer);
        //     System.out.print(' ');
        // }
    }
    
    @Test
    public void selectionSort() {
        SelectionSort.sort(arr);
    }
}
