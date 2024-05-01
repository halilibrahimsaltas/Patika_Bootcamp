import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] list = {56, 34, 1, 8, 101, -2, -33};

        int min = list[0];
        int max = list[0];
        int number;
        System.out.println("Enter a number:");
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
        int dif;
        int dif2;
        dif = number-list[0];



        for (int i : list) {
            if (i > number) {
                dif2=(number - i);
                if (Math.abs(dif) > Math.abs(dif2)) {
                    dif = dif2;
                    max = i;
                }
            }
        }
        dif = number-list[0];
        for (int i : list) {
            if (i < number) {
                dif2=(number - i);
                if (Math.abs(dif) > Math.abs(dif2)) {
                    dif = dif2;
                    min = i;
                }
            }
        }

        System.out.println("Minimum Değer " + min);
        System.out.println("Maximum Değer " + max);

    }
}