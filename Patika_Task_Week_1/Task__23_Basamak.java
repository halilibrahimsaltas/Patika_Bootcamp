import java.util.Scanner;

public class Task__23_Basamak {
    //Basamak toplama
    public static void main(String[] args) {

        int number; //Kullanıcıdan alınacak değerler
        int count = 0;//Basamak sayısı
        int sum1 = 0;//toplam
        int a;//basamak sayısı bulurken kullanılacak ara değer
        int k;//ondalıkları  bulurken kullanılacak ara değer

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");//Kullanıcıdan değer alma
        number = input.nextInt();

        a = number;//basamak sayısı için kullanmak üzere değer atanası

        while (a != 0) {//Basamak sayısı bulma
            a /= 10;
            count++;
        }
        for(int i =1; i<=count;i++){//her basamaktaki sayıyı bulma
            k = number%10;
            number/=10;
            sum1 +=k;//değerlerin toplamı
        }
        System.out.println("Sonuç: " + sum1);//sonuç
    }
}