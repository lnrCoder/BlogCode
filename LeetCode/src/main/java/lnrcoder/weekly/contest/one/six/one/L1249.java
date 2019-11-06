package lnrcoder.weekly.contest.one.six.one;

import java.util.Stack;

/**
 * @ClassName L1249
 * @description 移除无效的括号
 * @Author LiaNg
 * @Date 2019-11-05
 */
public class L1249 {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println("minRemoveToMakeValid(s) = " + minRemoveToMakeValid(s));
    }

    /**
     * 给你一个由 '('、')' 和小写字母组成的字符串 s。
     * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
     * 请返回任意一个合法字符串。
     * 有效「括号字符串」应当符合以下 任意一条 要求：
     * 空字符串或只包含小写字母的字符串
     * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
     * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
     */
    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.empty()) {
                    chars[i] = '-';
                } else {
                    stack.pop();
                }
            }
        }

        for (Integer integer : stack) {
            chars[integer] = '-';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != '-') {
                stringBuilder.append(aChar);
            }
        }

        return stringBuilder.toString();
    }

}
