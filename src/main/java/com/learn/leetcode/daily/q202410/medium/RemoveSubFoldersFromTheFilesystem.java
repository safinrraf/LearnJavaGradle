package com.learn.leetcode.daily.q202410.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, Depth-First Search, Trie}
 * </ul>
 * <ul>Hints
 * <li> {@code Sort the folders lexicographically.}
 * <li> {@code Insert the current element in an array and then loop until we get rid of all of their subfolders, repeat this until no element is left..}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= folder.length <= 4 * 104}
 * <li> {@code 2 <= folder[i].length <= 100}
 * <li> {@code folder[i] contains only lowercase letters and '/'.}
 * <li> {@code folder[i] always starts with the character '/'.}
 * <li> {@code Each folder name is unique.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 25.10.24 20:59
 */
public final class RemoveSubFoldersFromTheFilesystem {

    /**
     * <p>Time complexity {@code O(NLogN)}</p>
     * <p>Space complexity {@code O(N)}</p>
     * @param folder
     * @return Given a list of folders {@code folder}, return the folders after removing all sub-folders in those folders. You may return the answer in any order.
     */
    public static List<String> removeSubfolders(String[] folder) {
        //Hint #1.
        Arrays.sort(folder);
        //Hint #2.
        for(int i = 0; i < folder.length; i++) {
            for(int j = i + 1; j < folder.length;  j++) {
                if(!folder[i].isEmpty()
                        && folder[j].startsWith(folder[i]+"/")
                        && j != i) {
                    folder[j] = "";
                }
            }
        }

        return Arrays.stream(folder).filter(item -> !item.isEmpty()).toList();
    }
}
