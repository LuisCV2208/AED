package pe.edu.utp.aed.week02;

import java.util.Arrays;

public class BubbleSortWithSignal {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };
        int i = 1, auxiliar;
        boolean flag = false;

        System.out.println(Arrays.toString(numbers));
        while((i <= numbers.length - 1) && !flag) {
            flag = true;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    auxiliar = numbers[j];;
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = auxiliar;
                    flag = false;
                }
            }
            i++;
            System.out.println(Arrays.toString(numbers));
        }
    }
}
