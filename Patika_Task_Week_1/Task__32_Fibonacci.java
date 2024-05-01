import java.util.Scanner;
public class Task__32_Fibonacci {
    //Fibonacci Sayısı Bulma
    public static void main(String[] args) {

        int number; // İstenilen değer

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz:"); // veri girişi
        number= input.nextInt();
        int [] fib = new int[number+1];//Dizilerde 0. adımdan başlandığı için +1
        fib[0]=0;//İstisna başlangıç değerleri
        fib[1]=1;//

        System.out.print(fib[0] + " ");
        if (number > 0) {//Sıfırdan büyük olması kontrolü
            System.out.print(fib[1] + " ");
        for(int i=2 ; i<number;i++){//Fibonacci sayısı için gerekli loop
                fib[i] = fib[i - 1] + fib[i - 2];
                System.out.print(" " + fib[i]); // Yazdırma çıktı
        }
        }
    }
}
