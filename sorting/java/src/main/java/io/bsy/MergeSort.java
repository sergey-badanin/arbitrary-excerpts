package io.bsy;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MergeSort<T extends Comparable<T>> {

    Class<T> cls;

    MergeSort(Class<T> cls) {
        this.cls = cls;
    }

    public T[] perform(T[] input) {

        Deque<MergablePair> current = new ArrayDeque<>();
        Deque<MergablePair> next = new ArrayDeque<>();
        Deque<MergablePair> result = new ArrayDeque<>();
        if (input.length > 1) {
            MergablePair pair = split(new Slice(0, input.length), input);
            if (isSplittable(pair)) {
                current.push(pair);
            }
            result.push(pair);
        } else {
            return input;
        }

        while (!current.isEmpty()) {
            while (!current.isEmpty()) {
                var pair = current.pop();

                if (pair.right == null)
                    continue;

                MergablePair leftPair = split(pair.left, input);
                MergablePair rightPair = split(pair.right, input);

                result.push(leftPair);
                leftPair.parent = pair;
                leftPair.isLeftForParent = true;
                if (isSplittable(leftPair)) {
                    next.push(leftPair);
                }

                result.push(rightPair);
                rightPair.parent = pair;
                if (isSplittable(rightPair)) {
                    next.push(rightPair);
                }
            }
            var tmp = current;
            current = next;
            next = tmp;
        }

        System.out.println("Result: [" + result + "]\n");

        T[] output = (T[]) Array.newInstance(cls, 1);
        while (!result.isEmpty()) {
            output = result.pop().merge();
        }

        System.out.println(Arrays.toString(output));
        return output;
    }

    private boolean isSplittable(MergablePair pair) {
        if (pair.right == null) {
            return false;
        }
        return (pair.left.closingIndex - pair.left.openIndex > 1)
                || (pair.right.closingIndex - pair.right.openIndex > 1);
    }

    private MergablePair split(Slice slice, T[] source) {
        var length = slice.closingIndex - slice.openIndex;
        if (length > 1) {
            int half = length / 2;
            var left = new Slice(slice.openIndex, slice.openIndex + half);
            var right = new Slice(slice.openIndex + half, slice.closingIndex);
            return new MergablePair(left, right, source);
        }
        return new MergablePair(slice, null, source);
    }

    class MergablePair {
        Slice left;
        Slice right;
        boolean isLeftForParent;
        T[] leftArr;
        T[] rightArr;
        MergablePair parent;
        T[] source;

        MergablePair(Slice left, Slice right, T[] source) {
            this.left = left;
            this.right = right;
            this.source = source;
        }

        T[] merge() {
            if (leftArr == null) {
                leftArr = (T[]) Array.newInstance(MergeSort.this.cls, 1);
                leftArr[0] = source[left.openIndex];
            }
            if (rightArr == null && right != null) {
                rightArr = (T[]) Array.newInstance(MergeSort.this.cls, 1);
                rightArr[0] = source[right.openIndex];
            }
            if (rightArr == null && parent != null) {
                if (isLeftForParent) {
                    parent.leftArr = leftArr;
                } else {
                    parent.rightArr = leftArr;
                }
                return null;
            }

            var resultSize = leftArr.length + rightArr.length;
            var result = (T[]) Array.newInstance(MergeSort.this.cls, resultSize);

            var leftIndex = 0;
            var rightIndex = 0;
            for (int i = 0; i < resultSize; i++) {
                if (leftIndex == leftArr.length) {
                    result[i] = rightArr[rightIndex];
                    rightIndex += 1;
                    continue;
                }
                if (rightIndex == rightArr.length) {
                    result[i] = leftArr[leftIndex];
                    leftIndex += 1;
                    continue;
                }
                var comp = leftArr[leftIndex].compareTo(rightArr[rightIndex]);
                if (comp <= 0) {
                    result[i] = leftArr[leftIndex];
                    leftIndex += 1;
                } else {
                    result[i] = rightArr[rightIndex];
                    rightIndex += 1;
                }
            }
            if (parent != null)
                if (isLeftForParent) {
                    parent.leftArr = result;
                } else {
                    parent.rightArr = result;
                }
            return result;
        }
    }

    record Slice(int openIndex, int closingIndex) {
    }
}
