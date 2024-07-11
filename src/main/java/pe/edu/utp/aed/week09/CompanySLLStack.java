package pe.edu.utp.aed.week09;

import pe.edu.utp.aed.week06.SinglyLinkedListDemo2.Company;

import javax.print.DocFlavor;
import java.util.LinkedList;

public class CompanySLLStack {
    private LinkedList<Company> elements = new LinkedList<>();
    public void push(Company e){
        elements.addLast(e);
    }

    public Company pop(){
        return elements.removeLast();
    }

    public Company peek(){
        return elements.getLast();
    }
    public int size(){
        return elements.size();
    }
    public boolean isEmpty(){
        return  elements.isEmpty();
    }
    public void clear(){
        elements.clear();
    }
}
