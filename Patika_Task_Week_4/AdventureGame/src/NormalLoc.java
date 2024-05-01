public abstract class NormalLoc extends Location {

    //location canvas


    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
