package pe.edu.utp.aed.week13;

public class Node {
    private String data;
    private Node leftChild;
    private Node rightChild;

    public Node() {
        leftChild = null;
        rightChild = null;
    }

    public Node(String data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(String data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
