package com.learn.leetcode.daily.w2024.q202408;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-25">Task</a>
 */
public final class BinaryTreePostorderTraversal {

    private void find(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        find(root.left, ans);
        find(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        find(root, ans);
        return ans;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
