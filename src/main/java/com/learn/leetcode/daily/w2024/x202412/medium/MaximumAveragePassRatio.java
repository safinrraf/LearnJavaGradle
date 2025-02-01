package com.learn.leetcode.daily.w2024.x202412.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximum-average-pass-ratio/description/?envType=daily-question&envId=2024-12-15">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-average-pass-ratio/solutions/6144480/maximum-average-pass-ratio/?envType=daily-question&envId=2024-12-15">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Greedy, Heap (Priority Queue)}
 * </ul>
 * <ul>Hints
 * <li> {@code Pay attention to how much the pass ratio changes when you add a student to the class. If you keep adding students, what happens to the change in pass ratio? The more students you add to a class, the smaller the change in pass ratio becomes.}
 * <li> {@code Since the change in the pass ratio is always decreasing with the more students you add, then the very first student you add to each class is the one that makes the biggest change in the pass ratio.}
 * <li> {@code Because each class's pass ratio is weighted equally, it's always optimal to put the student in the class that makes the biggest change among all the other classes.}
 * <li> {@code Keep a max heap of the current class sizes and order them by the change in pass ratio. For each extra student, take the top of the heap, update the class size, and put it back in the heap.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= classes.length <= 10^5}
 * <li> {@code classes[i].length == 2}
 * <li> {@code 1 <= pass-i <= total-i <= 10^5}
 * <li> {@code 1 <= extraStudents <= 10^5}
 * </ul>
 * <br>@since 1.0.0
 * <br> 15.12.24 10:30
 */
public final class MaximumAveragePassRatio {

    /**
     * Brute Force (Time Limit Exceeded Error)
     * <p>
     * {@code Time Complexity O(K * N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param classes
     * @param extraStudents
     * @return the maximum possible average pass ratio after assigning the {@code extraStudents} students. Answers within {@code 10-5} of the actual answer will be accepted.
     */
    public static double maxAverageRatio_BF(int[][] classes, int extraStudents) {
        final List<Double> passRatios = new ArrayList<>();

        // Calculate initial pass ratios
        for (int classIndex = 0; classIndex < classes.length; classIndex++) {
            double initialRatio =
                    (double) classes[classIndex][0] / classes[classIndex][1];
            passRatios.add(initialRatio);
        }

        while (extraStudents > 0) {
            final List<Double> updatedRatios = new ArrayList<>();

            // Calculate updated pass ratios if an extra student is added
            for (
                    int classIndex = 0;
                    classIndex < classes.length;
                    classIndex++
            ) {
                double newRatio =
                        (double) (classes[classIndex][0] + 1) /
                                (classes[classIndex][1] + 1);
                updatedRatios.add(newRatio);
            }

            int bestClassIndex = 0;
            double maximumGain = 0;

            // Find the class that gains the most from an extra student
            for (
                    int classIndex = 0;
                    classIndex < updatedRatios.size();
                    classIndex++
            ) {
                double gain =
                        updatedRatios.get(classIndex) - passRatios.get(classIndex);
                if (gain > maximumGain) {
                    bestClassIndex = classIndex;
                    maximumGain = gain;
                }
            }

            // Update the selected class
            passRatios.set(bestClassIndex, updatedRatios.get(bestClassIndex));
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;

            extraStudents--;
        }

        // Calculate the total average pass ratio
        double totalPassRatio = 0;
        for (double passRatio : passRatios) {
            totalPassRatio += passRatio;
        }

        return totalPassRatio / classes.length;
    }

    /**
     * Priority Queue
     * <p>
     * {@code Time Complexity O(NLogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param classes
     * @param extraStudents
     * @return the maximum possible average pass ratio after assigning the {@code extraStudents} students. Answers within {@code 10-5} of the actual answer will be accepted.
     */
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // Lambda to calculate the gain of adding an extra student
        final PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
        );

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                    new double[] {
                            calculateGain(passes + 1, totalStudents + 1),
                            passes + 1,
                            totalStudents + 1,
                    }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private static double calculateGain(int passes, int totalStudents) {
        return (
                (double) (passes + 1) / (totalStudents + 1) -
                        (double) passes / totalStudents
        );
    }
}
