import java.util.Scanner;
public class Task__30_TersYildiz {
    //Ters Yıldız üçgen yapma
    public static void main(String[] args) {

        int t ;// looplar için değer
        int num ;

        Scanner input = new Scanner(System.in);
        num =input.nextInt();

        for(int i=num; i>=0;i--){// üçgenin alt kısmını oluşturan loop
            for(t=0;t<i;t++){
                System.out.print("*");//yıldız yazdırma
            }
            System.out.println(" ");//alt satıra inmek için
        }

    }
}
