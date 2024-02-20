import java.util.Scanner;
public class Task__21_UsluSayi {
    //Üslü Sayı Hesaplayan Program

    public static void main(String[] args) {

        int number, uslu ; // Kullanıcaıdan alınacak değerler
        int sum =1; // Üslü sayının değeri

        Scanner input = new Scanner(System.in);

        System.out.println("Üssü alınacak sayı: ");//"Üssü alınacak sayı
        number=input.nextInt();
        System.out.println("Üs  olacak sayı: ");//"Üst
        uslu=input.nextInt();

        for(int i=1; i<=uslu; i++){ // İşleme gerçekleştiren loop
            sum *=number;
        }
        System.out.println("Sonuc: " + sum);// çıktı

    }
}
