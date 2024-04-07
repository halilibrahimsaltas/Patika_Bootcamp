
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Try-Catch
        Scanner input = new Scanner(System.in);
       String [] array={"tomato","car","soccer","wrap","dungeon","solid","rescue","support","casual","unbelievable"};

       while(true) {// Try-Catch loop

           try {
               System.out.print("Enter a index between 0-9: ");
               int select = input.nextInt();
               System.out.println(array[select]);

           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("ArrayIndexOutOfBoundsException: Wrong index selection !!");
               System.out.println(e.getMessage());

           }

       }
    }
}