import java.util.Scanner;
public class Task__28__MinMax {
    //MİN MAX DEĞER BULMA
    public static void main(String[] args) {

        int numberCount;
        int i =0;

        Scanner input = new Scanner(System.in);

        System.out.println("Kaç tane sayı gireceksiniz:");//Kaç sayı girilecek değer alınıyor
        numberCount= input.nextInt();

        int [] numbers = new int[numberCount]; //Başlangıç için en az bir min ve max değeri alınıryor
        System.out.println((i + 1) + ". Sayıyı giriniz");
        numbers[i] = input.nextInt();
        int min =numbers[0]; //referans değer
        int max =numbers[0]; // referans değer

        for (i=1; i < numberCount; i++) {// Kullanıcı verilerini alan loop
            System.out.println((i + 1) + ". Sayıyı giriniz");
            numbers[i] = input.nextInt();
            if (numbers[i] < min) { // Min max değer yakalama koşulu
                min = numbers[i]; // min değer yakalama
            }
            if (numbers[i] > max) {
                max = numbers[i]; //  max değer yakalama
            }
        }
        System.out.println("Max değer: " + max);
        System.out.println("Min değer: " + min);
        }

    }
