import java.sql.*;
import java.util.Scanner;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/company";

    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static boolean tap =false ;

    public static boolean PowersofTwo(int num) {
            for (int i = 1; Math.pow(2, i) <= num; i++) {
                if (num % Math.pow(2, i) == 0) {
                    tap = true;
                    break;
                }
            }
            return tap;

    }
    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PowersofTwo(s.nextInt()));

    }

}