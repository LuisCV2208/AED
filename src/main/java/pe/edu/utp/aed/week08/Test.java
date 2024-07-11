package pe.edu.utp.aed.week08;

public class Test {
    public static void main(String[] args) {
        StringQueue sq = new StringQueue(7);
        try {
            sq.enqueue("A");
            sq.enqueue("B");
            sq.enqueue("C");
            sq.enqueue("D");
            sq.enqueue("E");
            sq.enqueue("F");
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            sq.enqueue("G");
            sq.enqueue("H");
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            /*System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.isEmpty());*/
            sq.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
