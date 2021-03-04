package com.varmints.def;

import org.junit.Test;

public class TreeOperations {
    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }


    public void preOrder() {
        BinaryTree tree = getNodes();
        preOrder(tree.root);

    }


    public void inOrder() {
        BinaryTree tree = getNodes();
        inOrder(tree.root);

    }


    public void postOrder() {
        BinaryTree tree = getNodes();
        postOrder(tree.root);

    }


    public void levelOrder() {
        BinaryTree binaryTree = getNodes();
        int height = binaryTree.height(binaryTree.root);
        for (int i = 1; i <= height; i++)
            binaryTree.printGivenLevel(binaryTree.root, i);
    }


    public void heightOfTree() {
        BinaryTree binaryTree = getNodes();
        int height = binaryTree.height(binaryTree.root);
        System.out.println("Heigth of tree: " + height);
    }

    public void isBstTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);

        tree.root.left = new Node(2);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        tree.root.right = new Node(5);


        System.out.println("Is bst: "+isBST(tree.root));
    }


    boolean isBST(Node node) {
        if (node == null) {
            return false;
        }
        if ((node.left != null) && node.left.key > node.key) {
            return false;
        }
        if ((node.right != null) && node.right.key < node.key) {
            return false;
        }
        if (isBST(node.left) && isBST(node.right))
            return true;
        return true;
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" " + node.key);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(" " + node.key);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.key);
        preOrder(node.left);
        preOrder(node.right);
    }


    private BinaryTree getNodes() {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(10);
        tree.root.right.right.right = new Node(20);

        return tree;

    }

    class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight < rightHeight) {
                return rightHeight + 1;
            } else {
                return leftHeight + 1;
            }

        }

        void printGivenLevel(Node root, int level) {
            if (root == null)
                return;
            if (level == 1)
                System.out.print(root.key + " ");
            else if (level > 1) {
                printGivenLevel(root.left, level - 1);
                printGivenLevel(root.right, level - 1);
            }
        }
    }
}
