import java.util.Scanner;

public class Task_3_Alan {
    public static void main(String[] args) {

        int a , b , c ;
        double alan , u;

        Scanner input = new Scanner(System.in);

        System.out.println("a,b,c kenar uzunluklarını sırasıyla giriniz :");
        a= input.nextInt();
        b= input.nextInt();
        c= input.nextInt();

        u=a+b+c;
        u /=2;

        alan = u*(u-a)*(u-b)*(u-c);
        alan = Math.sqrt(alan); // Kökünü aldık

        System.out.println("Üçgenin alanı :" + alan);




    }
}
