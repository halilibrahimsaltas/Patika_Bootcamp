import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Arrays Frequency
        int[] list = {5, 5, 6, 8, 9, 7, 4, 56, 3, 5, 6, 7, 8, 56, 4, 12, 45,45,12,5,8,96,3,7,8,5,5};
        int startIndex = 1;
        Arrays.sort(list);// Arrays sort

        for (int i = 0; i < (list.length - 1); i++) { //loop for array

            if (list[i] == list[i + 1]) {// counting clause
                startIndex++;

            } else if (startIndex != 1) {
                System.out.println("Value: " + list[i] + " Times: " + startIndex);
                startIndex = 1;
            }

        }

    }
}