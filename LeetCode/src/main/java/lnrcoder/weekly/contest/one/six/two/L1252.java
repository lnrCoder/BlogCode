package lnrcoder.weekly.contest.one.six.two;

/**
 * @ClassName L1252
 * @description 奇数值单元格的数目
 * @Author LiaNg
 * @Date 2019-11-12
 */
public class L1252 {

    public static void main(String[] args) {
        int n =2;
        int m =3;
        int[][] indices = new int[][]{{0,1},{1,1}};

        System.out.println("oddCells(n,m,indices) = " + oddCells(n, m, indices));
    }

    /**
     * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
     * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int oddCells(int n, int m, int[][] indices) {
        int[] nCount = new int[n];
        int[] mCount = new int[m];

        for (int[] index : indices) {
            nCount[index[0]] += 1;
            mCount[index[1]] += 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = nCount[i] + mCount[j];
                if (num % 2 == 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    /**
     * LeetCode 耗时最短的 Java 解答
     */
    public int oddCells1(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        int r = 0, c = 0;
        for (int i = 0; i < indices.length; i++) {
            if (++rows[indices[i][0]] % 2 == 1) {
                r++;
            } else {
                r--;
            }
            if (++cols[indices[i][1]] % 2 == 1) {
                c++;
            } else {
                c--;
            }
        }
        return r * m + c * n - 2 * r * c;
    }
}
