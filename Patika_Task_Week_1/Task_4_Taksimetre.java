import java.util.Scanner;

public class Task_4_Taksimetre {
    //Taksimetre Hesaplama
    public static void main(String[] args) {

        double a, b ;

        Scanner input = new Scanner(System.in);

        System.out.println("Km giriniz :");
        a=input.nextDouble();

        b= a*2.2 +10 ;



        if (b<=20){

            System.out.println("Borcunuz : 20 TL");
        }
        else{
            System.out.println("Borcunuz :" + b);
        }
    }
}
