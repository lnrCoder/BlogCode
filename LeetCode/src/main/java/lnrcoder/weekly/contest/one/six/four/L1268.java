package lnrcoder.weekly.contest.one.six.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName L1268
 * @description 搜索推荐系统
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L1268 {

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        L1268 l1268 = new L1268();
        System.out.println(
                "l1268.suggestedProducts(products,searchWord) = " + l1268.suggestedProducts(products, searchWord));
    }

    /**
     * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
     * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
     * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-suggestions-system
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>(searchWord.length());
        List<String> list = new ArrayList<>(products.length);
        Arrays.sort(products);

        char first = searchWord.toCharArray()[0];
        for (String product : products) {
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
        for (String product : products) {
            if (product.toCharArray().length > x && product.toCharArray()[x] == searchWord
                    .toCharArray()[x]) {
                list.add(product);
            }
        }
        return list;
    }
}
