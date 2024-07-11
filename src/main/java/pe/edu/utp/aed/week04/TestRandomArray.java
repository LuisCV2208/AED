package pe.edu.utp.aed.week04;

public class TestRandomArray {
    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray();
        randomArray.generateRandomArrays();

        System.out.println(randomArray.getValuesArrayAsString());
        System.out.println();
        System.out.println(randomArray.getIndexesArrayAsString());
        System.out.println();
        System.out.println(randomArray.getSortedArrayAsString());
    }
}
