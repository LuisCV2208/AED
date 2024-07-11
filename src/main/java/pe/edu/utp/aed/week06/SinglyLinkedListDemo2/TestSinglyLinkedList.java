package pe.edu.utp.aed.week06.SinglyLinkedListDemo2;

import pe.edu.utp.aed.week06.SinglyLinkedListDemo.CompanyNode;

import java.util.Arrays;

public class TestSinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        Company company = new Company("Apple", "Tim Cook", 1980);
        linkedList.add(company);

        linkedList.add(new Company("Microsoft", "Satya Nadella", 1975));
        linkedList.add(new Company("Tesla", "Elon Musk", 1980));
        linkedList.add(new Company("Google", "Sundar Pichai", 1991));

        try {
            linkedList.add(2, new Company("ChatGPT", "Sam Altman", 1998));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        linkedList.addFirst(new Company("Amazon", "Jeff Bezos", 1984));
        linkedList.addLast(new Company("Meta", "Mark Zuckerberg", 1999));

        try {
            for (int i = 0; i < linkedList.size(); i++) {
                System.out.println(linkedList.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(linkedList.size());

        System.out.println("For de Colección:");
        for (Company comp : linkedList) {
            System.out.println(comp);
        }
        linkedList.remove(0);
        System.out.println("Lista después de eliminar el primer elemento");
          for (Company comp : linkedList) {
            System.out.println(comp);
        }
        System.out.println("Eliminando el último elemento");
          linkedList.remove(linkedList.size() - 1);
        System.out.println();
        for (Company comp : linkedList) {
            System.out.println(comp);
        }
        
        linkedList.remove(3);
        System.out.println("\nRemueve el nodo 3");
        for (Company comapany : linkedList) {
            System.out.println(comapany);
        }

        System.out.println("\n reverse");
        linkedList.reverse();
        for (Company comapany : linkedList) {
            System.out.println(comapany);
        }
        System.out.println(Arrays.toString(linkedList.toArray()));

    }
}
