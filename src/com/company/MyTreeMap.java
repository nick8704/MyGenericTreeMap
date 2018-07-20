package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTreeMap<K, V> {

    public class Node<K extends Comparable<?>> {
        Object key;
        int value;
        Node<K> left;
        Node<K> right;
        Node<K> parent;
        boolean isLeft = false;
        boolean isRight = false;
    }

    private Node root;
    private int size = 0;
    private Map<Object, Integer> map = new HashMap<>();
    private List<Node> nodes = new ArrayList<>();

    public void put(K key, int value) {
        if (containsKey(key)) {
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        if (root == null) {
            root = node;
        } else {
            addToTree(root, node);
        }
        size++;
        map.put(key, value);
        nodes.add(node);
    }

    private void addToTree(Node root, Node node) {
        if (node.value < root.value) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
                node.isLeft = true;
            } else {
                addToTree(root.left, node);
            }
        } else if (node.value > root.value) {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
                node.isRight = true;
            } else {
                addToTree(root.right, node);
            }
        }
    }

    public boolean containsKey(Object o) {
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (o.equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Integer o) {
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (o.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public void remove(Object o) {
        if (!containsKey(o) || size == 0) {
            return;
        } else if (size == 1) {
            clear();
        } else {
            removeFromTree(o);
            size--;
        }
    }

    private void removeFromTree(Object o) {
        for (Node node : nodes) {
            if (o.equals(node.key)) {
                if (node.left == null && node.right == null) {
                    if (node.isRight) {
                        node.parent.right = null;
                    } else if (node.isLeft) {
                        node.parent.left = null;
                    }
                    nodes.remove(node);
                    map.remove(o);
                } else if (node.left == null) {
                    if (node.isRight) {
                        node.parent.right = node.right;
                    } else if (node.isLeft) {
                        node.parent.left = node.right;
                    }
                    nodes.remove(node);
                    map.remove(o);
                } else if (node.right == null) {
                    if (node.isRight) {
                        node.parent.right = node.left;
                    } else if (node.isLeft) {
                        node.parent.left = node.left;
                    }
                    nodes.remove(node);
                    map.remove(o);
                } else {
                    nodes.remove(node);
                    map.remove(o);
                    clear();
                    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
                        put((K) entry.getKey(), entry.getValue());
                    }
                }
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        root = null;
        map.clear();
        nodes.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append(", ");
        }
        return "[" + sb.toString().substring(0, sb.toString().length() - 2) + "]";
    }

}