
import java.util.*;

public class Main {
    static TreeMap<String, String> brands = new TreeMap<>(new OrderBrands());
    static TreeMap<Integer, MobilePhone> mobilePhone = new TreeMap<>(new OrderPro());
    static TreeMap<Integer, Notebook> noteBook = new TreeMap<>(new OrderPro());
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        // PatikaStore  fundamentals
        brands.put("SAM", "Samsung");
        brands.put("LEN", "Lenovo");
        brands.put("APP", "Apple");
        brands.put("HUA", "Huawei");
        brands.put("CAS", "Casper");
        brands.put("ASU", "Asus");
        brands.put("HP", "HP");
        brands.put("XİA", "Xiaomi");
        brands.put("MON", "Monster");

        MobilePhone samsungA51 = new MobilePhone("SAMSUNG GALAXY A51 ", brands.get("SAM"), 3199, 0, 50, 128, 4000, 6, 6.5, "Black");
        MobilePhone iPhone11 = new MobilePhone("iPhone 11 64 GB ", brands.get("APP"), 7379, 0, 20, 64, 3046, 6, 6.1, "Blue");
        MobilePhone redMi10Pro = new MobilePhone("Redmi Note 10 Pro 8GB ", brands.get("XİA"), 4012, 0, 200, 128, 400, 12, 6.5, "White");

        Notebook mateBook14 = new Notebook("HUAWEI Matebook 14", brands.get("HUA"), 7000, 0, 10, 16, 512, 14);
        Notebook v14Igl = new Notebook("LENOVO V14 IGL", brands.get("LEN"), 3699, 0, 45, 8, 1024, 14);
        Notebook tufGaming = new Notebook("ASUS Tuf Gaming", brands.get("ASU"), 8199, 0, 15, 32, 2048, 15.6);
        mobilePhone.put(1, samsungA51);
        mobilePhone.put(2, iPhone11);
        mobilePhone.put(3, redMi10Pro);
        noteBook.put(1, mateBook14);
        noteBook.put(2, v14Igl);
        noteBook.put(3, tufGaming);

        //Menu loop
        boolean menu =true;
        while (menu) {
            System.out.println("##########################################");
            System.out.println("Welcome to PatikaStore Manager System  !");
            System.out.println("1-Notebooks Options");
            System.out.println("2-Mobile phones Options");
            System.out.println("3-Brands list ");
            System.out.println("4-Quit");
            System.out.println("##########################################");
            System.out.print("Your order: ");
            int select = input.nextInt();
            System.out.println();
            switch (select) {
                case 1://
                    System.out.println("##########################################");
                    System.out.println("Notebooks Options");
                    System.out.println("1-List of Notebooks");
                    System.out.println("2-Add a Notebook");
                    System.out.println("3-Remove a Notebook");
                    System.out.println("4-Quit");
                    System.out.println("##########################################");
                    System.out.print("Your order: ");
                    int select1=input.nextInt();
                    System.out.println();
                    switch (select1){
                        case 1:
                            printNotebooks();
                            break;
                        case 2:
                            setNoteBook();
                            break;
                        case 3:
                            removeNotebook();
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("##########################################");
                    System.out.println("Mobile phones Options");
                    System.out.println("1-List of Mobile phones");
                    System.out.println("2-Add a Mobile phone");
                    System.out.println("3-Remove a Mobile phone");
                    System.out.println("4-Quit");
                    System.out.println("##########################################");
                    System.out.print("Your order: ");
                    int select2=input.nextInt();
                    System.out.println();
                    switch (select2){
                        case 1:
                            printMobilePhone();
                            break;
                        case 2:
                            setMobilePhone();
                            break;
                        case 3:
                            removeMobilePhone();
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("##########################################");
                    System.out.println("Brand Options");
                    System.out.println("1-List of Brands");
                    System.out.println("2-Add a Brand");
                    System.out.println("3-Quit");
                    System.out.println("##########################################");
                    System.out.print("Your order: ");
                    int select3=input.nextInt();
                    System.out.println();
                    switch (select3){
                        case 1:
                            printBrands();
                            break;
                        case 2:
                            setBrands();
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    menu=false;
                    break;
                default:
            }

        }
    }

    static void printBrands() { // print brands
        for (String br : brands.values()) {
            System.out.println(br);
        }
    }

    static void setBrands() { // brand add
        input.nextLine();
        System.out.println("Enter the brand key(HP,ASU,APP,vs): ");
        String key = input.nextLine();
        System.out.println("Enter the name: ");
        String brand = input.nextLine();
        brands.put(key, brand);
    }

    static void printNotebooks() { // print notebooks
        System.out.println("\t###### NOTEBOOKS LİST #######\n");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-10s | %-10s | %-8s | %-8s | %-5s |%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM");
        System.out.println("------------------------------------------------------------------------------------------------");
        int i = 1;
        for (Notebook jr : noteBook.values()) {
            System.out.printf("| %-3s | %-30s | %-10s | %-10s | %-8s | %-8s | %-5s |%n",
                    i,
                    jr.getName(),
                    jr.getPrice(),
                    jr.getBrand(),
                    jr.getStorage(),
                    jr.getScreenSize(),
                    jr.getRam());
            i++;
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    static void printMobilePhone(){// print Mobile phone
        System.out.println(" \t###### MOBİLE PHONE LİST #######\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-10s | %-10s | %-8s | %-8s | %-8s | %-8s | %-5s|%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen","Battery", "RAM","Colour");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        int l = 1;
        for(MobilePhone mp : mobilePhone.values()){
            System.out.printf("| %-3s | %-30s | %-10s | %-10s | %-8s | %-8s | %-8s | %-8s | %-5s |%n",
                    l,
                    mp.getName(),
                    mp.getPrice(),
                    mp.getBrand(),
                    mp.getMemory(),
                    mp.getScreenSize(),
                    mp.getBatteryPower(),
                    mp.getRam(),
                    mp.getColour());
            l++;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

    }
    static void setNoteBook(){  // add notebook
        input.nextLine();
        System.out.println("Enter the brand key(HP,ASU,APP,vs): ");
        String key = input.nextLine();
        System.out.println("Enter the name: ");
        String brand = input.nextLine();
        brands.put(key, brand);
        System.out.println("Enter the Notebook model name: ");
        String addModel=input.nextLine();
        System.out.println("Enter the Notebook price: ");
        double price= input.nextDouble();
        System.out.println("Enter the Notebook capacity of storage :");
        int storage=input.nextInt();
        System.out.println("Enter the Notebook screen size:  ");
        double screenSize= input.nextDouble();
        System.out.println("Enter the discount rate: ");
        double discountRate= input.nextDouble();
        System.out.println("Enter the Notebook RAM: ");
        int ram= input.nextInt();
        System.out.println("Enter the Notebook stock: ");
        int stock= input.nextInt();
        Notebook addMode= new Notebook(addModel,brand,price,discountRate,stock,ram,storage,screenSize);
        noteBook.put(noteBook.lastKey()+1,addMode);
        System.out.println(addModel+" Notebook was added.");
        printNotebooks();

    }

    static void setMobilePhone(){ // add mobile phone
        input.nextLine();
        System.out.println("Enter the brand key(HP,ASU,APP,vs): ");
        String key = input.nextLine();
        System.out.println("Enter the name: ");
        String brand = input.nextLine();
        brands.put(key, brand);
        System.out.println("Enter the Mobile Phone model name: ");
        String addModel=input.nextLine();
        System.out.println("Enter the Mobile Phone price: ");
        double price= input.nextDouble();
        System.out.println("Enter the Mobile Phone memory :");
        int storage=input.nextInt();
        System.out.println("Enter the Mobile Phone screen size:  ");
        double screenSize= input.nextDouble();
        System.out.println("Enter the discount rate: ");
        double discountRate= input.nextDouble();
        System.out.println("Enter the Mobile Phone RAM: ");
        int ram= input.nextInt();
        System.out.println("Enter the Mobile Phone battery power: ");
        int batteryPower= input.nextInt();
        System.out.println("Enter the Mobile Phone colour: ");
        String colour =input.nextLine();
        System.out.println("Enter the Mobile Phone stock: ");
        int stock= input.nextInt();
        MobilePhone addMode = new MobilePhone(addModel,brand,price,discountRate,stock,storage,batteryPower,ram,screenSize,colour);
        mobilePhone.put(mobilePhone.lastKey()+1,addMode);
        System.out.println(addModel+ " Mobile Phone was added.");
        printMobilePhone();
    }

    static void removeMobilePhone(){ // remove mobile phone
        printMobilePhone();
        System.out.println("Enter the ID of mobile phone: ");
        int id = input.nextInt();
        mobilePhone.remove(id);
        printMobilePhone();
    }

    static void removeNotebook(){ // remove notebook
        printNotebooks();
        System.out.println("Enter the ID of Notebook: ");
        int id= input.nextInt();
        noteBook.remove(id);
        printNotebooks();
    }

}
class OrderPro implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

class Products {

    private  String name, brand;
    private double price,discountRate,stock;



    public Products(String name, String brand, double price, double discountRate, int stock) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
class Notebook extends Products{

    private int ram, storage;
    private double screenSize;

    public Notebook(String name, String brand, double price, double discountRate, int stock, int ram, int storage, double screenSize) {
        super(name, brand, price, discountRate, stock);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
class OrderBrands implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
class MobilePhone extends Products {

    private  int memory, batteryPower, ram;
    private  double screenSize;

    private  String colour;

    public MobilePhone(String name, String brand, double price, double discountRate, int stock, int memory, int batteryPower, int ram, double screenSize, String colour) {
        super(name, brand, price, discountRate, stock);
        this.memory = memory;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.screenSize = screenSize;
        this.colour = colour;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}





