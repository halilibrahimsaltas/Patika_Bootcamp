import java.util.Scanner;

public class Main {
    //Recursive Exponential
    static int power( int base, int  exponent) { // power function
        if(exponent==0){
            return 1;
        }else{
            int result=base*power(base,exponent-1);
            return  result;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Taban değeri giriniz :");
        int base = scan.nextInt();
        System.out.print("Üs değeri giriniz :");
        int exponent = scan.nextInt();
        int result = 1;
        System.out.println("Sonuç : " + power(base,exponent));//output

    }
}