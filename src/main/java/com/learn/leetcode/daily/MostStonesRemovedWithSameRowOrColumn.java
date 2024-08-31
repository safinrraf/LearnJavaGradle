package com.learn.leetcode.daily;

/**
 * <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/?envType=daily-question&envId=2024-08-29">Task</a>
 */
public final class MostStonesRemovedWithSameRowOrColumn {
    private int connectedComponentCount = 0;

    public int removeStones(int[][] stonePositions) {
        int[] setRepresentatives = new int[20003];
        for (int[] stonePosition : stonePositions) {
            mergeComponents(stonePosition[0] + 1, stonePosition[1] + 10002, setRepresentatives);
        }
        return stonePositions.length - connectedComponentCount;
    }

    private int findRepresentative(int element, int[] setRepresentatives) {
        if (setRepresentatives[element] == 0) {
            setRepresentatives[element] = element;
            connectedComponentCount++;
        }
        return setRepresentatives[element] == element ? element :
                (setRepresentatives[element] = findRepresentative(setRepresentatives[element], setRepresentatives));
    }

    private void mergeComponents(int elementA, int elementB, int[] setRepresentatives) {
        int repA = findRepresentative(elementA, setRepresentatives);
        int repB = findRepresentative(elementB, setRepresentatives);
        if (repA != repB) {
            setRepresentatives[repB] = repA;
            connectedComponentCount--;
        }
    }
}
