package pe.edu.utp.aed.week02;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {15, 67, 8, 16, 44, 27, 12, 35};
        mergeSort(numbers, 0, "all");
        // System.out.println(Arrays.toString(numbers));
    }

    private static void mergeSort(int[] numbers, int recursionLevel, String side) {
        if (numbers.length < 2) {
            System.out.println("Level: " + recursionLevel);
            return;
        }

        int halfLength = (numbers.length) / 2;
        int[] part1 = new int[halfLength];
        int[] part2 = new int[numbers.length - halfLength];

        System.arraycopy(numbers, 0, part1, 0, part1.length);
        System.arraycopy(numbers, halfLength, part2, 0, part2.length);

        mergeSort(part1, recursionLevel + 1, "left");
        mergeSort(part2, recursionLevel + 1, "right");

        System.out.println("Level: " + recursionLevel);
        System.out.println("part 1: " + Arrays.toString(part1));
        System.out.println("part 2: " + Arrays.toString(part2));
        mergeParts(numbers, part1, part2);
        System.out.println("Merged: " + Arrays.toString(numbers));
    }

    private static void mergeParts(int[] numbers, int[] part1, int[] part2) {
        int index, part1Index, part2Index;
        index = part1Index = part2Index = 0;

        while(part1Index < part1.length && part2Index < part2.length) {
            numbers[index++] = part1[part1Index] <= part2[part2Index] ?
                               part1[part1Index++] : part2[part2Index++];
        }

        while(part1Index < part1.length) numbers[index++] = part1[part1Index++];
        while(part2Index < part2.length) numbers[index++] = part2[part2Index++];
    }
}
