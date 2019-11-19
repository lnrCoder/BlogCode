package lnrcoder.weekly.contest.one.six.three;

import java.util.PriorityQueue;

/**
 * @ClassName L1263
 * @description 推箱子
 * @Author LiaNg
 * @Date 2019-11-19
 */
public class L1263 {

    public static void main(String[] args) {
        L1263 l1263 = new L1263();
        char[][] grid = new char[][]{{'#', '#', '#', '#', '#', '#'}, {'#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', 'B', '.', '#'}, {'#', '.', '#', '#', '.', '#'}, {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}};
        System.out.println("minPushBox(grid) = " + l1263.minPushBox(grid));
    }

    /**
     * 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
     * 游戏地图用大小为 n * m 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
     * 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
     * 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
     * 地板用字符 '.' 表示，意味着可以自由行走。
     * 墙用字符 '#' 表示，意味着障碍物，不能通行。 
     * 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
     * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
     * 玩家无法越过箱子。
     * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 作者：stormsunshine
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-move-a-box-to-their-target-location/solution/javayou-xian-dui-lie-by-stormsunshine/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int minPushBox(char[][] grid) {
        final int BLOCK = -1;
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        int rows = grid.length, columns = grid[0].length;
        int[][][][] colors = new int[rows][columns][rows][columns];
        int[][][][] distances = new int[rows][columns][rows][columns];
        for (int bRow = 0; bRow < rows; bRow++) {
            for (int bCol = 0; bCol < columns; bCol++) {
                for (int pRow = 0; pRow < rows; pRow++) {
                    for (int pCol = 0; pCol < columns; pCol++) {
                        distances[bRow][bCol][pRow][pCol] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for (int bRow = 0; bRow < rows; bRow++) {
            for (int bCol = 0; bCol < columns; bCol++) {
                for (int pRow = 0; pRow < rows; pRow++) {
                    for (int pCol = 0; pCol < columns; pCol++) {
                        if (grid[bRow][bCol] == '#' || grid[pRow][pCol] == '#') {
                            colors[bRow][bCol][pRow][pCol] = BLOCK;
                            distances[bRow][bCol][pRow][pCol] = -1;
                        }
                    }
                }
            }
        }
        int initialBoxRow = -1, initialBoxColumn = -1, initialPlayerRow = -1, initialPlayerColumn = -1, targetRow = -1, targetColumn = -1;
        int count = 0;
        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char c = grid[i][j];
                if (c == 'B') {
                    initialBoxRow = i;
                    initialBoxColumn = j;
                    count++;
                } else if (c == 'S') {
                    initialPlayerRow = i;
                    initialPlayerColumn = j;
                    count++;
                } else if (c == 'T') {
                    targetRow = i;
                    targetColumn = j;
                    count++;
                }
                if (count == 3) {
                    break outer;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        distances[initialBoxRow][initialBoxColumn][initialPlayerRow][initialPlayerColumn] = 0;
        PriorityQueue<Status> queue = new PriorityQueue<Status>();
        queue.offer(new Status(initialBoxRow, initialBoxColumn, initialPlayerRow, initialPlayerColumn, 0));
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            int boxRow = status.boxRow, boxColumn = status.boxColumn, playerRow = status.playerRow, playerColumn = status.playerColumn, distance = status.distance;
            for (int[] direction : directions) {
                int playerNewRow = playerRow + direction[0], playerNewColumn = playerColumn + direction[1];
                if (playerNewRow < 0 || playerNewRow >= rows || playerNewColumn < 0 || playerNewColumn >= columns
                        || grid[playerNewRow][playerNewColumn] == '#') {
                    continue;
                }
                if (playerNewRow == boxRow && playerNewColumn == boxColumn) {
                    int boxNewRow = boxRow + direction[0], boxNewColumn = boxColumn + direction[1];
                    if (boxNewRow < 0 || boxNewRow >= rows || boxNewColumn < 0 || boxNewColumn >= columns
                            || grid[boxNewRow][boxNewColumn] == '#') {
                        continue;
                    }
                    if (boxNewRow == targetRow && boxNewColumn == targetColumn) {
                        return distance + 1;
                    } else if (colors[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] == WHITE) {
                        colors[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] = GRAY;
                        distances[boxNewRow][boxNewColumn][playerNewRow][playerNewColumn] = distance + 1;
                        queue.offer(new Status(boxNewRow, boxNewColumn, playerNewRow, playerNewColumn, distance + 1));
                    }
                } else {
                    if (colors[boxRow][boxColumn][playerNewRow][playerNewColumn] == WHITE) {
                        colors[boxRow][boxColumn][playerNewRow][playerNewColumn] = GRAY;
                        distances[boxRow][boxColumn][playerNewRow][playerNewColumn] = distance;
                        queue.offer(new Status(boxRow, boxColumn, playerNewRow, playerNewColumn, distance));
                    }

                }
            }
            colors[boxRow][boxColumn][playerRow][playerColumn] = BLACK;
        }
        int totalDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int distance = distances[targetRow][targetColumn][i][j];
                totalDistance = Math.min(totalDistance, distance);
            }
        }
        return totalDistance;
    }
}

class Status implements Comparable<Status> {

    int boxRow;
    int boxColumn;
    int playerRow;
    int playerColumn;
    int distance;

    public Status() {

    }

    public Status(int boxRow, int boxColumn, int playerRow, int playerColumn, int distance) {
        this.boxRow = boxRow;
        this.boxColumn = boxColumn;
        this.playerRow = playerRow;
        this.playerColumn = playerColumn;
        this.distance = distance;
    }

    @Override
    public int compareTo(Status status2) {
        return this.distance - status2.distance;
    }

}