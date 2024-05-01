public class SafeHouse  extends NormalLoc{

    //Safehouse


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {

        System.out.println("You are in the Safe House !");
        System.out.println("Your HP refreshed !");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth()); // refreshing hp
        // Game win conditon check point
        if (this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isFireWood()){
            System.out.println("**********************************************");
            System.out.println("You won the game !! Congratulations");
            System.out.println("**********************************************");

        }

        return true;
    }
}
