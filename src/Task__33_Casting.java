import java.util.Scanner;
public class Task__33_Casting {
    // Tip dönüştürme
    public static void main(String[] args) {

        double double1 ; //Ondalıklı sayı
        int integer2; // Tam sayı

        Scanner input= new Scanner(System.in);

        //Kullanıcı veri girişi
        System.out.println("Ondalıklı bir sayı giriniz:");
        double1= input.nextDouble();
        System.out.println("Bir tam sayı giriniz:");
        integer2= input.nextInt();

        //Dönüşüm casting
        double double2 = integer2;
        int integer3 = (int) double1;

        //Çıktı
        System.out.println("İlk sayı: " + integer3);
        System.out.println("İkinci sayı: " + double2);

    }
}
