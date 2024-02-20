import java.util.Scanner;
public class Task__15_CinZodyag {
    //Çin Zodyağı Burcu
    public static void main(String[] args) {

        int year, a;

        String [] zodyag = {"Maymun","Horoz","Köpek","Domuz","Fare","Öküz","Kaplan","Tavşan","Ejderha","Yılan","At","Koyun"};

        Scanner input =new Scanner(System.in);

        System.out.println("Doğum yılınızı giriniz:");
        year= input.nextInt();

        a=year%12;

        for (int i =0; i <= zodyag.length; i++){
            if(a==i){
                System.out.println("Çin Zodyağı Burcunuz :" + zodyag[i]);
            }
        }
    }
}
