package com.learn.leetcode.daily.w2024.q202408;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-26">Task</a>
 */
public final class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        // If the root is null, return an empty list
        if (root == null) return new ArrayList<>();

        final List<Integer> res = new ArrayList<>();

        // Start DFS from the root
        dfs(root, res);

        // Return the result list containing node values in post-order
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        // Recursively call dfs for each child of the current node
        for (Node child : root.children) {
            dfs(child, res);
        }
        // Append the value of the current node to the result list
        res.add(root.val);
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
