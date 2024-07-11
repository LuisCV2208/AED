package pe.edu.utp.aed.week02;

import java.util.Arrays;

public class ShakerSort {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };
        int auxiliar, left, right, k;

        left = 1;
        right = k = (numbers.length - 1);

        System.out.println(Arrays.toString(numbers));
        while (right >= left) {
            System.out.printf("l: %d, r:%d\n", left, right);
            for (int i = right; i >= left; i--) {
                if (numbers[i - 1] > numbers[i]) {
                    auxiliar = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = auxiliar;
                    k = i;
                }
            }
            left = k + 1;
            //System.out.printf("RTL last auxiliar position: %d\n", k);
            System.out.println(Arrays.toString(numbers));
            System.out.printf("l: %d, r:%d\n", left, right);
            for (int i = left; i <= right; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    auxiliar = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = auxiliar;
                    k = i;
                }
            }
            right = k - 1;
            //System.out.printf("LTR last auxiliar position: %d\n", k);
            System.out.println(Arrays.toString(numbers));
        }
    }
}
