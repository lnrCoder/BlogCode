package lnrcoder.weekly.contest.one.six.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Weekly
 * @description 165周赛
 * @Author LiaNg
 * @Date 2019-12-01
 */
public class Weekly {

    public static void main(String[] args) {

        Weekly weekly = new Weekly();

//        int[][] moves1 = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
//        int[][] moves2 = new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
//        int[][] moves3 = new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
//
//        System.out.println("we = " + weekly.tictactoe(moves1));
//        System.out.println("we = " + weekly.tictactoe(moves2));
//        System.out.println("weekly.tictactoe(moves3) = " + weekly.tictactoe(moves3));

        int tomatoSlices = 16;
        int cheeseSlices = 7;
        System.out.println(
                "weekly.numOfBurgers(tomatoSlices,cheeseSlices) = " + weekly.numOfBurgers(tomatoSlices, cheeseSlices));
    }

    public int countSquares(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
    }

    public String tictactoe(int[][] moves) {
        boolean flagA = true;

        int[] A = new int[8];
        int[] B = new int[8];
        Arrays.fill(B, 0);
        Arrays.fill(A, 0);
        int index = 0;
        for (int[] move : moves) {

            if ((index & 1) == 0) {
                if (move[0] == move[1]) {
                    A[7]++;
                }
                if ((move[0] == 0 && move[1] == 2) || (move[0] == 1 && 1 == move[1]) || (move[0] == 2
                        && move[1] == 0)) {
                    A[6]++;
                }
                A[move[0]]++;
                A[move[1] + 3]++;
            } else {
                if (move[0] == move[1]) {
                    B[7]++;
                }
                if ((move[0] == 0 && move[1] == 2) || (move[0] == 1 && 1 == move[1]) || (move[0] == 2
                        && move[1] == 0)) {
                    B[6]++;
                }

                B[move[0]]++;
                B[move[1] + 3]++;
            }
            index++;
        }
        for (int i : A) {
            if (i == 3) {
                return "A";
            }
        }
        for (int i : B) {
            if (i == 3) {
                return "B";
            }
        }

        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }

    }



    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        List<Integer> list = new ArrayList<>();

        if ((tomatoSlices & 1 )== 1) {
            return list;
        }

        int tom = tomatoSlices >> 1;
        if (tom >=cheeseSlices && (tom>>1)<=cheeseSlices) {

            int big = (tomatoSlices >> 1) - cheeseSlices;
            int small = cheeseSlices - big;

            if (big * 2 + small == tom) {
                list.add(big);
                list.add(small);
                return list;
            }
        }

        return list;




    }

}
