package pe.edu.utp.aed.week09;

import pe.edu.utp.aed.week06.SinglyLinkedListDemo2.Company;

public class CompanyStack {
    private Company[] elements;
    private int top;

    public CompanyStack(int capacity) {
        elements = new Company[capacity];
        top = -1;
    }

    public void push(Company e) {
        if (top + 1 == elements.length) {
            throw new StackOverflowError("Al tope");
        } else {
            top++;
            elements[top] = e;
        }
    }

    public Company pop() throws Exception {
        if (top == -1) {
            throw new Exception("La pila esta vacia");
        } else {
            Company e = elements[top];
            elements[top] = null;
            top--;
            return e;
        }
    }

    public Company peek() throws Exception {
        if (top == -1) {
            throw new Exception("Esta vacia");
        } else {
            return elements[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            elements[i] = null;
        }

        top = -1;
    }
}
