package pe.edu.utp.aed.week06.SinglyLinkedListDemo;

public class SinglyLinkedList {
    private CompanyNode head;
    int numberOfNodes = 0;

    public SinglyLinkedList(CompanyNode firstNode) {
        head = firstNode;
    }

    public SinglyLinkedList() {
        head = null;
    }

    public void add(CompanyNode newNode) {
        // is it the first node?
        if (head == null) {
            head = newNode;
        } else {
            // we must iterate until we reach the final of the list
            CompanyNode end = head;
            while(end.getNext() != null) {
                end = end.getNext();
            }
            end.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void add(int index, CompanyNode newNode) throws Exception {
        if ((numberOfNodes == 0 && index != 0)
                || index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        if (numberOfNodes == 0 && index == 0) {
            head = newNode;
        } else {
            CompanyNode previous = get(index - 1);
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }
        numberOfNodes++;
    }

    public void addFirst(CompanyNode newNode){
        newNode.setNext(head);
        head = newNode;
        numberOfNodes++;
    }

    public void addLast(CompanyNode newNode) {
        add(newNode);
    }

    public int size() {
        return numberOfNodes;
    }

    public CompanyNode get(int index) throws Exception {
        if (numberOfNodes == 0) return null;
        if (index >= numberOfNodes || index < 0) {
            throw new Exception("Index is out of range!");
        }

        int currentIndex = 0;
        CompanyNode end = head;
        while(end.getNext() != null && currentIndex != index) {
            end = end.getNext();
            currentIndex++;
        }
        return end;
    }

}
