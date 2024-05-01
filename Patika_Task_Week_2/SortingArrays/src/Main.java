import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Sorting Arrays

        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of array:"); //taking length of array
        number = input.nextInt();
        int[] list = new int[number];
        for (int i = 0; i < list.length; i++) { // loop for length of array
            System.out.println("Enter the " + i + ". value of array:");
            list[i] = input.nextInt();
        }
        Arrays.sort(list); //Sorting Arrays

        System.out.println("The Array:" + Arrays.toString(list));//output


    }
}