import java.util.Scanner;
public class Task_8_HMakinesi {
    //Hesap Makinesi
    public static void main(String[] args) {

        double a , b; // bölme işlemlerinde ondalıklı bölümler için kullanıldı
        int islem;
        Scanner input = new Scanner(System.in);

        System.out.println("Sırasıyla a ve b değerlerini giriniz :");//Kullancıdan veri alımı
        a= input.nextDouble();
        b= input.nextDouble();

        System.out.println("1-Toplama\n2-Çıkarma\n3-Çarpma\n4-Bölme");// İşlem tercihi
        System.out.println("Seçiminiz :");
        islem = input.nextInt();

        switch (islem){ //İşlem bloğu
            case 1:
                System.out.println("Toplam " + (a+b));
                break;
            case 2:
                System.out.println("Çıkarma " + (a-b));
                break;
            case 3:
                System.out.println("Çarpım " + (a*b));
                break;
            case 4:
                System.out.println("Bölüm " + (a/b));
                break;
            default:
                System.out.println("Geçersiz İşlem!");
        }
    }
}
