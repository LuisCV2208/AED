package pe.edu.utp.aed.week08.DemoPriorityQueue;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {

        // 1. Creating the Comparators
        Comparator byAge = Comparator.comparing(QCustomer::getAge);
        Comparator byType = Comparator.comparing(QCustomer::getType);
        Comparator byHour = Comparator.comparing(QCustomer::getHour);

        // 2. Creating the business rules, based on comparators
        Comparator businessRule = byAge.thenComparing(byType).thenComparing(byHour);

        // 3. Creating the PriorityQueue queue
        PriorityQueue<QCustomer> customersQueue = new PriorityQueue<>(businessRule);

        // 4. Adding customers to the priority queue
        customersQueue.add(
                new QCustomer(1, "JUAN", 70, CustomerType.REGULAR,
                        LocalDateTime.of(2024, 5, 16, 10, 0, 0)));
        customersQueue.add(
                new QCustomer(2, "CARLOS", 70, CustomerType.GOLD,
                        LocalDateTime.of(2024, 5, 16, 10, 30, 0)));
        customersQueue.add(
                new QCustomer(3, "JULIO", 70, CustomerType.PREMIUM,
                        LocalDateTime.of(2024, 5, 16, 11, 0, 0)));
        customersQueue.add(
                new QCustomer(4, "ROSA", 70, CustomerType.GOLD,
                        LocalDateTime.of(2024, 5, 16, 11, 30, 0)));
        customersQueue.add(
                new QCustomer(5, "GABRIEL", 70, CustomerType.GOLD,
                        LocalDateTime.of(2024, 5, 16, 12, 0, 0)));
        customersQueue.add(
                new QCustomer(6, "EDUARDO", 70, CustomerType.PREMIUM,
                        LocalDateTime.of(2024, 5, 16, 12, 30, 0)));

        System.out.println("Elements after being added");
        System.out.println(customersQueue);

        // Processing the priority queue
        System.out.println("Processing customers...");
        System.out.println(customersQueue.poll());
        System.out.println(customersQueue.poll());
        System.out.println(customersQueue.poll());
        System.out.println(customersQueue.poll());
        System.out.println(customersQueue.poll());
        System.out.println(customersQueue.poll());
    }
}
