import java.util.Scanner;

public class Task__11_HavaDurumu {
    //Etkinlik -Hava Durumu İlişkisi
    public static void main(String[] args) {

        double heat;

        Scanner input = new Scanner(System.in);

        System.out.println("Sıcaklığı giriniz: ");// Sıcaklık değeri alınır
        heat = input.nextDouble();

        if (heat<5){
            System.out.println("Kayak yapabilirsiniz.");
        } else if (heat<15 && heat>10) { //kesişen küme için eklendi.
            System.out.println("Pikniğe veya sinemaya gidebilirsiniz.");
        } else if (heat<25) {
            System.out.println("Pikniğe gidebilirsiniz.");
        }else{
            System.out.println("Yüzmeye gidebilirsiniz.");
        }
    }
}
