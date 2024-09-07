package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;
import com.learn.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/description/?envType=daily-question&envId=2024-09-07">Task</a>
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/solutions/5748536/beats-100-explained-with-video-c-java-python-dfs-two-pointers-explained-in-detail/?envType=daily-question&envId=2024-09-07">Explanation</a>
 */
public final class LinkedListInBinaryTree {

    public static boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);  // Start DFS search
    }

    // DFS helper function
    public static boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        // If we reach the end of the linked list, return true (successful match)
        if (cur == null) return true;
        // If we reach the end of a path in the tree without fully matching the list, return false
        if (root == null) return false;

        // Match the current tree node with the current linked list node
        if (cur.val == root.val) cur = cur.next;
            // If no match, but the tree node matches the head of the linked list, start a new match
        else if (head.val == root.val) head = head.next;
            // Otherwise, reset `cur` to `head` to attempt matching the linked list from scratch
        else cur = head;

        // Continue DFS down both left and right children
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }
}
