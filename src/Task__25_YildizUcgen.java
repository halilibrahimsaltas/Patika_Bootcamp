public class Task__25_YildizUcgen {
    // Yıldızlardan Üçgen yapma

    public static void main(String[] args) {

        int a=9;// Kullanılacak max yıldız sayısı
        int b;// boşluk sayısı için ara değer
        int k=1;// looplar için değer
        int t=1;// looplar için değer

        for(int i=1; i<=a;i+=2){// üçgenin üst kısmını oluşturan loop
            b= (a-i)/2;//boşluk sayısı hesaplama
            for(; k<=b; k++){
                System.out.print(" ");
            }
            k=1;
            for(;t<=i;t+=1 ){
                System.out.print("*");//yıldız yazdırma
            }
            t=1;
            System.out.println(" ");//alt satıra inmek için
        }
        for(int i=7; i>=0;i-=2){// üçgenin alt kısmını oluşturan loop
            b= (a-i)/2;//boşluk sayısı hesaplama
            for(; k<=b; k++){
                System.out.print(" ");
            }
            k=1;
            for(;t<=i;t++ ){
                System.out.print("*");//yıldız yazdırma
            }
            t=1;
            System.out.println(" ");//alt satıra inmek için
        }

    }
}
