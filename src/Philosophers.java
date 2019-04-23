import java.util.Random;

public class Philosophers extends Thread
{
    private int task;
    private PhilosopherStatus PStatus;
    private boolean leftForkInPlace;
    private boolean rightForkInPlace;
    private Fork leftFork;
    private Fork rightFork;
    private int eatingCount;
    private long totalEatingTime;
    private long thinkingTime;

    private Random rnd;
    private static int randomBound = 1000;
    private int scheduledThinkingTime;
    private int scheduledEatingTime;

    private Referee ref;

    public Philosophers(int assignTask, String name, long randomSeed, Fork leftF, Fork rightF)
    {
        task = assignTask;
        setName(name);
        rnd = new Random(randomSeed);
        eatingCount = 0;
        totalEatingTime = 0;
        thinkingTime = 0;
        this.ref = ref;
        leftFork = leftF;
        rightFork = rightF;
        PStatus = PhilosopherStatus.THINKING;
    }


    public void run()
    {

        while (task > 0)
        {
            System.out.println(this.getName() + " is " + PStatus.toString());

            scheduledThinkingTime = rnd.nextInt(randomBound);
            thinkingTime = thinkingTime + scheduledThinkingTime;
            goThink(scheduledThinkingTime);

            if (leftFork.getFStatus() == ForkStatus.IDLE && rightFork.getFStatus() == ForkStatus.IDLE)
            {
                leftFork.setFStatus(ForkStatus.BEING_USED);
                rightFork.setFStatus(ForkStatus.BEING_USED);
                scheduledEatingTime = rnd.nextInt(randomBound);
                totalEatingTime = totalEatingTime + scheduledEatingTime;
                goEat(scheduledEatingTime);
                leftFork.setFStatus(ForkStatus.IDLE);
                rightFork.setFStatus(ForkStatus.IDLE);
                task--;
            }
        }

        print("End for " + this.getName());
    }


    private void goThink(int scheduledThinkingTime)
    {
        PStatus = PhilosopherStatus.THINKING;
        print(this.getName() + " is thinking.");
        try {
            Thread.sleep(scheduledThinkingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goEat(int scheduledEatingTime)
    {
        PStatus = PhilosopherStatus.EATING;
        print(this.getName() + " is eating.");
        try {
            Thread.sleep(scheduledEatingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void print(Object O)
    {
        System.out.println(O);
    }








    public void setLeftForkInPlace(boolean leftForkInPlace) {
        this.leftForkInPlace = leftForkInPlace;
    }

    public void setRightForkInPlace(boolean rightForkInPlace) {
        this.rightForkInPlace = rightForkInPlace;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public int getEatingCount() {
        return eatingCount;
    }

    public void setEatingCount(int eatingCount) {
        this.eatingCount = eatingCount;
    }

    public long getEatingTime() {
        return totalEatingTime;
    }

    public void setEatingTime(long eatingTime) {
        this.totalEatingTime = eatingTime;
    }

    public long getThinkingTime() {
        return thinkingTime;
    }

    public void setThinkingTime(long thinkingTime) {
        this.thinkingTime = thinkingTime;
    }
}
