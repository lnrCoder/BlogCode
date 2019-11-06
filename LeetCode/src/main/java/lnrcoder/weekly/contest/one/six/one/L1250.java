package lnrcoder.weekly.contest.one.six.one;

/**
 * @ClassName L1250
 * @description 检查「好数组」
 * @Author LiaNg
 * @Date 2019-11-06
 */
public class L1250 {

    public static void main(String[] args) {

        int[] nums = new int[]{29, 6, 10};
        System.out.println("isGoodArray(nums) = " + isGoodArray(nums));
    }

    /**
     * 本解法来自：LeetCode用户 —> 小白二号（https://leetcode-cn.com/u/scut_dell/） 的 C++ 解法
     * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
     * 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
     */
    public static boolean isGoodArray(int[] nums) {

        int d = nums[0];
        for (int i = 1; i < nums.length; i++) {
            d = gcd(d, nums[i]);
        }
        return d == 1;

    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
