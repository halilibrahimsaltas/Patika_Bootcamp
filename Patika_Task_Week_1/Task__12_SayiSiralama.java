import java.util.Scanner;

public class Task__12_SayiSiralama {
    //Sayı Sıralama
    public static void main(String[] args) {

        int [] sayilar = new int[3];
        String [] num = {"a", "b", "c",};

        Scanner input = new Scanner(System.in);

        for (int i =0; i < 3; i++){
            System.out.println(num[i]+" Sayısını Giriniz");
            sayilar[i]=input.nextInt();
        }

        if ((sayilar[0]>sayilar[1]) && (sayilar[0]>sayilar[2]) ){
            if (sayilar[1]>sayilar[2]){
                System.out.println("a>b>c");
            }else {
                System.out.println("a>c>b");
            }
        } else if ((sayilar[1]>sayilar[0]) && (sayilar[1]>sayilar[2])) {
            if (sayilar[0]>sayilar[2]){
                System.out.println("b>a>c");
            }else {
                System.out.println("b>c>a");
            }
        }else {
            if (sayilar[0]>sayilar[1]){
                System.out.println("c>a>b");
            }else {
                System.out.println("c>b>a");
            }
        }
    }
}
