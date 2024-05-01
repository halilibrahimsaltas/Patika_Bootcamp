import java.util.Scanner;
public class Task__27_EbobEkok {
    //EBOB VE EKOK BULMA
    public static void main(String[] args) {

        int n1 , n2;//Kullanıcıdan aınan değerler
        int ebob=1;
        int ekok;

        Scanner input = new Scanner(System.in);

        System.out.println("n1 ve n2 sayılarını giriniz:");//Kullanıcıdan aınan değerler
        n1= input.nextInt();
        n2= input.nextInt();

        int i;
        if (n1>=n2){// değerlerin hangisinin daha büyük olduğunu kontrol ediyoruz
            i=n1;
        }else{
            i=n2;
        }
        while(i>=1) { // EBOB kontrolü için loop
            if (n1 % i == 0 && n2 % i == 0) {
                ebob= i;
                break;
            }
            i--;
        }
        ekok=(n1*n2)/ebob; // EKOK bulmak için gerekli denklem
        System.out.println("Ebob :" + ebob); // Çıktı
        System.out.println("Ekok :" + ekok);// Çıktı
    }
}
