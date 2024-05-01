
import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    //Game Stars Point

    public void start() {

        System.out.println("Welcome to Adventure Game!");
        System.out.println("Enter  Player Name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        System.out.println(player.getName() + " lETS START");

        player.selectChar();


        Location location = null;
        while (true) {
            System.out.println(); //ADVENTURE SELECT LOOP
            System.out.println("************* AREAS ************");
            System.out.println("1- Safe House");
            System.out.println("2- Item Shop");
            System.out.println("3- Chose an Adventure Area "); //Fight Area
            System.out.println("4- Quit  ");
            player.printInfo();

            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Toolstore(player);
                    break;
                case 3:
                    System.out.println("Chose an Adventure Area "); // Adventure area
                    System.out.println("1- Cave\t\t(Monsters: Zombie\t Awards: Food + Coin)\n2- Forest\t(Monsters: Vampire\t Awards: Wood + Coin)\n3- River\t(Monsters: Bear\t\t Awards: Water + Coin)\n4- Mine\t\t(Monsters: Snake\t Awards: Item + Coin)\n5- Quit");

                    int selectBattleLoc = input.nextInt();
                    switch (selectBattleLoc) {
                        case 1:
                            if(!player.getInventory().isFood()){
                                location = new Cave(player);

                            }else{
                                location = new SafeHouse(player);
                                System.out.println("Reward of this area was already collected!");
                            }
                            break;
                        case 2:
                            if(!player.getInventory().isFireWood()){
                                location = new Forest(player);

                            }else{
                                location = new SafeHouse(player);
                                System.out.println("Reward of this area was already collected!");
                            }
                            break;
                        case 3:
                            if(!player.getInventory().isWater()){
                                location = new River(player);

                            }else{
                                location = new SafeHouse(player);
                                System.out.println("Reward of this area was already collected!");
                            }
                            break;
                        case 4:
                            location = new Mine(player);
                            break;
                        case 5:
                            location = null;
                            break;
                        default:
                            location = null;

                    }
                    break;
                case 4:
                    location = null;
                    break;

                default:
                    location = new SafeHouse(player);

            }

            if (location == null) {
                System.out.println("You Quit From Game!"); // quit from game
                break;
            }

            if (!location.onLocation()) {
                System.out.println("#######  GAME OVER  ######"); // game over !
                break;
            }


        }

    }
}
