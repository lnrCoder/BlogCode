package lnrcoder.weekly.contest.one.six.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName L1267
 * @description 统计参与通信的服务器
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L1267 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        L1267 l1267 = new L1267();
        System.out.println("l1267.countServers(grid) = " + l1267.countServers(grid));
    }

    /**
     * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
     * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
     * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countServers(int[][] grid) {

        Map<Integer, Integer> mapx = new HashMap<>();
        Map<Integer, Integer> mapy = new HashMap<>();
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    mapx.put(i, mapx.getOrDefault(i, 0) + 1);
                    mapy.put(j, mapy.getOrDefault(j, 0) + 1);
                    list.add(new Integer[]{i, j});
                }
            }
        }

        int result = 0;

        for (Integer[] integers : list) {
            if (mapx.get(integers[0]) > 1 || mapy.get(integers[1]) > 1) {
                result++;
            }
        }
        return result;
    }
}
