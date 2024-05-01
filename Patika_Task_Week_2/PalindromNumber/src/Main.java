import java.util.Scanner;
public class Main {
    //Palindrom Number

    static boolean isPalindrom(int number){  // Check point for Palindrom Number
        int temp=number ,reverseNumber=0, lastNumber;
        while (temp!=0){
            lastNumber=temp %10;
            reverseNumber=(reverseNumber*10)+ lastNumber;
            temp /=10;
        }
        if (number==reverseNumber)
            return  true;
        else
            return false;
    }
    public static void main(String[] args) {

        int number ; //İnput value
        Scanner input= new Scanner(System.in);
        System.out.println("Enter a number :");//User enter a number
        number= input.nextInt();
        System.out.println(isPalindrom(number) ? "The number is a Palindrom number": "The number is not a Palindrom number");//Output

    }
}