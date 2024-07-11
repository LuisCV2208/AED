package pe.edu.utp.aed.week14;

public class BinaryTreeSearchNode {

    private BinaryTreeSearchNode leftChild;
    private BinaryTreeSearchNode rightChild;
    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public BinaryTreeSearchNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeSearchNode getRightChild() {
        return rightChild;
    }

    public BinaryTreeSearchNode() {
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeSearchNode(BinaryTreeSearchNode leftChild,
                                BinaryTreeSearchNode rightChild,
                                int key, String value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.key = key;
        this.value = value;
    }

    public BinaryTreeSearchNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(BinaryTreeSearchNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeSearchNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.format("%d:%s", key, value);
    }
}
