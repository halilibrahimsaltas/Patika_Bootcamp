import  java.util.Scanner;
public class Main {
//Advenced Calculator
    static void plus() { // plus operation
        Scanner scan = new Scanner(System.in);
        int number, result = 0, i = 1;
        while (true) {
            System.out.print(i++ + ". sayı :"); //Funciton
            number = scan.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Sonuç : " + result); //Output
    }

    static void minus() {// minus operation
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz :");
        int counter = scan.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) { //Minus Function
            System.out.print(i + ". sayı :");
            number = scan.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }

        System.out.println("Sonuç : " + result);//output
    }

    static void times() { // Multiplication Function
        Scanner scan = new Scanner(System.in);
        int number, result = 1, i = 1;

        while (true) {  //  Multiplication Function loop
            System.out.print(i++ + ". sayı :");
            number = scan.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }

        System.out.println("Sonuç : " + result);//output
    }

    static void divided() { //divide function
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz :");
        int counter = scan.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {  //divide function loop
            System.out.print(i + ". sayı :");
            number = scan.nextDouble();
            if (i != 1 && number == 0) {
                System.out.println("Böleni 0 giremezsiniz."); // Error catch
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result /= number;
        }

        System.out.println("Sonuç : " + result);//output
    }

    static void power() { // power function
        Scanner scan = new Scanner(System.in);
        System.out.print("Taban değeri giriniz :");
        int base = scan.nextInt();
        System.out.print("Üs değeri giriniz :");
        int exponent = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) { //power function loop
            result *= base;
        }

        System.out.println("Sonuç : " + result);//output
    }

    static void factorial() { //factorial function
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) { // factorial loop
            result *= i;
        }

        System.out.println("Sonuç : " + result);//output
    }
    static void mod() { //mode function
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        System.out.print("Mod giriniz :");
        int m = scan.nextInt();
        int result = 0;

        if (0 < n && 0 <m ) { //mod
            result = n%m;
        }

        System.out.println("Sonuç : " + result);//output
    }
    static void rectangle() { //rectangle function
        Scanner scan = new Scanner(System.in);
        int p ;
        System.out.println("1-Alan Hesabı\n" + "2-Çevre Uzunlığu Hesabı :\n");
        p = scan.nextInt();
        if (p != 1 && p != 2) {
            System.out.println("Hatalı işlem yaptınız.");
            return;
        }
        System.out.println("İlk Kenar uzunluğu giriniz :");
        int n = scan.nextInt();
        System.out.print("İkinci Kenar uzunluğu giriniz :");
        int m = scan.nextInt();
        int result = 0;
        if (p == 1) {
            if (0 < n && 0 < m) {
                result = n * m;
            }
        } else if (p==2) {
            if (0 < n && 0 < m) {
                result = 2 * (n + m);
            }

        }
        System.out.println("Sonuç : " + result);//output
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select;
        String menu = "1- Toplama İşlemi\n"  //Calculator menu
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Faktoriyel Hesaplama\n"
                + "7- Mod Alma\n"
                + "8- Dikdörtgen Alan ve Çevre Hesabı\n"
                + "0- Çıkış Yap";

        do {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz :"); //Calculator menu
            select = scan.nextInt();
            switch (select) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    mod();
                    break;
                case 8:
                    rectangle();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        } while (select != 0);


    }
}