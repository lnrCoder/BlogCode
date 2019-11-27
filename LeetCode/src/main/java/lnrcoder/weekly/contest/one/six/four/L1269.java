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

    /**
     * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
     * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
     * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
     * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numWays(int steps, int arrLen) {
        Long mod = 1000000007L;

        long[][] result = new long[steps + 1][steps + 1];

        int min = Math.min(arrLen, steps);

        result[0][0] = 1L;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < min; j++) {
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
