public class Inventory {
    //Inventory

    private Weapon weapon;
    private Armor armor;

    private boolean food =false;

    private boolean fireWood=false;

    private boolean water=false;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public Inventory() { // Starter pack !
        this.weapon = new Weapon("Default",-1,0,0);
        this.armor = new Armor("Default",-1,0,0);
        this.food=false;
        this.fireWood=false;
        this.water=false;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
