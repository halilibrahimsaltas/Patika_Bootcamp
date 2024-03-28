import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Create file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))){
            bw.write("5\n10\n20\n12\n33"); // adding numbers
        }catch (IOException  e){
            e.printStackTrace();
        }
        //Read file
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))){
            String line;
            int sum = 0;
            while((line=br.readLine()) != null){
                sum+=Integer.parseInt(line); // calculating sum
            }
            System.out.println(sum); // print sum
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}