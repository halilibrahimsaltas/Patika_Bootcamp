import java.util.Scanner;
public class Main {
    //Prime number Founder
    static  boolean isPrime (int number){ //func for prime number
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number*number; i++) {//loop for prime number
            if (number % i == 0) {
                return false;
            }
        }
        return isPrime(number);
    }
    public static void main(String[] args) {
        int number ;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");// İnput
        number=input.nextInt();

        if (number==2 || isPrime(number)) { // 2 is a prime number so we add this part number==2 ||
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

    }
}