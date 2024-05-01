import java.util.Scanner;
public class Task__10_NotOrt {
    //Not Ortalama Hesaplama
    public static void main(String[] args) {

        double [] notlar = new double[5];//Verileri tuttuğumuz dizi
        double ortalama =0.0;
        int a =5;
        String[] dersler = {"Matematik", "Fizik", "Türkçe", "Kimya", "Muzik"};//Dersler

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) { // Not girişleri
            System.out.print( dersler[i] + " dersi notu: ");
            notlar[i] = input.nextDouble();
        }
        for (int i = 0; i < 5; i++) {//0-100 aralığında olmayan verilerin ortalama hesabında kullanılmaması
            if (notlar[i]<0 || notlar[i]>100){
                a-=1;
            }
            else {
                ortalama += notlar[i];
            }
        }
       if ((ortalama/a)<55){ //Sınıfı geçme koşulu
           System.out.println("Sınıfta Kaldınız!");
       }
       else {
           System.out.println("Sınıfı Geçtiniz.");
       }
       System.out.println("Ortalamanız :" + (ortalama/a));// Ortalama not
    }
}
