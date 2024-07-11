package pe.edu.utp.aed.week11;

public class BaseConversion {
    public static void main(String[] args) {

        int number = 255;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(toBase2(number));
    }

    // método recursivo
    private static String toBase2(int number) {
        if (number < 2) {
            return String.valueOf(number);
        }
        int modulus = number % 2;
        return toBase2(number / 2) + modulus;
    }
}
