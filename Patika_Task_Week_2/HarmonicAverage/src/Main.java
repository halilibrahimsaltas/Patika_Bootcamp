public class Main {
    public static void main(String[] args) {

            double[] numbers = {1, 2, 3, 4, 5};
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += 1/numbers[i];
            }



            System.out.println("Harmonic Average: "+ (sum / numbers.length));
    }
}

