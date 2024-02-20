import java.util.Scanner;

public class Task__22_Armstrong {
    public static void main(String[] args) {

        int number, sum=1;
        int count=0;
        int sum1=0;
        int a ;
        int k;

        Scanner input =new Scanner(System.in);

        System.out.println("Bir sayı giriniz:");
        number= input.nextInt();

        a=number;

        while(a!=0){
            a/=10;
            count++;
        }

        for(int i =1; i<=count;i++){
            k = number%10;
            number/=10;
            int m=1;
            for(;m<=i; m++){ // İşleme gerçekleştiren loop
                sum *=k;
            }
            sum1 +=sum;
            sum=1;
        }

        System.out.println("Sonuç: " + sum1);
    }
}
