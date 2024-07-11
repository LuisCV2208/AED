package pe.edu.utp.aed.week14;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertion(5,"Chiclayo");
        tree.insertion(9,"Trujillo");
        tree.insertion(14,"Lima");
        tree.insertion(13,"Piura");
        tree.insertion(10,"Arequipa");
        tree.insertion(2,"Cajamarca");
        tree.insertion(1,"Tacna");

        BinarySearchTreeNode nodo = tree.insertion(4,"Moquegua");
        System.out.println(nodo);

        tree.delete(9);
        //tree.inOrder();
        tree.preOrder();

        /*BinarySearchTreeNode nodoBuscado = tree.search(14);
        if (nodoBuscado != null) {
            System.out.println(nodoBuscado);
        } else {
            System.out.println("14 no encontrado");
        }

        nodoBuscado = tree.search(25);
        if (nodoBuscado != null) {
            System.out.println(nodoBuscado);
        } else {
            System.out.println("25 no encontrado");
        }*/
    }
}
