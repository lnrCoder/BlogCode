package lnrcoder.weekly.contest.one.six.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L1248
 * @description 统计「优美子数组」
 * @Author LiaNg
 * @Date 2019-11-05
 */
public class L1248 {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println("numberOfSubarrays1(nums, k) = " + numberOfSubarrays(nums, k));
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k。
     * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * 请返回这个数组中「优美子数组」的数目。
     */
    public static int numberOfSubarrays(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> beforeCountList = new ArrayList<>();

        int count = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                count++;
                beforeCountList.add(count);
                count = 0;
            } else {
                count++;
            }
        }

        beforeCountList.add(count + 1);

        int oddSize = beforeCountList.size();

        if(oddSize<k+1){
            return 0;
        }

        int result = 0;

        for (int i = 0; i < oddSize-k; i++) {
            result = result + beforeCountList.get(i) * beforeCountList.get(i + k);
        }

        return result;
    }

    /**
     * 本解法来源：LeetCode-执行用时分布图表-最速解法
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 1;
        int c = 0;
        for (int num : nums) {
            c += num & 1;
            sums[c]++;
        }
        int r = 0;
        for (int i = 0; i < sums.length - k; i++) {
            r += sums[i] * sums[i + k];
        }
        return r;
    }
}
