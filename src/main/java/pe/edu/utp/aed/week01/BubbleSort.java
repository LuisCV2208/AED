package pe.edu.utp.aed.week01;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        // int[] numbers = { 25, 12, 9, 17, 11, 4, 32, 28 };
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };
        int auxiliar;

        System.out.println(Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j >= i; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    auxiliar = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = auxiliar;
                }
            }
            System.out.println(Arrays.toString(numbers));
        }

    }
}
