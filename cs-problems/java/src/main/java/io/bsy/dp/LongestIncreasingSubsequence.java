package io.bsy.dp;

import java.util.List;

public class LongestIncreasingSubsequence {

    public static int solve(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        var longestAtIdx = new int[nums.size()];

        var longestSoFar = 1;
        for (int i = 0; i < longestAtIdx.length; i++) {
            var longestForCurr = 1;
            for (int j = 0; j < i; j++) {
                int probable = 1;
                if (nums.get(i) > nums.get(j)) {
                    probable = longestAtIdx[j] + 1;
                }
                if (probable > longestForCurr) {
                    longestForCurr = probable;
                }
            }

            longestAtIdx[i] = longestForCurr;
            if (longestForCurr > longestSoFar) {
                longestSoFar = longestForCurr;
            }
        }

        return longestSoFar;
    }
}
