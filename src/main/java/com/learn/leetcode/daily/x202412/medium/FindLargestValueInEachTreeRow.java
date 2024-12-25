package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.common.TreeNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/?envType=daily-question&envId=2024-12-25">Task</a>
 * <br><a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/solutions/3999535/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2024-12-25">Explanation</a>
 * <ul>Topics
 * <li> {@code Tree, Depth-First Search, Breadth-First Search, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree will be in the range [0, 10^4].}
 * <li> {@code -2^31 <= Node.val <= 2^31 - 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 25.12.24 06:39
 */
public final class FindLargestValueInEachTreeRow {

    private List<Integer> ans;

    /**
     * Approach 1: Breadth First Search (BFS)
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root
     * @return an array of the largest value in each row of the tree <b>(0-indexed)</b>.
     */
    public List<Integer> largestValues_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int currMax = Integer.MIN_VALUE;

            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                currMax = Math.max(currMax, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(currMax);
        }

        return ans;
    }

    /**
     * Approach 2: Depth First Search (DFS)
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root
     * @return an array of the largest value in each row of the tree <b>(0-indexed)</b>.
     */
    public List<Integer> largestValues_DFS(TreeNode root) {
        ans = new ArrayList<Integer>();
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    /**
     * Approach 3: DFS, Iterative
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param root
     * @return an array of the largest value in each row of the tree <b>(0-indexed)</b>.
     */
    public List<Integer> largestValues_DFS_Iterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            if (depth == ans.size()) {
                ans.add(node.val);
            } else {
                ans.set(depth, Math.max(ans.get(depth), node.val));
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }

            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }

        return ans;
    }
}
