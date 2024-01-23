package io.bsy.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestDivisibleSubset {

    public static int solve(List<Integer> nums) {
        nums = new ArrayList<>(nums);
        Collections.sort(nums);

        var overallLongest = 1;
        var longestForIdx = new int[nums.size()];
        for (int i = 0; i < longestForIdx.length; i++) {
            var ithLongest = 1;
            for (int j = 0; j < i; j++) {
                var ith = nums.get(i);
                var jth = nums.get(j);
                var jthLongest = longestForIdx[j];
                if (ith % jth == 0 && jthLongest + 1 > ithLongest) {
                    ithLongest = jthLongest + 1;
                }
            }
            longestForIdx[i] = ithLongest;
            if (ithLongest > overallLongest) {
                overallLongest = ithLongest;
            }
        }

        return overallLongest;
    }
}
