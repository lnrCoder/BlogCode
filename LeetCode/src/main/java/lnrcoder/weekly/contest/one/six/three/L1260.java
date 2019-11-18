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
