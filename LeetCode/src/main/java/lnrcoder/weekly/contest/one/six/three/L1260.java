package lnrcoder.weekly.contest.one.six.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName L1260
 * @description 二维网格迁移
 * @Author LiaNg
 * @Date 2019-11-18
 */
public class L1260 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        System.out.println("shiftGrid(grid,k) = " + shiftGrid(grid, k));
    }

    /**
     * 给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     * 每次「迁移」操作将会引发下述活动：
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shift-2d-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rowLength = grid.length;
        int colLength = grid[0].length;

        List<List<Integer>> resultList = new ArrayList<>(rowLength);

        Integer[][] newGrid = new Integer[rowLength][colLength];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[(i + (j + k) / colLength) % rowLength][(j + k) % colLength] = grid[i][j];
            }
        }

        for (Integer[] integers : newGrid) {
            resultList.add(Arrays.asList(integers));
        }

        return resultList;
    }
}
