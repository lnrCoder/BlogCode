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

    /**
     * 给出一个满足下述规则的二叉树：
     * root.val == 0
     * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
     * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
     * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
     * 请你先还原二叉树，然后实现 FindElements 类：
     * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
     * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public L1261(TreeNode root) {
        set = new HashSet<>();
        dfs(root, 0);
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) {
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