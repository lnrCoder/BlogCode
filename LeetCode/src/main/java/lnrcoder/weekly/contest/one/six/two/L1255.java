package lnrcoder.weekly.contest.one.six.two;

import java.util.Arrays;

/**
 * @ClassName L1255
 * @description 得分最高的单词集合
 * @Author LiaNg
 * @Date 2019-11-12
 */
public class L1255 {

    public static void main(String[] args) {
        String[] words = {"xxxz","ax","bx","cx"};
        char[] letters = {'z','a','b','c','x','x','x'};
        int[] score = new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

        System.out.println("maxScoreWords(words,letters,score) = " + maxScoreWords(words, letters, score));
    }

    private static int max = 0;

    /**
     * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
     * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
     * 单词拼写游戏的规则概述如下：
     * 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
     * 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
     * 单词表 words 中每个单词只能计分（使用）一次。
     * 根据字母得分情况表 score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
     * 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] scoreOfWords = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                count += score[words[i].charAt(j) - 97];
            }
            scoreOfWords[i] = count;
        }
        int ans = 0;
        int[] manzu = new int[26];
        for (int i = 0; i < letters.length; i++) {
            manzu[letters[i] - 97]++;
        }
        getOrNot(words, scoreOfWords, manzu, 0, 0);
        return max;
    }

    private static void getOrNot(String[] word, int[] scoreOfWords, int[] manzu, int index, int sum) {
        if (index == word.length) {
            max = Math.max(max, sum);
            return;
        }
        int[] cop = Arrays.copyOf(manzu, 26);
        int flag = 0;
        for (int i = 0; i < word[index].length(); i++) {
            manzu[word[index].charAt(i) - 97]--;
            if (manzu[word[index].charAt(i) - 97] < 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            getOrNot(word, scoreOfWords, manzu, index + 1, sum + scoreOfWords[index]);
            getOrNot(word, scoreOfWords, cop, index + 1, sum);
        }
        if (flag == 1) {
            getOrNot(word, scoreOfWords, cop, index + 1, sum);
        }
    }
}
