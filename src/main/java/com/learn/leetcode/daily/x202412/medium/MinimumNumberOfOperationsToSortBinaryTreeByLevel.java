package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.common.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/?envType=daily-question&envId=2024-12-23">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/solutions/6150148/minimum-number-of-operations-to-sort-a-binary-tree-by-level/">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Breadth-First Search, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code We can group the values level by level and solve each group independently.}
 * <li> {@code Do BFS to group the value level by level.}
 * <li> {@code Find the minimum number of swaps to sort the array of each level.}
 * <li> {@code While iterating over the array, check the current element, and if not in the correct index, replace that element with the index of the element which should have come.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is in the range [1, 10^5].}
 * <li> {@code 1 <= Node.val <= 10^5}
 * <li> {@code All the values of the tree are unique.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 23.12.24 08:28
 */
public final class MinimumNumberOfOperationsToSortBinaryTreeByLevel {

    /**
     * Approach 1: Hash Map
     * <p>In one operation, you can choose any two nodes at the same level and swap their values.</p>
     * <p>
     * {@code Time Complexity O(N * LogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root the root of a binary tree with <b>unique values</b>.
     * @return the minimum number of operations needed to make the values at each level sorted in a <b>strictly increasing order</b>.
     */
    public int minimumOperations(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];

            // Store values of current level and add children to queue
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add minimum swaps needed for current level
            totalSwaps += getMinSwaps(levelValues);
        }
        return totalSwaps;
    }

    // Calculate minimum swaps needed to sort an array
    private int getMinSwaps(int[] original) {
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(target);

        // Map to track current positions of values
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            pos.put(original[i], i);
        }

        // For each position, swap until correct value is placed
        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                swaps++;

                // Update position of swapped values
                int curPos = pos.get(target[i]);
                pos.put(original[i], curPos);
                original[curPos] = original[i];
            }
        }
        return swaps;
    }

    /**
     * Approach 2: Bit Manipulation
     * <p>In one operation, you can choose any two nodes at the same level and swap their values.</p>
     * <p>
     * {@code Time Complexity O(N * LogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root the root of a binary tree with <b>unique values</b>.
     * @return the minimum number of operations needed to make the values at each level sorted in a <b>strictly increasing order</b>.
     */
    public int minimumOperations_Bit_Manipulation(TreeNode root) {
        // Constants for bit manipulation
        final int SHIFT = 20;
        final int MASK = 0xFFFFF;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int swaps = 0;

        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            final int levelSize = queue.size();
            final long[] nodes = new long[levelSize];

            // Store node values with encoded positions
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // Encode value and index: high 20 bits = value, low 20 bits = index
                nodes[i] = ((long) node.val << SHIFT) + i;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Sort nodes by their values (high 20 bits)
            Arrays.sort(nodes);

            // Count swaps needed to match indices with original positions
            for (int i = 0; i < levelSize; i++) {
                final int origPos = (int) (nodes[i] & MASK);
                if (origPos != i) {
                    // Swap nodes and decrement i to recheck current position
                    final long temp = nodes[i];
                    nodes[i--] = nodes[origPos];
                    nodes[origPos] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}
