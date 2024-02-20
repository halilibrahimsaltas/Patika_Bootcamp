import java.util.Scanner;
public class Task__24_Harmonik {
    //Harmonik Seri Bulma
    public static void main(String[] args) {

        int number; // Girilen değer
        double sum=0.00;// harmonik seri değeri

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");//kullanıcıdan veri girişi
        number= input.nextInt();

        for (double i =1; i <=number; i++){//Harmonik seri için gerekli loop
            sum +=1/i;
        }

        System.out.println("Harmonik seri: " + sum);//çıktı
    }
}
