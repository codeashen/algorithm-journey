package N01_Linear_Search;


import com.journey.algorithm.common.annotation.Algorithm;

@Algorithm("线性查找法")
public class LinearSearch1 {
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
