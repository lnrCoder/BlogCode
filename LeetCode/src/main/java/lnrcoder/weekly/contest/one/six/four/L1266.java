package lnrcoder.weekly.contest.one.six.four;

/**
 * @ClassName L1266
 * @description 访问所有点的最小时间
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L1266 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        L1266 l1266 = new L1266();
        System.out.println("l1266.minTimeToVisitAllPoints(points) = " + l1266.minTimeToVisitAllPoints(points));
    }

    public int minTimeToVisitAllPoints(int[][] points) {

        int result = 0;

        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);

            result += Math.max(x, y);

        }
        return result;

    }
}
