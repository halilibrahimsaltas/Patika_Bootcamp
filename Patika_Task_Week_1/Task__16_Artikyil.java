import java.util.Scanner;
public class Task__16_Artikyil {
     //Artık Yıl HEsaplama
    public static void main(String[] args) {

        int year ;

        Scanner input= new Scanner(System.in);

        System.out.println("Bir yıl giriniz:");
        year=input.nextInt();

        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    System.out.println(year + " Artık Yıldır.");
                }else{
                    System.out.println(year + " Artık Yıl Değildir.");
                }
            }else {
                System.out.println(year + " Artık Yıldır.");
            }
        }else {
            System.out.println(year + " Artık Yıl Değildir.");
        }
    }
}
