import java.util.ArrayList;

public class Referee
{
    private long randomSeed;
    private ArrayList<Fork> forkList= new ArrayList<Fork>();
    private ArrayList<Philosophers> PhilosopherList = new ArrayList<Philosophers>();

    Referee(long randomSeed)
    {
        this.randomSeed = randomSeed;
    }


    public void start()
    {
    }

    public Fork obtainLeftFork() {
    }

    public Fork obtainRightFork() {
    }
}
