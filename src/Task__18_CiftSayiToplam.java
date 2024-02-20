import java.util.Scanner;
public class Task__18_CiftSayiToplam {
    //Tek sayı girilene kadar girilen tüm sayıların toplamını her defasında ekrana yazdırma programı
    public static void main(String[] args) {

        int a; //Kullanıcıdan alıcanacak sayı
        int sum =0;//toplam

        Scanner input = new Scanner(System.in);

        do { //Döngü limitleri bilinmediği için do-while tercih ettik
            System.out.println("Çift bir sayı giriniz:"); //Kullanıcıdan sayı alma
            a = input.nextInt();
            for (int i =0; i <= a; i++) {//Sayının 0 dan kendisine kadar olan sayıların taranması
                if (i % 4 == 0) {// çift ve 4'e  bölüm koşulunun kontrolü
                    sum += i;// toplamların kaydedilmesi
                }
                if (i == a) {//döngünün sonu
                    System.out.println("Toplam : " + sum);//çıktı
                    sum=0;// döngü her tamamlanışında sum üzerindeki değerin resetlenmesi
                }
            }
            }
            while (a % 2 == 0) ;// girilen sayı çift olduğu sürece döngünün devamı
        }
}
