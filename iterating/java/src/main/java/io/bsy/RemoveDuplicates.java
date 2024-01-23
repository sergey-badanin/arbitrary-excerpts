package io.bsy;

import java.util.List;

public class RemoveDuplicates {

    public static int removeDuplicates(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr.size();
        }

        var slow = 0;
        var fast = 1;

        while (fast < arr.size()) {
            if (arr.get(slow).equals(arr.get(fast))) {
                arr.remove(fast);
                continue;
            }
            slow += 1;
            fast += 1;
        }

        return arr.size();
    }
}
