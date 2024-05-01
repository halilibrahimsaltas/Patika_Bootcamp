public class Task__31_AsalSayiBulma {
    //Asal Sayı Bulma
    public static void main(String[] args) {

        System.out.print("2");// 2 yi denklem dışında bıraktığımız için baştan ekliyoruz

        for (int i =2; i<=100; i++){ // asal sayı bulma loopu
            for(int j=2; j<=i*i;j++){
                if(i%j==0){ // Bölünmesi durumunda loopun devem etmesi
                    break;
                }else if (j == i - 1){// Sayının asal olup olmadığının kontrolü
                    System.out.print(" " + i);
                    break;
                }
            }
        }
    }
}
