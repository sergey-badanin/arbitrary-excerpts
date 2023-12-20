package io.bsy.backtracking;

import java.util.LinkedList;
import java.util.List;

import io.bsy.backtracking.BinaryTree.Node;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        var nodes = new LinkedList<Node<Integer>>();
        var nextLevelNodes = new LinkedList<Node<Integer>>();
        var values = new LinkedList<Integer>();
        var levels = new LinkedList<List<Integer>>();

        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            var node = nodes.removeFirst();

            if(node.left != null) {
                nextLevelNodes.addLast(node.left);
            }
            if(node.right != null) {
                nextLevelNodes.addLast(node.right);
            }

            values.addLast(node.val);

            if (nodes.isEmpty()) {
                nodes = nextLevelNodes;
                nextLevelNodes = new LinkedList<Node<Integer>>();
                levels.addLast(values);
                values = new LinkedList<Integer>();
            }
        }

        return levels;
    }
}
