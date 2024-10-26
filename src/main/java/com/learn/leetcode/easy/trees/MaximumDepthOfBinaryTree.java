package com.learn.leetcode.easy.trees;

import com.learn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Recursion, Depth-First Search, Breadth-First Search}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is in the range [0, 10^4].}
 * <li> {@code -100 <= Node.val <= 100}
 * </ul>
 * <br>@since 1.0.0
 * <br> 26.10.24 17:05
 */
public final class MaximumDepthOfBinaryTree {

    /**
     * Recursive Approach. DFS (Deep-First-Search).
     *
     * @param root the root of the binary Tree.
     * @return the maximum depth of the Binary Tree.
     */
    public int maxDepthRecursiveApproach(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, depth is 0
        }

        // Find the depth of the left and right subtrees
        int leftDepth = maxDepthRecursiveApproach(root.left);
        int rightDepth = maxDepthRecursiveApproach(root.right);

        // Return the greater depth + 1 (for the root node)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Iterative Approach. Using BFS (Breadth-First Search).
     * <br>The time complexity is O(n), and the space complexity is also O(n) due to the queue storing nodes at each level.
     *
     * @param root the root of the binary Tree.
     * @return the maximum depth of the Binary Tree.
     */
    public int maxDepthIterativeApproach(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        // BFS to calculate depth
        while (!queue.isEmpty()) {
            final int levelSize = queue.size(); // Number of nodes at the current level
            depth++; // Increment depth as we move to the next level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode != null) {
                    // Add children of the current node to the queue
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }

        return depth;
    }
}
