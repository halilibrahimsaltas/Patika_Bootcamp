import java.util.Scanner;

public class Task_2_KDV {
    //KDV hesaplama
    public static void main(String[] args) {

        int t ;
        double kdv;

        Scanner input = new Scanner(System.in);


        System.out.println("Ürün tutarını giriniz:"); // ürün tutarı alınır
        t= input.nextInt();

        if (t<=1000){ // Koşulları tanımlama 1000'den büyük ise %8 değil ise %18
            kdv=t*0.18;
        }
        else{
            kdv=t*0.08;
        }

        System.out.println("KDV tutarı: " + kdv);
    }
}
