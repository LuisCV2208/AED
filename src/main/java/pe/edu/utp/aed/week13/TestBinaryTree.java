package pe.edu.utp.aed.week13;

public class TestBinaryTree {
    public static void main(String[] args) {
        // Caso 01
        Node root = new Node("*");
        Node leftChild = new Node("+");
        leftChild.setLeftChild(new Node("1"));
        leftChild.setRightChild(new Node("3"));
        root.setLeftChild(leftChild);
        Node rightChild = new Node("-");
        rightChild.setLeftChild(new Node("5"));
        rightChild.setRightChild(new Node("7"));
        root.setRightChild(rightChild);

        // Caso 02
        /*Node root = new Node("+");
        Node leftChild = new Node("/");
        leftChild.setLeftChild(new Node("6"));
        leftChild.setRightChild(new Node("2"));
        root.setLeftChild(leftChild);
        Node rightChild = new Node("7");
        root.setRightChild(rightChild);*/

        //BinaryTree.preOrden(root);
        //BinaryTree.inOrden(root);
        BinaryTree.postOrden(root);
    }
}
