import java.util.Random;

public class Snake extends Monsters{

    //Snake

    public static Random n = new Random();


    public Snake() {
        super(4, "Snake", n.nextInt(3)+3, 12,0);

    }

}
