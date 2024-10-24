package com.learn.leetcode.daily.q202410.medium;

import com.learn.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/flip-equivalent-binary-trees/description/?envType=daily-question&envId=2024-10-24">Task</a>
 * <br><a href="https://leetcode.com/problems/flip-equivalent-binary-trees/solutions/5960507/beats-100-00-explained-with-example/">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Depth-First Search, Binary Tree}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in each tree is in the range [0, 100].}
 * <li> {@code Each tree will have unique node values in the range [0, 99].}
 * </ul>
 * <br>@since 1.0.0
 * <br> 24.10.24 08:52
 */
public final class FlipEquivalentBinaryTrees {

    /**
     * {@code Time Complexity = O(N)}
     * <br>{@code Time Complexity = O(N)}
     * @param root1
     * @param root2
     * @return Given the roots of two binary trees {@code root1} and {@code root2}, return {@code true} if the two trees are flip equivalent or {@code false} otherwise.
     */
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checker(root1, root2);
    }

    private static boolean checker(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return (checker(node1.left, node2.left) || checker(node1.left, node2.right)) &&
                (checker(node1.right, node2.right) || checker(node1.right, node2.left));
    }
}
