import java.util.Scanner;
public class Task__19_KuvvetBulma {
    //Kat Hesaplama
    public static void main(String[] args) {

        int  number=0; // Kullanıcıdan alınacak değer

        Scanner input= new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");// Kullanıcıdan veri alıyoruz
        number= input.nextInt();

        for (int i =1;i<=number;i*=4){ // katları hesaplayan looplar
            System.out.println("4'ün Katları: " +i);//4 ün katları
        }
        for (int k =1;k<=number;k*=5){// katları hesaplayan looplar
            System.out.println("5'in Katları: " + k);// 5 in katları
        }
    }
}
