import java.util.Scanner;

public class Task_5_Daire {
    public static void main(String[] args) {
        double r, a , alan;

        Scanner input = new Scanner(System.in);

        System.out.println("Sırasıyla yarıçap ve daire dilimi açısını giriniz :");
        r= input.nextDouble();
        a= input.nextDouble();
        if (a!=360) {
            a %= 360; // açı 360'dan büyük olması durumunda
        }

        alan = (3.14*(r*r)*a)/360;

        System.out.println("Daire diilimi alanı : " + alan);

    }
}
