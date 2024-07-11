package pe.edu.utp.aed;

import java.io.File;

public class Draft {
    public static void main(String[] args) {
        /*int[] values = { 16, 14, 9, 25, 32, 7 };
        int key = 9;
        int result = search(key, values);
        System.out.println(result);*/
        printNumber(0);
    }

    private static void printNumber(int number) {
        if (number > 20) return;

        System.out.print(number + ",");
        printNumber(number + 1);
    }

    private static int search(int key, int[] values) {
        int i = 0;
        while ((i < values.length) && (key != values[i])) {
            i++;
        }
        return i;
    }
}
