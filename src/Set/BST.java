package Set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zeng.chengquan on 2018/6/3 0003.
 */
public class BST<E extends Comparable> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOreder() {
        inOreder(root);
    }

    private void inOreder(Node node) {
        if (node == null) {
            return;
        }
        inOreder(node.left);
        System.out.println(node.e);
        inOreder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E findMin() {
        return findMin(root).e;
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public E findMax() {
        return findMax(root).e;
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public void removeMin() {
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            node.right = null;
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void removeMax() {
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            node.left = null;
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            throw new IllegalArgumentException("didn't find " + e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = findMin(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        gengerateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void gengerateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(gengerateBSTDepthString(depth) + "null\n");
            return;
        }
        sb.append(gengerateBSTDepthString(depth) + node.e + "\n");
        gengerateBSTString(node.left, depth + 1, sb);
        gengerateBSTString(node.right, depth + 1, sb);
    }

    private String gengerateBSTDepthString(int depth) {
        String res = "";
        for (int i = 0; i < depth; i++) {
            res = res + "--";
        }
        return res;
    }
}
