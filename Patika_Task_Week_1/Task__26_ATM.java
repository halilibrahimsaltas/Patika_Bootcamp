import java.util.Scanner;
public class Task__26_ATM {
    //ATM Uygulaması
    public static void main(String[] args) {

        String userName, password; // Kullanıcı bilgileri
        int right=3;// giriş hakkı
        int balance=1500;//bakiye
        int select=0;// menüde ki seçimler
        int price;// işlem yapılacak miktar
        Scanner input = new Scanner(System.in);
        while (right > 0) { //ıd ve şifre  loopu
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")) {////ıd ve şifre kontrol
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!"); // Menü loopu
                do {
                    System.out.println("1-Para yatırma\n" +  //Menü
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select= input.nextInt();
                switch (select){ //Menü seçeneklerine göre yapılan işlemler
                    case 1:
                        System.out.print("Para miktarı : ");
                        price = input.nextInt();
                        balance += price; //para yatırma
                        break;
                    case 2:
                        System.out.print("Para miktarı : ");
                        price = input.nextInt();
                        if (price > balance) { // bakiye yeterlimi sorgusu
                            System.out.println("Bakiye yetersiz.");
                        } else {
                            balance -= price; // para çekme
                        }
                        break;
                    case 3:
                        System.out.println("Bakiyeniz : " + balance);// bakiye gösterme
                        break;
                    case 4:
                        break;
                    default:
                        right--;
                        System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                        if (right == 0) {
                            System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                        } else {
                            System.out.println("Kalan Hakkınız : " + right);
                        }
                }
                }while (select != 4);
                System.out.println("Tekrar görüşmek üzere.");
                break;

            }
        }
    }
}




