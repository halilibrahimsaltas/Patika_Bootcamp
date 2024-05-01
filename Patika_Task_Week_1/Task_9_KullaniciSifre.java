import java.util.Scanner;
public class Task_9_KullaniciSifre {
    //Kullanıcı Şifre değiştirme
    public static void main(String[] args) {
        int a; //Şifre değiştirme talebi için
        String userName , password , newPassword , b;

        Scanner input = new Scanner(System.in);

        System.out.println("Kullanıcı adınız :"); //Kullanıc bilgilerini alınıyor
        userName= input.nextLine();
        System.out.println("Şifreniz :");
        password= input.nextLine();

        if (userName.equals("patika") && password.equals("java101")){
            System.out.println("Giriş Yaptınız!");
        }
        else{
            System.out.println("Şifreniz yanlış veya hatalı\nŞifrenizi sıfırlamak istiyorsanız lüften 1'e basınız.");
            //Şifre değiştirip değiştirmemek istediği soruluyor
            a = input.nextInt();
            b = input.nextLine();// a inputunu yakaladıktan sonra if koşulunu atlamaması için eklendi.
            if (a ==1){
                System.out.println("Lütfen  yeni şifrenizi giriniz:");
                newPassword= input.nextLine();
                if (newPassword.equals("java101")){
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                }
                else {
                    System.out.println("Şifre oluşturuldu");
                }
            }
            else {
                System.out.println("Şifreniz değiştirilmemiştir.");// Şifre değiştirmek istememesi halinde
            }
        }


    }
}
