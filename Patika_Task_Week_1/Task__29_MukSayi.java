import java.util.Scanner;

public class Task__29_MukSayi {
    //Mükemmel Sayı Bulma
    public static void main(String[] args) {

        int a ;//Kullanıcıdan istenecek sayı
        int sum =0;

        Scanner input= new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");
        a= input.nextInt();

        for(int i =1; i<a; i++){//kalansız bölen sayıları bulma loopu
            if(a%i==0){
                sum +=i;
            }
        }
        if (sum==a){ // Mükemmel sayı koşulu
            System.out.println(a+" Sayısı Mükemmel Sayıdır.");// Çıktı
        }else{
            System.out.println(a+" Sayısı Mükemmel Sayı Değildir.");// Çıktı
        }
    }
}
