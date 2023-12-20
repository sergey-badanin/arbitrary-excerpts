package io.bsy.backtracking;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeWays {

    public int decodeWays(String digits) {
        var dict = IntStream.rangeClosed(1, 26).boxed().map(i -> i.toString()).collect(Collectors.toList());
        return decodeWaysWithDfs(digits, dict, 0);
    }

    private int decodeWaysWithDfs(String digits, List<String> dict, int matchIdx) {
        if (matchIdx == digits.length()) {
            return 1;
        }

        int result = 0;
        for (var token : dict) {
            var closingIdx = matchIdx + token.length();
            if (closingIdx <= digits.length() && digits.substring(matchIdx, closingIdx).startsWith(token)) {
                result += decodeWaysWithDfs(digits, dict, closingIdx);
            }
        }

        return result;
    }

}
