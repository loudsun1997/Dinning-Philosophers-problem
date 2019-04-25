import java.util.ArrayList;
import java.util.Scanner;

public class Referee
{
    private int task;
    private long randomSeed;
    private int rounds;

    private Scanner input;

    private ArrayList<Fork> forkList= new ArrayList<Fork>();
    private ArrayList<Philosophers> PhilosopherList = new ArrayList<Philosophers>();

    Referee(long randomSeed)
    {
        this.randomSeed = randomSeed;


        input = new Scanner(System.in);
        Philosophers.print("Please enter number of Philosophers:");
        rounds = input.nextInt();
        Philosophers.print("Please enter number of task");
        task = input.nextInt();
    }


    public void start()
    {
        for(int i = 0; i < rounds; i++)
            forkList.add(i, new Fork(i));

        for(int i = 0; i < (rounds - 1); i++)
        {
            if(i == (rounds - 2))
            {
                Philosophers p = new Philosophers(task, Integer.toString(i), randomSeed, forkList.get(i), forkList.get(0));
            }
            Philosophers p = new Philosophers(task, Integer.toString(i), randomSeed, forkList.get(i), forkList.get(i+1));

            p.start();
        }


    }

}