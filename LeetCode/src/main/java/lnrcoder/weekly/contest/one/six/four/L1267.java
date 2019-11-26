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
