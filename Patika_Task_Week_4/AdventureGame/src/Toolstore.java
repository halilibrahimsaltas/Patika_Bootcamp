import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class Toolstore extends NormalLoc {

    public Toolstore(Player player) {
        super(player, "Item Shop !");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome the Weapon&Armor Shop !!"); // Shop loop
        boolean menu = true;
        while (menu) {
            System.out.println("1-Weapon Shop\n2-Armor Shop\n3-Quit"); //Shop menu
            int select = input.nextInt();
            while (select < 1 || select > 3) { /// sELECTİON CHECK
                System.out.println("Wrong Selection! Try Again !");
                select = input.nextInt();
            }
            switch (select) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;

                case 3:
                    menu = false;

                    break;
            }
        }
        return true;
    }

    public void printWeapon() { // Weapons
        System.out.println("---------Weapons-------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + "   Price : " + w.getPrice() + "\tDamage: " + w.getDamage());
        }
        System.out.println("0 - Quit");

    }

    public void buyWeapon() {// Buy loop and equip
        System.out.println("Select an item!");
        System.out.println();
        int selectWepon = input.nextInt();
        while (selectWepon < 0 || selectWepon > 3) {
            System.out.println("Wrong Selection! Try Again !");
            selectWepon = input.nextInt();
        }
        if (selectWepon!=0) {
            Weapon selectedWeapon = Weapon.getWeaponOnjByID(selectWepon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("Your don't have enough coins");
                } else {
                    System.out.println(selectedWeapon.getName() + " was equipped!");
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Balance: " + this.getPlayer().getCoin());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }


    }

    public void printArmor() {// ARMORS
        System.out.println("--------ARMORS---------");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + "   Price : " + a.getPrice() + "\tBlock: " + a.getBlock());
        }
        System.out.println("0 - Quit");

    }

    public void buyArmor() {// Buy loop and equip
        System.out.println("Select an item!");
        System.out.println();
        int selectArmor = input.nextInt();
        while (selectArmor < 0 || selectArmor > 3) {
            System.out.println("Wrong Selection! Try Again !");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorOnjByID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                    System.out.println("Your don't have enough coins");
                } else {
                    System.out.println(selectedArmor.getName() + " was equipped!");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Balance: " + this.getPlayer().getCoin());
                }
            }
        }
    }


}
