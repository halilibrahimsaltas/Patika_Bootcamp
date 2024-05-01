import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Transpose Matrix

        int[][] matrix = new int[2][3];
        int[][] transMatrix = new int[3][2];
        Scanner input = new Scanner(System.in);


        for (int i = 0; i < matrix.length; i++) { // Input matrix values
            System.out.println("Enter all values of " + i + " row :");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
                transMatrix[j][i] = matrix[i][j];
            }
        }
        // Print original matrix
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Print transpose matrix
        System.out.println("Transpose Matrix:");
        for (int i = 0; i < transMatrix.length; i++) {
            for (int j = 0; j < transMatrix[i].length; j++) {
                System.out.print(transMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}