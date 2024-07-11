package pe.edu.utp.aed.week02;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };

        System.out.println(Arrays.toString(numbers));
        shell(numbers);
    }

    private static void shell(int[] numbers) {
        int interval = numbers.length, index, auxiliar;
        boolean flag;

        while (interval > 0) {
            interval /= 2;
            flag = true;

            while (flag) {
                flag = false;
                index = 0;

                while ((index + interval) < numbers.length) {
                    if (numbers[index] > numbers[index + interval]) {
                        auxiliar = numbers[index];
                        numbers[index] = numbers[index + interval];
                        numbers[index + interval] = auxiliar;
                        flag = true;
                        System.out.println(Arrays.toString(numbers));
                    }
                    index++;
                }
            }
        }
    }
}
