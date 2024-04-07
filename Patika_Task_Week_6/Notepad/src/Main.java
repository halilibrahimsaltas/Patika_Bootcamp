import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Path myFile = Paths.get("myFile.txt");
        boolean exists = Files.exists(myFile);

        if (exists) {
            try (FileWriter fileWriter = new FileWriter("myFile.txt", true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                System.out.println("Enter a word :");
                String word = input.nextLine();

                printWriter.print(word+"\t");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"))) {
                System.out.println("Enter a word :");
                String word = input.nextLine();
                bw.write(word); // adding word
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))) {
            String line;
            System.out.println("Notepad :");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
