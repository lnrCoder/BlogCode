package lnrcoder.weekly.contest.one.six.one;

/**
 * @ClassName L1247
 * @description 交换字符使得字符串相同
 * @Author LiaNg
 * @Date 2019-11-05
 */
public class L1247 {

    public static void main(String[] args) {
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        System.out.println("minimumSwap(s1,s2) = " + minimumSwap(s1, s2));
    }

    /**
     * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
     * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
     * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
     * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
     */
    public static int minimumSwap(String s1, String s2) {
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        int xCount = 0;
        int yCount = 0;

        int length = s1c.length;

        for (int i = 0; i < length; i++) {
            if (s1c[i] != s2c[i]) {
                if (s1c[i] == 'x') {
                    xCount++;
                } else {
                    yCount++;
                }
            }
        }

        if ((xCount + yCount) % 2 == 0) {
            int result = xCount / 2 + yCount / 2;
            return xCount % 2 == 1 ? result + 2 : result;
        }
        return -1;

    }
}
