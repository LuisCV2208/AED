package pe.edu.utp.aed.week02;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] numbers = { 15, 67, 8, 16, 44, 27, 12, 35 };

        System.out.println(Arrays.toString(numbers));
        quicksortIterative(numbers);
    }

    private static void quicksortIterative(int[] numbers) {
        int startIndex, endIndex, pos, top = 0;
        int[] minorStack = new int[numbers.length];
        int[] mayorStack = new int[numbers.length];

        minorStack[top] = 0;
        mayorStack[top] = numbers.length - 1;

        while (top >= 0) {
            startIndex = minorStack[top];
            endIndex = mayorStack[top];
            top--;

            pos = reduceIterative(numbers, startIndex, endIndex);
            if (startIndex < (pos - 1)) {
                top++;
                minorStack[top] = startIndex;
                mayorStack[top] = pos - 1;
            }
            if (endIndex > (pos + 1)) {
                top++;
                minorStack[top] = pos + 1;
                mayorStack[top] = endIndex;
            }
            //System.out.printf("start: %d, end: %d, pos: %d\n", startIndex, endIndex, pos);
            //System.out.println(Arrays.toString(numbers));
        }
    }

    private static int reduceIterative(int[] numbers, int startIndex, int endIndex) {
        int left, right, auxiliar, pos;
        boolean flag = true;

        left = pos = startIndex;
        right = endIndex;

        System.out.printf("reduceIterative >> start: %d, end: %d, pos: %d\n", startIndex, endIndex, pos);

        while(flag) {
            while ((numbers[pos] <= numbers[right]) && (pos != right)) {
                System.out.printf("pos: %d, right: %d, %d vs %d\n", pos, right, numbers[pos], numbers[right]);
                right--;
            }
            if (pos == right) {
                flag = false;
            } else {
                System.out.printf("pos: %d, right: %d, %d vs %d\n", pos, right, numbers[pos], numbers[right]);
                auxiliar = numbers[pos];
                numbers[pos] = numbers[right];;
                numbers[right] = auxiliar;
                //System.out.printf("start: %d, end: %d, pos: %d\n", startIndex, endIndex, pos);
                System.out.println(Arrays.toString(numbers));
                pos = right;
                while ((numbers[pos] >= numbers[left]) && (pos != left)) {
                    System.out.printf("pos: %d, left: %d, %d vs %d\n", pos, left, numbers[pos], numbers[left]);
                    left++;
                }
                if (pos == left) {
                    flag = false;
                } else {
                    System.out.printf("pos: %d, left: %d, %d vs %d\n", pos, left, numbers[pos], numbers[left]);
                    auxiliar = numbers[pos];
                    numbers[pos] = numbers[left];
                    numbers[left] = auxiliar;
                    //System.out.printf("start: %d, end: %d, pos: %d\n", startIndex, endIndex, pos);
                    System.out.println(Arrays.toString(numbers));
                    pos = left;
                }
            }
        }

        return pos;
    }
}
