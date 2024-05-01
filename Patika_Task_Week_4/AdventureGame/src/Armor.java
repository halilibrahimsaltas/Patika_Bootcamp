import java.util.Arrays;

public class Armor {
    //Armors
    private int id;
    private int block;

    private int price;

    private String name;

    public Armor(String name,int id, int block, int price) {
        this.id = id;
        this.block = block;
        this.price = price;
        this.name = name;
    }
    //Armors
    public  static Armor[] armors(){
        Armor [] armorsList = new Armor[3];
        armorsList[0] =new Armor("Light Armor",1,1,15);
        armorsList[1] =new Armor("Medium Armor",2,3,25);
        armorsList[2] =new Armor("Heavy Armor",3,5,40);
        return armorsList;
    }

    public  static Armor getArmorOnjByID(int id){ //Armors ID
        for(Armor w : Armor.armors()){
            if (w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
