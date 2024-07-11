package pe.edu.utp.aed.week14;

public class BinarySearchTree {

    BinarySearchTreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int key, String value) {
        root = new BinarySearchTreeNode(key, value);
    }

    // region [Traverse Methods]
    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void preOrder(BinarySearchTreeNode root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    private void inOrder(BinarySearchTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root);
            inOrder(root.getRightChild());
        }
    }

    private void postOrder(BinarySearchTreeNode root) {
        if (root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.println(root);
        }
    }
    // endregion

    // region [Insertion method]
    public BinarySearchTreeNode insertion(int key, String value) {
        if (root == null) {
            root = insertion(null, key ,value);
            return root;
        }
        return insertion(root, key, value);
    }

    private BinarySearchTreeNode insertion(BinarySearchTreeNode root, int key, String value) {
        if (root == null) {
            root = new BinarySearchTreeNode(key, value);
            return root;
        }

        if (key < root.getKey()) {
            root.setLeftChild(insertion(root.getLeftChild(), key, value));
        } else {
            root.setRightChild(insertion(root.getRightChild(), key, value));
        }
        return root;
    }
    // endregion

    // region [Search method]
    public BinarySearchTreeNode search(int key) {
        return search(root, key);
    }

    private BinarySearchTreeNode search(BinarySearchTreeNode root, int key) {
        if (root == null || root.getKey() == key) {
            return root;
        }

        if (key < root.getKey())
            return search(root.getLeftChild(), key);

        return search(root.getRightChild(), key);
    }
    // endregion

    // region [Deletion methods]
    public BinarySearchTreeNode delete(int key) {
        return delete(root, key);
    }

    // Evaluate the three cases
    private BinarySearchTreeNode delete(BinarySearchTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.getKey()) {
            root.setLeftChild(delete(root.getLeftChild(), key));
        } else if (key > root.getKey()) {
            root.setRightChild(delete(root.getRightChild(), key));
        } else {
            if (root.getLeftChild() != null && root.getRightChild() != null) {
                BinarySearchTreeNode temporaryNode = findMinimun(root.getRightChild());
                root.setKey(temporaryNode.getKey());
                root.setValue(temporaryNode.getValue());
                root.setRightChild(delete(root.getRightChild(), root.getKey()));
            } else if (root.getLeftChild() != null || root.getRightChild() != null) {
                root = root.getLeftChild() == null ? root.getRightChild() : root.getLeftChild();
            } else {
                return null;
            }
        }

        return root;
    }

    private BinarySearchTreeNode findMinimun(BinarySearchTreeNode root) {
        if (root == null) return null;
        else {
            if (root.getLeftChild() == null) return root;
            return findMinimun(root.getLeftChild());
        }
    }
    // endregion
}
