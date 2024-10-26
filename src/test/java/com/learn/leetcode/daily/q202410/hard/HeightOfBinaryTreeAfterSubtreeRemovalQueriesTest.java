package com.learn.leetcode.daily.q202410.hard;

import com.learn.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class HeightOfBinaryTreeAfterSubtreeRemovalQueriesTest {

    @Test
    void treeQueries() {
    }

    @Test
    void maxDepthRecursiveApproach() {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        final Map<Integer, Integer> map = new HashMap<>();
        final int[] queries = new int[]{3};
    }
}