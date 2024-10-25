package com.learn.leetcode.daily.q202410.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RemoveSubFoldersFromTheFilesystemTest {

    @Test
    void removeSubfolders1() {
        var input = new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
        var expected = List.of("/a","/c/d","/c/f");
        var result = RemoveSubFoldersFromTheFilesystem.removeSubfolders(input);

        assertEquals(expected, result);
    }

    @Test
    void removeSubfolders2() {
        var input = new String[]{"/a","/a/b/c","/a/b/d"};
        var expected = List.of("/a");
        var result = RemoveSubFoldersFromTheFilesystem.removeSubfolders(input);

        assertEquals(expected, result);
    }

    @Test
    void removeSubfolders3() {
        var input = new String[]{"/a/b/c","/a/b/ca","/a/b/d"};
        var expected = List.of("/a/b/c","/a/b/ca","/a/b/d");
        var result = RemoveSubFoldersFromTheFilesystem.removeSubfolders(input);

        assertEquals(expected, result);
    }

    @Test
    void removeSubfolders4() {
        var input = new String[]{"/bo/cp/cu/cw","/dc/dd/de/dg","/bo/bp/bu/bw","/bo/cp/cu","/dc/dd/di","/dc/dd/di/dk",
                "/dc/dd/dm/dp","/dc/ed/ee/eh","/dc/ed/ei/ek","/bo/cc/cl/co","/bo/cc/cl","/aa/ao/ax/az",
                "/dc/dd/di/dl","/dc/dq/dr","/aa/ab","/aa/bb/bg/bj","/dc/dq/dr/dt","/dc/dd/dm","/dc/dq/dr/du","/dc/dd/de/dh"};
        var expected = List.of("/aa/ab", "/aa/ao/ax/az", "/aa/bb/bg/bj", "/bo/bp/bu/bw", "/bo/cc/cl",
                "/bo/cp/cu", "/dc/dd/de/dg", "/dc/dd/de/dh", "/dc/dd/di", "/dc/dd/dm", "/dc/dq/dr", "/dc/ed/ee/eh", "/dc/ed/ei/ek");
        var result = RemoveSubFoldersFromTheFilesystem.removeSubfolders(input);

        assertEquals(expected, result);
    }
}