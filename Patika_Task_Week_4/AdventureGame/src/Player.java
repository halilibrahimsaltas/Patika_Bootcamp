import java.util.Scanner;

public class Player {

    //Player info's and detail

    private int damage;
    private int health;
    private int coin;

    private String name;

    private String charName;

    private Inventory inventory;

    private int totalDamage;

    private int defHealth;

    Scanner input= new Scanner(System.in);

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    Player(String name) {
        this.name = name;
        this.inventory= new Inventory();

    }

    public void selectChar() { //Hero selection point
        Hero[] gameChar = {new Samurai(), new Ranger(), new Knight()};

        System.out.println("-----------------------------------");
        for (Hero hero : gameChar) {
            System.out.println("ID: "+hero.getId()+"\tCharacter: " + hero.getCharName() + "\tDamage: "+ hero.getDamage()+ "\tHealth: " + hero.getHealth()+ "\tCoin: "+ hero.getCoin());
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(" ############  Select a Character!  #############");
        System.out.println("----------------------------------------------------");
        int selectChar= input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Ranger());

                break;
            case 3:
                initPlayer(new Knight());

                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character: " + this.getCharName() + "\tDamage: "+ this.getDamage()+ "\tHealth: " + this.getHealth()+ "\tCoin: "+ this.getCoin());

    }

    public void initPlayer(Hero gameChar){ // hero detail setting
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setDefHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
    }

    public  void printInfo(){ //// hero info
        System.out.println(
                "Your Weapon:" + this.getInventory().getWeapon().getName() +
                "\tYour Armor:" + this.getInventory().getArmor().getName()+
                "\t\tDamage: " + this.getTotalDamage()+
                "\tBlock: "+ this.getInventory().getArmor().getBlock()+
                "\tHealth: " + this.getHealth()+
                "\tCoins: " + this.getCoin()+
                "\nItems: Food="+ this.getInventory().isFood()+ " Firewood= "+ this.getInventory().isFireWood()+ " Water= "+this.getInventory().isWater());

    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
