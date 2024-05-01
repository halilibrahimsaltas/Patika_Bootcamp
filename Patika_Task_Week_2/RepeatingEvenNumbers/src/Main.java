public class Main {
    static  boolean isFind(int [] arr, int value){
        for(int  i: arr){
            if(i==value){
                return true;
            }
        }
        return  false;
    }
    public static void main(String[] args) {
        int [] list = {5,5,6,8,9,7,4,56,3,5,6,7,8,56,4,12,45};
        int [] duplicate= new int[8];
        int startIndex=0;
        for (int i=0; i<list.length; i++){
            for (int j=0; j<list.length; j++){
                if ((i!=j) && (list[i]==list[j])){
                    if (!isFind(duplicate, list[i])){
                        duplicate[startIndex++]=list[i];
                    }
                    break;
                }
            }
        }
        for ( int val : duplicate){
            if (val!=0 && val%2==0){
                System.out.println(val);
            }
        }
    }
}