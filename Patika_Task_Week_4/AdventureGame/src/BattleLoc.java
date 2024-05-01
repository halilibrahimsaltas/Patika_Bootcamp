import java.util.Random;

public class BattleLoc extends Location {
    private Monsters monsters;
    private String award;

    private int maxMonster;


    public BattleLoc(Player player, String name, Monsters monsters, String award, int maxMonster) {
        super(player, name);
        this.monsters = monsters;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monsters getMonsters() {
        return monsters;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNub = this.randomMonsterNumber();
        System.out.println(this.getName());
        System.out.println("Warning!  Monsters Number: " + monsterNub + " " + this.getMonsters().getName());
        System.out.println("[F]ight XXX [E]scape\nF for Fight!");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();

        if (selectCase.equals("F") && combat(monsterNub)) {
            System.out.println(this.getName() + " was destroyed  by you !!");
            return true;


        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You Died !");
            return false;
        }

        return true;
    }

    public boolean combat(int maxMonster) {
        for (int i = 1; i <= maxMonster; i++) {
            this.getMonsters().setHealth(this.getMonsters().getDefHealth());
            playersStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonsters().getHealth() > 0) {
                System.out.println("[A]ttack or [E]scape");
                String selectCombat = input.nextLine().toUpperCase();
                Random fistAttack = new Random();
                int randomAttack = fistAttack.nextInt(2) + 1;
                if (selectCombat.equals("A")) {
                    switch (randomAttack) {
                        case 1:
                            System.out.println("Player Attack First!!");
                            this.getMonsters().setHealth(this.getMonsters().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                            if (this.getMonsters().getHealth() > 0) {
                                System.out.println();
                                System.out.println("Monsters Attack Turn !!");
                                int monsterDamage = this.getMonsters().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                                if (monsterDamage < 0) {
                                    monsterDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                                afterHit();
                            }
                            break;
                        case 2:
                            System.out.println("Monsters Attack First !!");
                            int monsterDamage = this.getMonsters().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            afterHit();
                            if (this.getPlayer().getHealth() > 0) {
                                System.out.println();
                                System.out.println("Player Attack Turn !!");
                                this.getMonsters().setHealth(this.getMonsters().getHealth() - this.getPlayer().getTotalDamage());
                                afterHit();
                            } else {
                                return false;
                            }
                            break;
                    }

                }else{
                    return false;
                }

            }
            //Coins Awards Check
            if (this.getMonsters().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You defeated the monster!");
                sneakAwards();
                System.out.println(this.getMonsters().getAward() + " Coin reward!");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonsters().getAward());
                System.out.println("Balance: " + this.getPlayer().getCoin());
                //Main Awards check
                if (i == maxMonster) {
                    if (this.getMonsters().getName().equals("Zombie")) {
                        this.getPlayer().getInventory().setFood(true);
                    } else if (this.getMonsters().getName().equals("Vampire")) {
                        this.getPlayer().getInventory().setFireWood(true);
                    } else if (this.getMonsters().getName().equals("Bear")) {
                        this.getPlayer().getInventory().setWater(true);
                    }
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonsters().getName() + " Health: " + this.getMonsters().getHealth());
        System.out.println();

    }
    public void sneakAwards(){
        if(this.getMonsters().getName().equals("Snake")){
            Random drop = new Random();
            int dropItem= drop.nextInt(1000)+1;
            if(dropItem>550){
                System.out.println(" Nothing ! !");
            }else if (dropItem>425){
                System.out.println(" 1 Coin reward!");
                this.getPlayer().setCoin(this.getPlayer().getCoin() +1);
                System.out.println("Balance: " + this.getPlayer().getCoin());
            } else if (dropItem>350) {
                System.out.println(" 5 Coin reward!");
                this.getPlayer().setCoin(this.getPlayer().getCoin() +5);
                System.out.println("Balance: " + this.getPlayer().getCoin());
            } else if (dropItem>300) {
                System.out.println(" 10 Coin reward!");
                this.getPlayer().setCoin(this.getPlayer().getCoin() +10);
                System.out.println("Balance: " + this.getPlayer().getCoin());
            } else if (dropItem>225) {
                if (this.getPlayer().getInventory().getArmor().getBlock()<=1) {
                    System.out.println(" Light Armor is reward!");
                    System.out.println(" Light Armor was equipped!");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(1));
                }
            } else if (dropItem>180) {
                if (this.getPlayer().getInventory().getArmor().getBlock()<=3) {
                    System.out.println(" Medium Armor is reward!");
                    System.out.println(" Medium Armor was  equipped!");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(2));
                }
            } else if (dropItem>150) {
                System.out.println(" Heavy Armor is reward!");
                System.out.println(" Heavy Armor was equipped!");
                this.getPlayer().getInventory().setArmor(Armor.getArmorOnjByID(3));
            } else if (dropItem>75) {
                if (this.getPlayer().getInventory().getWeapon().getDamage()<=2) {
                    System.out.println(" Pistol is reward!");
                    System.out.println(" Pistol was equipped!");
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(1));
                }
            } else if (dropItem>30) {
                if (this.getPlayer().getInventory().getWeapon().getDamage()<=3) {
                    System.out.println(" Sword is reward!");
                    System.out.println(" Sword was equipped!");
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(2));
                }
            }else {
                System.out.println(" Rifle is reward!");
                System.out.println(" Rifle was equipped!");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponOnjByID(3));
            }

        }

    }

    public void playersStats() {
        System.out.println("Players Info");
        System.out.println("------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Coins: " + this.getPlayer().getCoin());
        System.out.println();
    }

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getMonsters().getName() + " Info");
        System.out.println("------------------");
        System.out.println("Health: " + this.getMonsters().getHealth());
        System.out.println("Damage: " + this.getMonsters().getDamage());
        System.out.println("Award: " + this.getMonsters().getAward());
        System.out.println();
    }
}
