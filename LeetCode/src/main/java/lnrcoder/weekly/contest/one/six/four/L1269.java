package lnrcoder.weekly.contest.one.six.four;

/**
 * @ClassName L1269
 * @description 停在原地的方案数
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L1269 {

    public static void main(String[] args) {
        int steps = 27;
        int arrLen = 7;
        L1269 l1269 = new L1269();
        System.out.println("l1269.numWays(steps,arrLen) = " + l1269.numWays(steps, arrLen));
    }

    public int numWays(int steps, int arrLen) {
        Long mod = 1000000007L;

        long[][] result = new long[steps + 1][steps + 1];

        int min = Math.min(arrLen, steps);

        result[0][0] = 1L;
        for (int i = 1; i <= steps; i++) {
            for (int j =0;j<min;j++){
                // 1. 第i-1步到位置j，i步停留原地j
                result[i][j] = result[i - 1][j];
                if (j != 0) {
                    // 3. 第i-1步到位置j-1，i步右移到j
                    result[i][j] += result[i - 1][j - 1];
                }
                if (j != min - 1) {
                    // 2. 第i-1步到位置j+1，i步左移到j
                    result[i][j] += result[i - 1][j + 1];
                }

                result[i][j] %= mod;
            }
        }
        return (int) result[steps][0];
    }
}
