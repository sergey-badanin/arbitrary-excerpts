package io.bsy.backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FourWheelLock {

    public static int numSteps(String targetCombo, List<String> trappedCombos) {
        var queue = new LinkedList<String>();
        var comboSteps = new HashMap<String, Integer>();
        var starting = "0000";
        queue.add(starting);
        comboSteps.put(starting, 0);

        while (!queue.isEmpty()) {
            var top = queue.removeFirst();
            var topSteps = comboSteps.get(top);

            if (top.equals(targetCombo)) {
                return topSteps;
            }

            var connected = getConnected(top);
            for (var combo : connected) {
                if (!comboSteps.containsKey(combo) && !trappedCombos.contains(combo)) {
                    comboSteps.put(combo, topSteps + 1);
                    queue.addLast(combo);
                }
            }
        }

        return -1;
    }

    private static int[] getCombo(String combo) {
        var result = new int[4];
        for (int i = 0; i < combo.length(); i++) {
            result[i] = Character.getNumericValue(combo.charAt(i));
        }
        return result;
    }

    private static Collection<String> getConnected(String combo) {
        var result = new ArrayList<int[]>();
        var state = getCombo(combo);

        for (int i = 0; i < state.length; i++) {
            var newCombo = state.clone();
            increaseWheel(state, newCombo, i);
            result.add(newCombo);
        }

        for (int i = 0; i < state.length; i++) {
            var newCombo = state.clone();
            decreaseWheel(state, newCombo, i);
            result.add(newCombo);
        }
        return result.stream()
                .map(FourWheelLock::from)
                .collect(Collectors.toList());
    }

    private static String from(int[] combo) {
        var builder = new StringBuilder();
        for (int i = 0; i < combo.length; i++) {
            builder.append(Integer.toString(combo[i]));
        }
        return builder.toString();
    }

    private static void increaseWheel(int[] state, int[] newState, int wheel) {
        newState[wheel] = (state[wheel] + 1) % 10;
    }

    private static void decreaseWheel(int[] state, int[] newState, int wheel) {
        if (state[wheel] == 0) {
            newState[wheel] = 9;
        } else {
            newState[wheel] = state[wheel] - 1;
        }
    }

}
