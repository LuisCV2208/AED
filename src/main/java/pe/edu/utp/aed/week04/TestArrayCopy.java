package pe.edu.utp.aed.week04;

import java.util.Arrays;

public class TestArrayCopy {
    public static void main(String[] args) {
        Integer[] arr1 = {12, 3, 45, 63, 7, 56, 11, 23};
        Integer[] arr2 = new Integer[arr1.length];

        //ArrayCopy.arrayCopy(arr1, 0,
        //        arr2, 0, arr1.length);
        /*ArrayCopy.arrayCopy(arr1, 4,
                arr2, 0, 3);*/
        ArrayCopy.arrayCopy(arr1, 4,
                arr2, 3, 3);
        System.out.println(Arrays.toString(arr2));
    }
}
