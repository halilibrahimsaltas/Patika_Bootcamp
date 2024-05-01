import sun.dc.pr.PRError;

public class Monsters {
    //Monster info ad detail
    private int id ;

    private String name;
    private int damage;

    private int health;

    private  int award;
    private int defHealth;

    public Monsters(int id, String name, int damage, int health,int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defHealth=health;
        this.award=award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) { // set health 0
        if (health<0){
            health=0;
        }
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
