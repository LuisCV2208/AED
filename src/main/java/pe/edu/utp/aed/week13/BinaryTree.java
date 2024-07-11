package pe.edu.utp.aed.week13;

public class BinaryTree {
    private Node root;

    public static void preOrden(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrden(root.getLeftChild());
            preOrden(root.getRightChild());
        }
    }

    public static void inOrden(Node root) {
        if (root != null) {
            inOrden(root.getLeftChild());
            System.out.println(root.getData());
            inOrden(root.getRightChild());
        }
    }

    public static void postOrden(Node root) {
        if (root != null) {
            postOrden(root.getLeftChild());
            postOrden(root.getRightChild());
            System.out.println(root.getData());
        }
    }
}
