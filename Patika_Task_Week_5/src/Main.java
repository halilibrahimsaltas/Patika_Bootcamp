import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Metin girin:");
        String text = scanner.nextLine().toLowerCase();

        String[] words = text.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }
        System.out.println("En çok geçen kelime: " + mostFrequentWord);
        System.out.println("Bu kelime metinde " + maxCount + " kez geçiyor.");
    }
}