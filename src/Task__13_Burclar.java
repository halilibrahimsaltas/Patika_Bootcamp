import java.util.Scanner;

public class Task__13_Burclar {
    public static void main(String[] args) {
        // Burc Bulma

        int month, day;
        String [] burc = {"Oğlak","Kova","Balık","Koç","Boğa","İkizler","Yengeç Aslan","Başak","Terazi","Akrep","Yay",};
        int [] songun= {21, 19, 20, 20, 21, 22, 22, 22, 22, 22, 21, 21};// Burcların ay içerisindeki son günleri

        Scanner input = new Scanner(System.in);

        System.out.print("Doğduğunuz Ay :");
        month = input.nextInt();

        System.out.print("Doğduğunuz Gün :");
        day = input.nextInt();


        for (int i = 0; i < burc.length; i++) {
            if ((month == i + 1 && day <= songun[i])) {//Koşulda Burcunda dahil doluğu aya ve güne girdiğini bakıyoruz
                System.out.println("Burcunuz: "+ burc[i]);
                break;
            }
            if ((month == i+1 && day >songun[i])){ //Burc dahil olduğu aya girip güne girmediği durumlar için
                System.out.println("Burcunuz: "+ burc[i+1]);
            }
        }
        if(month>12 || day >31){
            System.out.println("Geçersiz tarih girdiniz.");
        }


    }


}
