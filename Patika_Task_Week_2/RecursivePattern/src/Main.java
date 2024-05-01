import java.util.Scanner;

public class Main {
    //Pattern of 5

    static void number (int inp) { //function
        if(inp<=0){
            System.out.print(inp+ " ");
            return;
        }
        System.out.print(inp+ " ");
        number(inp-5);
        System.out.print(inp+ " ");
    }


    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter a number: "); //İnput
        int inp=input.nextInt();
        number(inp);
    }
}