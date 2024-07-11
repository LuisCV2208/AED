package pe.edu.utp.aed.week04;

import java.util.Random;

public class RandomArray {
    private int CAPACITY = 100;
    private int[] arr1;
    private int[] arr2;

    public RandomArray() {
        arr1 = new int[CAPACITY];
        arr2 = new int[CAPACITY];
    }

    public void generateRandomArrays() {
        // Filling arr1 with random values
        fillArrayWithRandomValues(arr1, 500, 999);
        // Filling arr2 with random indexes
        fillArrayWithRandomIndexes(arr2, 0, arr2.length);
    }

    private void fillArrayWithRandomValues(int[] arr,
                                           int minValue,
                                           int maxValue) {
        maxValue++;
        Random randomGenerator = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomGenerator.nextInt(minValue, maxValue);
        }
    }

    // TODO: Improve performace
    private void fillArrayWithRandomIndexes(int[] arr, int minValue, int maxValue) {
        boolean[] generatedIndexes = new boolean[arr.length];
        int randomIndex, counter;

        Random randomGenerator = new Random();
        for (int i = 0; i < arr.length; i++) {
            //counter = 0;
            do {
                randomIndex = randomGenerator.nextInt(minValue, maxValue);
                //counter++;
            } while (generatedIndexes[randomIndex]);
            //System.out.printf("%d - %d\n", i, counter);
            generatedIndexes[randomIndex] = true;
            arr[i] = randomIndex;
        }
    }

    public String getValuesArrayAsString() {
        return getArrayAsString(arr1);
    }

    public String getIndexesArrayAsString() {
        return getArrayAsString(arr2);
    }

    private String getArrayAsString(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i % 25 == 0) {
                sb.append('\n');
            }
            sb.append(String.format("%3d ", arr[i]));
        }

        return sb.toString();
    }

    public String getSortedArrayAsString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            if (i > 0 && i % 25 == 0) {
                sb.append('\n');
            }
            sb.append(String.format("%3d ", arr1[arr2[i]]));
        }

        return sb.toString();
    }

}
