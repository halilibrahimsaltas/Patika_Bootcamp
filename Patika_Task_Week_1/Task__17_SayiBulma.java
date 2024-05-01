import java.util.Scanner;
public class Task__17_SayiBulma {
     //3 ve 4'E bölünen sayıların ortalaması
    public static void main(String[] args) {

        int number, adet =0;
        double ort=0.0 ; //ortalama için double kullanıldı

        Scanner input= new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");
        number=input.nextInt();

        for (int i=1; i<=number;i++){ //sayıların kontrolü için gerekli döngü
            if (i%3==0 && i%4==0){ // koşulu sağlanların kontrolü
                ort +=i; // toplam
                adet++; // ortlama için gerekli tutulması gereken sayı adedi
            }
        }
        if(adet==0){ // ortalama hesabında paydanın 0 olup denklemi tanımsız yapmaması için
            adet=1;
        }
        ort =ort/adet; // Ortalama hesabı
        System.out.println("Ortalama değer: " + ort );
    }
}
