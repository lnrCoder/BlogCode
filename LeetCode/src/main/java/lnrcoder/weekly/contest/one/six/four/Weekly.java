package lnrcoder.weekly.contest.one.six.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Weekly
 * @description
 * @Author LiaNg
 * @Date 2019-11-24
 */
public class Weekly {

    public static void main(String[] args) {

        Weekly weekly = new Weekly();

        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};

        System.out.println("weekly.minTimeToVisitAllPoints(points) = " + weekly.minTimeToVisitAllPoints(points));

        int[][] grid = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};

        System.out.println("weekly.countServers(grid) = " + weekly.countServers(grid));


        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        System.out.println(
                "weekly.suggestedProducts(products,searchWord) = " + weekly.suggestedProducts(products, searchWord));

    }

    public int minTimeToVisitAllPoints(int[][] points) {

        int result = 0;

        for (int i = 1; i < points.length; i++) {
            int x  = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);

            result += Math.max(x, y) ;

        }
        return result;

    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        List<String> list = new ArrayList<>();
        String[] strings = arraySort(products);

        char first = searchWord.toCharArray()[0];

        for (String product : strings) {
            if (product.toCharArray()[0] == first) {
                list.add(product);
            }
        }


        for (int i = 0; i < searchWord.length(); i++) {
            List<String> l = new ArrayList<>();
            list = search(list, searchWord, i);

            int size = list.size();

            for (int j = 0; j < Math.min(size, 3); j++) {
                l.add(list.get(j));
            }

            result.add(l);
        }


        return result;

    }

    public List<String> search(List<String> products, String searchWord, int x) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).toCharArray().length>=x && products.get(i).toCharArray()[x] == searchWord.toCharArray()[x]) {
                list.add(products.get(i));
            }
        }

        return list;

    }

    public int countServers(int[][] grid) {

        Map<Integer, Integer> mapx = new HashMap<>();
        Map<Integer, Integer> mapy = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    mapx.put(i, mapx.getOrDefault(i,0) + 1);
                    mapy.put(j, mapy.getOrDefault(j, 0) + 1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    if(mapx.get(i) >1 || mapy.get(j)> 1){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static String[] arraySort(String[] input){
        for (int i=0;i<input.length-1;i++){
            for (int j=0;j<input.length-i-1;j++) {
                if(input[j].compareTo(input[j+1])>0){
                    String temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return input;
    }





}
