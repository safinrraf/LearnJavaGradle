package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideIntervalsIntoMinimumNumberOfGroupsTest {

    /**
     * <p>Explanation: We can divide the intervals into the following groups:
     * <li> Group 1: {@code [1, 5], [6, 8].}
     * <li> Group 2: {@code [2, 3], [5, 10].}
     * <li> Group 3: {@code [1, 10].}
     * <br>It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
     * </p>
     */
    @Test
    void minGroups1() {
        final var intervals = new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}};
        final var expected = 3;
        final var result = DivideIntervalsIntoMinimumNumberOfGroups.minGroups(intervals);

        assertEquals(expected, result);
    }

    /**
     * <p>Explanation: None of the intervals overlap, so we can put all of them in one group.</p>
     */
    @Test
    void minGroups2() {
        final var intervals = new int[][]{{1,3},{5,6},{8,10},{11,13}};
        final var expected = 1;
        final var result = DivideIntervalsIntoMinimumNumberOfGroups.minGroups(intervals);

        assertEquals(expected, result);
    }

    @Test
    void minGroups3() {
        final var intervals = new int[][]{{182358,905545},{767576,788146},{708837,721240},{5403,628544}};
        final var expected = 2;
        final var result = DivideIntervalsIntoMinimumNumberOfGroups.minGroups(intervals);

        assertEquals(expected, result);
    }

    @Test
    void minGroups4() {
        final var intervals = new int[][]{
                {345385,459163},{488878,672220},{699540,843171},{933690,989585},{464177,571438},
                {866163,918913},{591587,882073},{60573,218993},{318079,988741},{127598,257483},
                {262798,879998},{737255,768552},{876985,978479},{32838,572570},{813934,824278},
                {662667,663799},{399123,493459},{753001,810212},{613011,938225},{620620,729949},
                {738106,767029},{521280,942809},{740237,990749},{183650,579724},{788375,914307},
                {367115,932319},{131533,999176},{285817,399078},{121914,713617},{659561,671349},
                {683841,837761},{942488,998807},{345549,649182},{425142,971822},{405562,932183},
                {591849,741756},{248299,984644},{311286,938950},{233871,666648},{338886,479045},
                {398609,618420},{79237,175331},{189057,635766},{592181,605741},{968224,986763},
                {846961,979951},{154255,335553},{758696,950667},{471081,518869},{90290,705107},
                {514127,907138},{366995,914228},{736937,814229},{677548,784538},{895231,921807},
                {329841,363846},{253880,346271},{222377,695081},{952062,972199},{209289,617668}};
        final var expected = 23;
        final var result = DivideIntervalsIntoMinimumNumberOfGroups.minGroups(intervals);

        assertEquals(expected, result);
    }

}