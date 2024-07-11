package pe.edu.utp.aed.week11;

public class Palindromos {
    public static void main(String[] args) {
        System.out.println(Palindromo("reconocer"));
        System.out.println(Palindromo("universidad"));
    }

    public static boolean Palindromo(String texto) {
        return procesarPalindromo(texto, 0, texto.length() - 1);
    }

    private static boolean procesarPalindromo(
            String texto, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        } else {
            if (texto.charAt(inicio) != texto.charAt(fin)) {
                return false;
            } else {
                return procesarPalindromo(texto, inicio + 1, fin - 1);
            }
        }
    }

}
