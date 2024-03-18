import java.util.Scanner;
public class Task__33_Casting {
    // Tip dönüştürme
    public static void main(String[] args) {


        Scanner inp = new Scanner(System.in);

        // Kullanıcıdan tam sayı girişi iste

        System.out.print("Please enter an integer :  ");
        int a = inp.nextInt();

        // Kullanıcıdan ondalıklı sayı girişi iste

        System.out.print("Please enter a decimal :  ");
        double b = inp.nextDouble();

        // Tam sayıyı ondalıklı sayıya dönüştür

        double decimal_a = (double) a;

        // Ondalıklı sayıyı tam sayıya dönüştür

        int integer_b = (int) b;


        System.out.println("Integer input : " + a);
        System.out.println("Integer to decimal : " + decimal_a);
        System.out.println("Decimal input : " + b);
        System.out.println("Decimal to integer : " + integer_b);



    }
}