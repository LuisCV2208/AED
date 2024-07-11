package pe.edu.utp.aed.week01;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };
        int auxiliar, k;

        System.out.println(Arrays.toString(numbers));
        for (int i = 1; i < numbers.length; i++) {
            auxiliar = numbers[i];
            k = i - 1;
            while ((k >= 0) && (auxiliar < numbers[k])) {
                numbers[k + 1] = numbers[k];
                k--;
            }
            numbers[k + 1]= auxiliar;
            System.out.println(Arrays.toString(numbers));
        }
    }
}
