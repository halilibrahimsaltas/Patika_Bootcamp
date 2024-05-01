import java.util.Scanner;
public class Task__20_Faktoriyel {
    //N nin R li kombinasyonu
    public static void main(String[] args) {

        int n , r; //Kullanıcıdan aldığımız değerler
        int t, c; //  t=(n-r) ilerde faktöriyelini alacağız C ise  c= n! / (r! * (n-r)!)
        int nFac=1;//n!
        int rFac=1;//r!
        int neksiRFac=1;// (n-r)!

        Scanner input = new Scanner(System.in);

        System.out.println("Sırasıyla n ve r değerlerini giriniz: ");//Kullanıcıdan değerleri alıyoruz
        n= input.nextInt();
        r= input.nextInt();

        t=(n-r); //t ye atamasını yapıyoruz (n-r)! için kullanacağız

        for (int i =1; i<=n;i++){ //n! hesaplama
            nFac =nFac*i;
        }
        for (int k =1; k<=r;k++){//r! hesaplama
            rFac= rFac*k;
        }
        for (int m =1; m<=t;m++){//(n-r)! hesaplama
            neksiRFac= neksiRFac*m;
        }

        c=nFac/(rFac*neksiRFac);//c= n! / (r! * (n-r)!) Kombinasyon formülü
        System.out.println("n'nin r'li kombinasyonu : " + c); // Değer gösterme
    }
}
