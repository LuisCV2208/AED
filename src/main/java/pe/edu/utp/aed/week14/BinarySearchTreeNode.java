package pe.edu.utp.aed.week14;

public class BinarySearchTreeNode {

    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode rightChild;
    private int key;
    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public BinarySearchTreeNode getLeftChild() {
        return leftChild;
    }

    public BinarySearchTreeNode getRightChild() {
        return rightChild;
    }

    public BinarySearchTreeNode() {
        leftChild = null;
        rightChild = null;
    }

    public BinarySearchTreeNode(BinarySearchTreeNode leftChild,
                                BinarySearchTreeNode rightChild,
                                int key, String value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.key = key;
        this.value = value;
    }

    public BinarySearchTreeNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(BinarySearchTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinarySearchTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.format("%d:%s", key, value);
    }
}
