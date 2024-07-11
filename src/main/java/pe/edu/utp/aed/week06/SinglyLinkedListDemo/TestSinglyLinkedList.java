package pe.edu.utp.aed.week06.SinglyLinkedListDemo;

public class TestSinglyLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList();

        CompanyNode node = new CompanyNode("Apple", "Tim Cook", 1980);
        linkedList.add(node);

        linkedList.add(new CompanyNode("Microsoft", "Satya Nadella", 1975));
        linkedList.add(new CompanyNode("Tesla", "Elon Musk", 1980));
        linkedList.add(new CompanyNode("Google", "Sundar Pichai", 1991));

        try {
            linkedList.add(2, new CompanyNode("ChatGPT", "Sam Altman", 1998));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        linkedList.addFirst(new CompanyNode("Amazon", "Jeff Bezos", 1984));
        linkedList.addLast(new CompanyNode("Meta", "Mark Zuckerberg", 1999));

        try {
            for (int i = 0; i < linkedList.size(); i++) {
                System.out.println(linkedList.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
