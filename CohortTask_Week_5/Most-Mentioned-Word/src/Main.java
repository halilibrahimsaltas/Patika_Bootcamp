import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Most Mentioned Word in a text
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = input.nextLine();
        int times=1;
        String[] parts = text.split(" "); //Split and add in array
        for(String part: parts){  // Counting
            if (words.containsKey(part)) {
                times = words.get(part);
                words.put(part, times + 1);
            } else {
                words.put(part, 1);
            }
        }
        String mostMentioned = null;
        int maxCount = 1;
        for (String word : words.keySet()) { // Search loop
            int count = words.get(word);
            if (count > maxCount) {
                maxCount = count;
                mostMentioned = word;
            }
        }
        System.out.println("Most Mentioned word is : " + mostMentioned + " \nTimes : " + maxCount);

    }
}