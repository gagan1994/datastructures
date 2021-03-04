package com.varmints.trees;

public class BinarySearchTree<T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T val;
        Node left;
        Node right;

        public Node(T val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean addItem(T item) {
        if (contains(item)) {
            return false;
        }
        root = addItem(root, item);
        nodeCount++;
        return true;
    }

    public boolean remove(T item) {
        if (!contains(item)) {
            return false;
        }
        root = removeItem(root, item);
        nodeCount--;
        return true;
    }

    private boolean contains(T item) {
        return contains(root, item);
    }

    private boolean contains(Node node, T item) {
        if (node == null) return false;
        int compare = node.val.compareTo(item);
        if (compare == 0) return true;
        if (compare > 0) {
            contains(node.right, item);
        } else {
            contains(node.left, item);
        }
        return false;
    }

    private Node removeItem(Node node, T item) {
        if (node == null) return null;
        int compare = item.compareTo(node.val);
        if (compare > 0) {
            return removeItem(node.right, item);
        } else if (compare < 0) {
            return removeItem(node.left, item);
        } else {
            if (node.left == null) {
                Node rightChild = node.right;
                node.val = null;
                node = null;
                return rightChild;
            }
            if (node.right == null) {
                Node leftChild = node.left;
                node.val = null;
                node = null;
                return leftChild;
            }
            Node temp = digLeft(node.right);
            node.val = temp.val;
            node.right = removeItem(node.right, temp.val);
        }
        return node;
    }

    private Node digLeft(Node right) {
        if (right.left == null) {
            return right;
        }
        return right.left;
    }

    private Node addItem(Node node, T item) {
        if (node == null) {
            return new Node(item, null, null);
        }
        if (node.val.compareTo(item) > 0) {
            node.right = addItem(node.right, item);
        } else {
            node.left = addItem(node.left, item);
        }
        return node;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if (node == null) return;
        System.out.println(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + "");
        inorderTraversal(node.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

}
