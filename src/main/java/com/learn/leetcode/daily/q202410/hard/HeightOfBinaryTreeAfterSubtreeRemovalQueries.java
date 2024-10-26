package com.learn.leetcode.daily.q202410.hard;

import com.learn.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/?envType=daily-question&envId=2024-10-26">Task</a>
 * <br><a href="https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/solutions/5968942/tutorial-from-the-problem-contributor-dfs-1-time-converts-to-a-range-removal-problem/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Tree, Depth-First Search, Breadth-First Search, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code Try pre-computing the answer for each node from 1 to n, and answer each query in O(1).}
 * <li> {@code The answers can be precomputed in a single tree traversal after computing the height of each subtree.}
 * </ul>
 * <ul> Companies
 * <li> {@code Google}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is n.}
 * <li> {@code 2 <= n <= 10^5}
 * <li> {@code 1 <= Node.val <= n}
 * <li> {@code All the values in the tree are unique.}
 * <li> {@code m == queries.length}
 * <li> {@code 1 <= m <= min(n, 10^4)}
 * <li> {@code 1 <= queries[i] <= n}
 * <li> {@code queries[i] != root.val}
 * <li>
 * </ul>
 * <br>@since 1.0.0
 * <br> 26.10.24 16:39
 */
public final class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    private int id = 0;
    /**
     *
     * @param root
     * @param queries
     * @return
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        final Map<Integer, Integer> mp1 = new HashMap<>();
        final Map<Integer, Integer> mp2 = new HashMap<>();
        final Map<Integer, Integer> sz = new HashMap<>();
        final int[] ans = new int[queries.length];
        dfs(root, 0, mp1, mp2, sz);

        final int[] left = new int[id];
        final int[] right = new int[id];
        for (int i = 0; i < id; i++) {
            left[i] = mp2.get(i);
            if (i > 0) {
                left[i] = Math.max(left[i - 1], left[i]);
            }
        }

        for (int i = id - 1; i >= 0; i--) {
            right[i] = mp2.get(i);
            if (i + 1 < id) {
                right[i] = Math.max(right[i], right[i + 1]);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            final int nodeId = mp1.get(queries[i]);
            final int r = nodeId + sz.get(nodeId) - 1;
            int depth = 0;
            if (nodeId > 0) {
                depth = Math.max(depth, left[nodeId - 1]);
            }
            if (r + 1 < id) {
                depth = Math.max(depth, right[r + 1]);
            }
            ans[i] = depth;
        }
        return ans;
    }

    private int dfs(TreeNode root,
                    int depth,
                    Map<Integer, Integer> mp1,
                    Map<Integer, Integer> mp2,
                    Map<Integer, Integer> sz) {
        if (root == null) {
            return 0;
        }
        mp1.put(root.val, id);
        mp2.put(id, depth);
        id++;
        int lz = dfs(root.left, depth + 1, mp1, mp2, sz);
        int rz = dfs(root.right, depth + 1, mp1, mp2, sz);
        sz.put(mp1.get(root.val), 1 + lz + rz);
        return 1 + lz + rz;
    }
}
