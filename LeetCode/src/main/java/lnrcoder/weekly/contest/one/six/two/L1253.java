package lnrcoder.weekly.contest.one.six.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L1253
 * @description 重构 2 行二进制矩阵
 * @Author LiaNg
 * @Date 2019-11-12
 */
public class L1253 {

    public static void main(String[] args) {
        int upper = 5;
        int lower = 5;
        int[] colsum = new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1};

        System.out.println("reconstructMatrix(upper,lower,colsum) = " + reconstructMatrix(upper, lower, colsum));
    }

    /**
     * 给你一个 2 行 n 列的二进制数组：
     * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
     * 第 0 行的元素之和为 upper。
     * 第 1 行的元素之和为 lower。
     * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
     * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
     * 如果有多个不同的答案，那么任意一个都可以通过本题。
     * 如果不存在符合要求的答案，就请返回一个空的二维数组。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(colsum.length);
        List<Integer> list2 = new ArrayList<>(colsum.length);

        int count2 = 0;
        for (int i : colsum) {
            if (i == 2) {
                count2 += 1;
            }
        }

        upper = upper - count2;
        lower = lower - count2;

        if (upper < 0 || lower < 0) {
            return resultList;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                list1.add(i, 1);
                list2.add(i, 1);
            } else if (colsum[i] == 0) {
                list1.add(i, 0);
                list2.add(i, 0);
            }
            if (colsum[i] == 1) {
                if (upper > 0) {
                    list1.add(i, 1);
                    list2.add(i, 0);
                    upper--;
                } else if (lower > 0) {
                    list2.add(i, 1);
                    list1.add(i, 0);
                    lower--;
                } else {
                    return resultList;
                }
            }
        }

        if (upper == 0 && lower == 0) {
            resultList.add(list1);
            resultList.add(list2);
        }

        return resultList;
    }

    /**
     * LeetCode 耗时最短的 Java 解答
     */
    public List<List<Integer>> reconstructMatrix1(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> loweList = new ArrayList<>();
        if (colsum == null || colsum.length == 0) {
            return res;
        }
        int sum = 0;
        for (int num : colsum) {
            sum += num;
        }

        if (upper + lower != sum) {
            return res;
        }
        for (int num : colsum) {
            if (num == 2) {
                upperList.add(1);
                loweList.add(1);
                upper--;
                lower--;
            } else if (num == 1) {
                if (upper > lower) {
                    upperList.add(1);
                    loweList.add(0);
                    upper--;
                } else {
                    upperList.add(0);
                    loweList.add(1);
                    lower--;
                }
            } else {
                upperList.add(0);
                loweList.add(0);
            }
            if (upper < 0 || lower < 0) {
                return res;
            }
        }
        res.add(upperList);
        res.add(loweList);
        return res;

    }
}
