package io.bsy.backtracking;

import java.util.List;

public class WordBreak {

    public boolean resolve(String s, List<String> words) {
        return resolveWithDfs(s, words, 0, new Boolean[s.length()]);
    }

    public boolean resolveWithDfs(String target, List<String> words, int matchingIdx, Boolean[] resolvedBranches) {
        if (matchingIdx == target.length()) {
            return true;
        }

        if (resolvedBranches[matchingIdx] != null) {
            return resolvedBranches[matchingIdx];
        }

        var result = false;
        for (var word : words) {
            var endSeekIdx = matchingIdx + word.length();
            if (endSeekIdx <= target.length() && target.substring(matchingIdx, endSeekIdx).equals(word)) {
                result = result || resolveWithDfs(target, words, endSeekIdx, resolvedBranches);
            }
        }
        resolvedBranches[matchingIdx] = result;
        return result;
    }

}
