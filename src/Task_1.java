import  java.util.Scanner;
public class Task_1 {

    public static void main(String[] args) {
        //Not ortalama hesaplama
        int mat , fiz ,kim ,tr ,mz ,th ;

        Scanner inp = new Scanner(System.in);

        System.out.println("Matematik sınavı notunuzu giriniz :");
        mat =inp.nextInt();

        System.out.println("Fizik sınavı notunuzu giriniz :");
        fiz =inp.nextInt();

        System.out.println("Kimya sınavı notunuzu giriniz :");
        kim =inp.nextInt();

        System.out.println("Türkçe sınavı notunuzu giriniz :");
        tr =inp.nextInt();

        System.out.println("Tarih sınavı notunuzu giriniz :");
        th =inp.nextInt();

        System.out.println("Müzik sınavı notunuzu giriniz :");
        mz =inp.nextInt();

        double ort ;
        ort = mat + fiz + kim + tr + mz + th ;
        ort /= 6;
        //ort > 60 ? "Sınıfı Geçti." : "Sınıfta Kaldı!" ;

        System.out.println("Not ortalaman :" + ort);

        if (ort>60){
            System.out.println("Sınıfı Geçti.");
        }
        else {
            System.out.println("Sınıfta Kaldı!");
        }
    }
}
