package pe.edu.utp.aed.week08;

import java.util.LinkedList;

public class StringSLLQueue {
    private final LinkedList<String> elements;

    public StringSLLQueue() {
        this.elements = new LinkedList<>();
    }

    public void enqueue(String e) {
        elements.addLast(e);
    }

    public String dequeue() {
        return elements.removeFirst();
    }

    public String peek() {
        return elements.getFirst();
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

}
