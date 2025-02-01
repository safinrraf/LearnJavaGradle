package com.learn.leetcode.daily.w2024.x202412.medium;

import com.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/?envType=daily-question&envId=2024-12-20">Task</a>
 * <br><a href="https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/solutions/6144529/reverse-odd-levels-of-binary-tree/">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Depth-First Search, Breadth-First Search, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code Try to solve recursively for each level independently.}
 * <li> {@code While performing a depth-first search, pass the left and right nodes (which should be paired) to the next level. If the current level is odd, then reverse their values, or else recursively move to the next level.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is in the range [1, 214].}
 * </ul>
 * <br>@since 1.0.0
 * <br> 20.12.24 08:16
 */
public final class ReverseOddLevelsOfBinaryTree {

    /**
     * Approach 1: Depth-First Search
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(LogN)}
     * </p>
     * @param root is the {@code root} of a perfect binary tree.
     * @return the root of the reversed tree.
     */
    public TreeNode reverseOddLevels_DFS(TreeNode root) {
        traverseDFS(root.left, root.right, 0);
        return root;
    }

    private static void traverseDFS(
            TreeNode leftChild,
            TreeNode rightChild,
            int level
    ) {
        if (leftChild == null || rightChild == null) {
            return;
        }
        //If the current level is odd, swap the values of the children.
        if (level % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        traverseDFS(leftChild.left, rightChild.right, level + 1);
        traverseDFS(leftChild.right, rightChild.left, level + 1);
    }

    /**
     * Approach 2: Breadth-First Search
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root is the {@code root} of a perfect binary tree.
     * @return the root of the reversed tree.
     */
    public TreeNode reverseOddLevels_BFS(TreeNode root) {
        if (root == null) {
            return null; // Return null if the tree is empty.
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start BFS with the root node.
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            final List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse node values if the current level is odd.
            if (level % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(
                            right
                    ).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root; // Return the modified tree root.
    }
}
