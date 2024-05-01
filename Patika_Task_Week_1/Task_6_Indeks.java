import java.util.Scanner;

public class Task_6_Indeks {
    //Vücut  Kitle Endeksi Hesaplama

    public static void main(String[] args) {

        double k , b, i ;

        Scanner input = new Scanner(System.in);

        System.out.println("Sırasıyla boyunuzu ve kilonuzu giriniz :");
        b= input.nextDouble();
        k = input.nextDouble();


        i= k/(b*b);
        System.out.println("Boyunuz :" + b);
        System.out.println("Kilonuz :" + k);
        System.out.println("Vücut Kitle Endeksiniz :" + i);



    }
}
