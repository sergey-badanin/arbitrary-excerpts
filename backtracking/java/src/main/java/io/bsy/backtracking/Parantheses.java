package io.bsy.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Parantheses {

    public List<String> generate(int n) {
        return generateWithDfs("", n, n, n);
    }

    private List<String> generateWithDfs(String state, int leftRemain, int rightRemain, int total) {
        if (rightRemain == 0) {
            return new ArrayList<String>(List.of(state));
        }

        var result = new ArrayList<String>();
        if (isLeftPlaceble(leftRemain, rightRemain, total)) {
            var newState = state + "(";
            result.addAll(generateWithDfs(newState, leftRemain - 1, rightRemain, total));
        }
        if (isRightPlaceble(leftRemain, rightRemain, total)) {
            var newState = state + ")";
            result.addAll(generateWithDfs(newState, leftRemain, rightRemain - 1, total));
        }

        return result;
    }

    private boolean isLeftPlaceble(int leftRemain, int rightRemain, int total) {
        return leftRemain > 0;
    }

    private boolean isRightPlaceble(int leftRemain, int rightRemain, int total) {
        return rightRemain - leftRemain > 0;
    }
}
