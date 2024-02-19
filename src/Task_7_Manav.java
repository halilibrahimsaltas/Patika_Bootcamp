import java.util.Scanner;

public class Task_7_Manav {
    //Manav Kasa Hesaplama
    public static void main(String[] args) {

        double armut,elma,domates,muz,patlican ,tutar;

        Scanner input = new Scanner(System.in);

        System.out.print("Kaç kilo Armut alıyorsunuz :");
        armut = input.nextDouble();

        System.out.print("Kaç kilo Elma alıyorsunuz :");
        elma = input.nextDouble();

        System.out.print("Kaç kilo Domates alıyorsunuz :");
        domates = input.nextDouble();

        System.out.print("Kaç kilo Muz alıyorsunuz :");
        muz = input.nextDouble();

        System.out.println("Kaç kilo Patlican alıyorsunuz :");
        patlican = input.nextDouble();

        tutar = (armut*2.14)+(elma*3.67)+(domates*1.11)+(muz*0.95)+(patlican*5);

        System.out.println("Toplam tutar: " + tutar);



    }
}
