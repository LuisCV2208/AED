package pe.edu.utp.aed.week09;

import pe.edu.utp.aed.week06.SinglyLinkedListDemo2.Company;

public class TestSLL {
    public static void main(String[] args) {
        CompanySLLStack stack = new CompanySLLStack();

        stack.push(new Company("nombre 1","Pedro",1863));
        stack.push(new Company("nombre 2","Pedro1",1963));
        stack.push(new Company("nombre 3","Pedro2",2063));
        stack.push(new Company("nombre 4","Pedro3",2163));
        stack.push(new Company("nombre 5","Pedro4",2263));

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.pop());
    }

}
