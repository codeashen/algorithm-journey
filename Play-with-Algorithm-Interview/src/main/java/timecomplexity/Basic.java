package timecomplexity;

/**
 * 数据规模测试
 */
public class Basic {
    public static void main(String[] args) {

        // 数据规模每次增大 10 倍进行测试
        // 统计每个数据规模的处理速度
        for (int x = 1; x <= 9; x++) {

            int n = (int) Math.pow(10, x);

            long startTime = System.currentTimeMillis();

            long sum = 0;
            for (int i = 0; i < n; i++)
                sum += i;

            long endTime = System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }
}
