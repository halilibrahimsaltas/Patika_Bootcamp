public class Main {
    public static void main(String[] args) {
        Fighter ippo = new Fighter("İppo" , 15 , 100, 90, 40);
        Fighter volg = new Fighter("Volg" , 10 , 95, 100, 30);
        Match r = new Match(ippo,volg , 100 , 90);
        r.run();
    }
}