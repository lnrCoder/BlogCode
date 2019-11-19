package lnrcoder.weekly.contest.one.six.three;

import java.util.HashSet;

/**
 * @ClassName L1261
 * @description 在受污染的二叉树中查找元素
 * @Author LiaNg
 * @Date 2019-11-18
 */
public class L1261 {

    HashSet<Integer> set;

    public L1261(TreeNode root) {
        set = new HashSet<>();
        dfs(root, 0);
    }

    public void dfs(TreeNode root, int val) {
        if (root==null) {
            return;
        }
        root.val = val;
        set.add(val);
        dfs(root.left, val * 2 + 1);
        dfs(root.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}