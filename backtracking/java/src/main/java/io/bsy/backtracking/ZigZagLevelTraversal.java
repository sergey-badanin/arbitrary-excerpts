package io.bsy.backtracking;

import java.util.LinkedList;
import java.util.List;

import io.bsy.backtracking.BinaryTree.Node;

public class ZigZagLevelTraversal {

    public List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        var nodes = new LinkedList<Node<Integer>>();
        var nextLevelNodes = new LinkedList<Node<Integer>>();
        var values = new LinkedList<Integer>();
        var levels = new LinkedList<List<Integer>>();

        nodes.addLast(root);
        var reverse = false;
        while (!nodes.isEmpty()) {
            var node = nodes.removeFirst();

            if (node.left != null) {
                nextLevelNodes.addLast(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.addLast(node.right);
            }

            if (reverse) {
                values.addFirst(node.val);
            } else {
                values.addLast(node.val);
            }

            if (nodes.isEmpty()) {
                reverse = !reverse;
                nodes = nextLevelNodes;
                nextLevelNodes = new LinkedList<Node<Integer>>();
                levels.addLast(values);
                values = new LinkedList<Integer>();
            }
        }
        return levels;
    }
}
