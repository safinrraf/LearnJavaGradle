package com.learn.leetcode.daily.w2024.q202410.medium;

import com.learn.leetcode.common.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/?envType=daily-question&envId=2024-10-22">Task</a>
 * <br><a href="https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/solutions/5949739/clean-and-fully-explained-code-beats-100-using-bfs-sorting-step-by-step-breakdown/">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Breadth-First Search, Sorting, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code Find the sum of values of nodes on each level and return the kth largest one.}
 * <li> {@code To find the sum of the values of nodes on each level, you can use a DFS or BFS algorithm to traverse the tree and keep track of the level of each node..}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is n.}
 * <li> {@code 2 <= n <= 105}
 * <li> {@code 1 <= Node.val <= 10^6}
 * <li> {@code 1 <= k <= n}
 * </ul>
 * <br>@since 1.0.0
 * <br> 22.10.24 08:28
 */
public final class KthLargestSumInBinaryTree {
    /**
     * {@code Time Complexity = O(NLogN)}
     * <br>{@code Time Complexity = O(N)}
     * @param root
     * @param k
     * @return
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        // To store sum of each level
        final List<Long> res = new ArrayList<>();
        // Queue for level-order traversal
        final Queue<TreeNode> q = new LinkedList<>();
        // Start BFS from the root node
        q.add(root);

        while (!q.isEmpty()) {
            // Number of nodes at the current level
            final var numberOfNodes = q.size();
            // Sum of node values at the current level
            long sum = 0L;

            for (int i = 0; i < numberOfNodes; i++) {
                final TreeNode node = q.poll();
                if (node != null) {
                    sum += node.val;

                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            // Store the sum of the current level
            res.add(sum);
        }

        if (k > res.size()) {
            return -1;
        }

        // Sort level sums in descending order
        res.sort(Collections.reverseOrder());

        // Return the k-th largest sum
        return res.get(k - 1);
    }
}
