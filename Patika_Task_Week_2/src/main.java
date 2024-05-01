import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        int line=0;
        int sum=0;
        int n = input.nextInt();
        int[] list = new int[n];
        for (int p = 0; p < n; p++) {
            int t = input.nextInt();
            list[p] = t;
        }

        for (int i=0; i<list.length;i++){
            sum=0;
            for(int j=i;j< list.length;j++){
                sum+=list[j];
                if(sum<0){
                    line++;

                }else if (j== (list.length-1)){
                    sum =0;
                }

            }
        }
        System.out.println(line);

    }
}