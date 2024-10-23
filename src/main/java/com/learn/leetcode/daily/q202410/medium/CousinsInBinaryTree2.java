package com.learn.leetcode.daily.q202410.medium;

import com.learn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/cousins-in-binary-tree-ii/?envType=daily-question&envId=2024-10-23">Task</a>
 * <br><a href="https://leetcode.com/problems/cousins-in-binary-tree-ii/solutions/5955395/single-pass-understand-once-simple-with-added-youtube-video-visualize-the-approach/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash table, Tree, Depth-First Search, Breadth-First Search, Binary Tree}
 * </ul>
 * <ul>Hints
 * <li> {@code Use DFS two times.}
 * <li> {@code For the first time, find the sum of values of all the levels of the binary tree.}
 * <li> {@code For the second time, update the value of the node with the sum of the values of the current level - sibling node’s values.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code The number of nodes in the tree is in the range {@code [1, 105]}.}
 * <li> {@code 1 <= Node.val <= 104.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 23.10.24 08:52
 */
public final class CousinsInBinaryTree2 {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     * Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
     *
     * @param root the root of a binary tree.
     * @return Return the {@code root} of the modified tree.
     */
    public static TreeNode replaceValueInTree(TreeNode root) {
        // Queue for level-order traversal
        final Queue<TreeNode> queue = new LinkedList<>();
        int prev = root.val;
        // Start BFS from the root node
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curr = 0;

            while(size-- > 0) {
                final var tempTreeNode = queue.poll();
                int leafsSum = (tempTreeNode.left!=null ? tempTreeNode.left.val : 0)
                        + (tempTreeNode.right!=null? tempTreeNode.right.val : 0) ;
                if(tempTreeNode.left != null) {
                    tempTreeNode.left.val = leafsSum;
                    queue.add(tempTreeNode.left);
                }
                if(tempTreeNode.right != null) {
                    tempTreeNode.right.val = leafsSum;
                    queue.add(tempTreeNode.right);
                }
                curr += leafsSum;
                tempTreeNode.val = prev - tempTreeNode.val;
            }
            prev = curr;
        }

        return root;
    }
}
