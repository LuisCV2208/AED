package pe.edu.utp.aed.week08.DemoPriorityQueue;

import java.time.LocalDateTime;

public class QCustomer {
    int order;
    String name;
    int age;
    CustomerType type;
    LocalDateTime hour;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public QCustomer(int order, String name, int age,
                     CustomerType type, LocalDateTime hour) {
        this.order = order;
        this.name = name;
        this.age = age;
        this.type = type;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "QCustomer{" +
                "order=" + order +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", hour=" + hour +
                '}';
    }
}
