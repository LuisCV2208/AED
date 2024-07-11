package pe.edu.utp.aed.week06.SinglyLinkedListDemo2;

import java.util.Iterator;
import java.util.Objects;

/**
 * New version of SinglyLinkedList that hides the CompanyNode declaration
 * in order to encapsulate the internal structure of a list.
 * You can use this approach as a base to create your own implementation
 * using generics.
 */
public class SinglyLinkedList implements Iterable<Company> {

    @Override
    public Iterator<Company> iterator() {
        Iterator iterator = new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();

            }

            @Override
            public Object next() {

                try {
                    //System.out.println(getNode(index).next);
                    return get(index++);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return iterator;
    }

    /**
     * This class is now private in order to avoid create nodes from outside
     * the list. This way makes possible to manage a list of Companies
     * instead of a list of nodes (CompanyNode)
     * It's more natural for the clients and reduce complexity.
     * All the logic remains the same.
     */
    private static class CompanyNode {
        private final Company company;
        private CompanyNode next;

        public CompanyNode(Company company) {
            this.company = company;
            next = null;
        }

        public Company getCompany() {
            return company;
        }

        public CompanyNode getNext() {
            return next;
        }

        public void setNext(CompanyNode next) {
            this.next = next;
        }

        // toString() implementation has been removed because it's not
        // necessary anymore. The get() method of SinglyLinkedList returns now a Company
        // instead of a CompanyNode by using the getCompany() getter.
    }

    private CompanyNode head;
    private int numberOfNodes = 0;

    public SinglyLinkedList(Company company) {
        head = new CompanyNode(company);
    }

    public SinglyLinkedList() {
        head = null;
    }

    public void add(Company company) {
        CompanyNode newNode = new CompanyNode(company);
        // is it the first node?
        if (head == null) {
            head = newNode;
        } else {
            // we must iterate until we reach the final of the list
            CompanyNode end = head;
            while (end.getNext() != null) {
                end = end.getNext();
            }
            end.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void add(int index, Company company) throws Exception {
        CompanyNode newNode = new CompanyNode(company);

        if ((numberOfNodes == 0 && index != 0)
                || index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        if (numberOfNodes == 0 && index == 0) {
            head = newNode;
        } else {
            CompanyNode previous = getNode(index - 1);
            assert previous != null;
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void addFirst(Company company) {
        CompanyNode newNode = new CompanyNode(company);
        newNode.setNext(head);
        head = newNode;
        numberOfNodes++;
    }

    public void addLast(Company company) {
        add(company);
    }

    public int size() {
        return numberOfNodes;
    }

    private CompanyNode getNode(int index) throws Exception {
        if (numberOfNodes == 0) return null;
        if (index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        int currentIndex = 0;
        CompanyNode end = head;
        while (end.getNext() != null && currentIndex != index) {
            end = end.getNext();
            currentIndex++;
        }
        return end;
    }

    public Company get(int index) throws Exception {
        return Objects.requireNonNull(getNode(index)).getCompany();
    }


    public void remove(int index) {
        //ELIMINACIÓN al inicio DE UNA LISTA

        if (index < 0 || index >= numberOfNodes) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size() - 1) {
            removeLast();
            return;
        }

        try {
            CompanyNode prevNode = getNode(index - 1);
            CompanyNode aux = prevNode.getNext().getNext();
            prevNode.getNext().setNext(null);
            prevNode.setNext(aux);
            numberOfNodes--;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFirst() {
        CompanyNode auxiliar = head;
        head = head.getNext();
        auxiliar.setNext(null);
        numberOfNodes--;
    }

    public void removeLast() {
        //Eliminación al final de la lista
        try {
            CompanyNode previousNode = getNode(numberOfNodes - 2);
            previousNode.setNext(null);
            numberOfNodes--;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAll(Company[] companies) {
        for (Company company: companies) {
            add(company);
        }
    }

    public void reverse(){
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = size()-1; i >=0 ; i--) {
            try {
                list.add(get(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        head=list.head;
    }
    public Company[] toArray(){
       Company [] list = new Company[size()];
        CompanyNode end = head;
        int index = 0;
        while (end!= null) {
            list[index] = end.getCompany();
            index++;
            end = end.getNext();
        }
        return list;

    }
}
