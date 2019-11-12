package lnrcoder.weekly.contest.one.six.two;

/**
 * @ClassName L1254
 * @description 统计封闭岛屿的数目
 * @Author LiaNg
 * @Date 2019-11-12
 */
public class L1254 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println("closedIsland(grid) = " + closedIsland(grid));
    }

    private static boolean[][] flag;
    private static boolean mark;
    private static int[][] rowCol = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
     * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
     * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
     * 请返回封闭岛屿的数目。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        if (n <= 2) {
            return 0;
        }
        int m = grid[0].length;
        if (m <= 2) {
            return 0;
        }
        int result = 0;
        flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flag[i][j] || grid[i][j] == 1) {
                    continue;
                }
                mark = true;
                flag[i][j] = true;
                dfs(grid, i, j);
                if (mark) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int xNew = x + rowCol[i][0];
            int yNew = y + rowCol[i][1];
            if (xNew < 0 || xNew >= grid.length || yNew < 0 || yNew >= grid[0].length) {
                mark = false;
            } else if (grid[xNew][yNew] != 1 && !flag[xNew][yNew]) {
                flag[xNew][yNew] = true;
                dfs(grid, xNew, yNew);
            }
        }
    }

}
