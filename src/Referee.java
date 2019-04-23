import java.util.ArrayList;

public class Referee
{
    private int task;
    private long randomSeed;
    private ArrayList<Fork> forkList= new ArrayList<Fork>();
    private ArrayList<Philosophers> PhilosopherList = new ArrayList<Philosophers>();

    Referee(long randomSeed)
    {
        this.randomSeed = randomSeed;
        task = 10;
    }


    public void start()
    {
        for(int i = 0; i < 6; i++)
            forkList.add(i, new Fork(i));

        for(int i = 0; i < 5; i++)
        {
            if(i == 4)
            {
                Philosophers p = new Philosophers(task, Integer.toString(i), randomSeed, forkList.get(i), forkList.get(0));
            }
            Philosophers p = new Philosophers(task, Integer.toString(i), randomSeed, forkList.get(i), forkList.get(i+1));

            p.start();
        }


    }

}