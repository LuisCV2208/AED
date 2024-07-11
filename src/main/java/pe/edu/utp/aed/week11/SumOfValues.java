package pe.edu.utp.aed.week11;

public class SumOfValues {
    public static void main(String[] args) {

        double[] numbers = {1,2,3,4,5,6};
        System.out.println(sum(numbers));
    }

    public static double sum(double[] numbers){

        return sumaRecursiva(numbers, 0);
    }

    public static double sumaRecursiva(double[] numbers, int index){
        if(index == numbers.length - 1){
            return numbers[index];
        }
        return sumaRecursiva(numbers ,index + 1)+ numbers[index];
    }
}
