package com.learn.leetcode.daily.b202502.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-a-number-container-system/description/?envType=daily-question&envId=2025-02-08">Task</a>
 * <br><a href="https://leetcode.com/problems/design-a-number-container-system/editorial/?envType=daily-question&envId=2025-02-08">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, Design, Heap (Priority Queue), Ordered Set}
 * </ul>
 * <ul>Hints
 * <li> {@code Use a hash table to efficiently map each number to all of its indices in the container and to map each index to their current number.}
 * <li> {@code In addition, you can use ordered set to store all of the indices for each number to solve the find method. Do not forget to update the ordered set according to the change method.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= index, number <= 10^9}
 * <li> {@code At most 10^5 calls will be made in total to change and find.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 08.02.25 11:15
 */
public final class DesignNumberContainerSystem {

    private final Map<Integer, Integer> container_index_number;
    private final Map<Integer, SortedSet<Integer>> container_number_index;

    public DesignNumberContainerSystem() {
        container_index_number = new HashMap<>();
        container_number_index = new HashMap<>();
    }

    /**
     * Fills the container at {@code index} with the {@code number}. If there is already a number at that {@code index}, replace it.
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param index index.
     * @param number number.
     */
    public void change(int index, int number) {
        // If index already has a number, remove it from the old number's index set
        if (container_index_number.containsKey(index)) {
            int previousNumber = container_index_number.get(index);
            container_number_index.get(previousNumber).remove(index);
            if (container_number_index.get(previousNumber).isEmpty()) {
                container_number_index.remove(previousNumber);
            }
        }
        // Update the number and add the index to the new number's set
        container_index_number.put(index, number);
        container_number_index.putIfAbsent(number, new TreeSet<>());
        container_number_index.get(number).add(index);
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param number number to find;
     * @return the smallest index for the given {@code number}, or {@code -1} if there is no index that is filled by {@code number} in the system.
     */
    public int find(int number) {
        final var positions = container_number_index.get(number);
        if(positions == null) {
            return -1;
        }
        return positions.isEmpty() ? -1 : container_number_index.get(number).first();
    }
}