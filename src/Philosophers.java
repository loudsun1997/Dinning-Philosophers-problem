import java.util.Random;

public class Philosophers extends Thread
{
    private float task;
    private PhilosopherStatus PStatus;
    private boolean leftForkInPlace;
    private boolean rightForkInPlace;
    private Fork leftFork;
    private Fork rightFork;
    private int eatingCount;
    private long eatingTime;
    private long thinkingTime;

    private Random rnd;
    private static int randomBound = 1000;
    private int scheduledThinkingTime;
    private int scheduledEatingTime;

    private Referee ref;

    public Philosophers(float assignTask, String name, long randomSeed, Referee ref)
    {
        task = assignTask;
        setName(name);
        rnd = new Random(randomSeed);
        eatingCount = 0;
        eatingTime = 0;
        thinkingTime = 0;
        this.ref = ref;
    }


    public void run()
    {
        try
        {
            while (task>0)
            {
                System.out.println (this.getName() + " is " + PStatus.toString());
// TODO: think for random number of milliseconds <=1 sec

                PStatus = PhilosopherStatus.THINKING;
                scheduledThinkingTime = rnd.nextInt(randomBound);
                thinkingTime = thinkingTime + scheduledThinkingTime;
                Thread.sleep(scheduledThinkingTime);
// TODO: obtain the fork on the left
                leftFork = ref.obtainLeftFork();
                // TODO: obtain the fork on the right
                rightFork = ref.obtainRightFork();
                PStatus = PhilosopherStatus.EATING;
                System.out.println (this.getName() + " is " + PStatus.toString());
                scheduledEatingTime = rnd.nextInt(randomBound);
                eatingTime = eatingTime + scheduledThinkingTime;
                // TODO: eat for random number of milliseconds <= 1sec
                // TODO: release the fork on the left
                // TODO: release the fork on the right
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " +  threadName + " interrupted.");
        }


    }

    private boolean isLeftForkInPlace()
    {
        return leftFork != null;
    }

    private boolean isRightForkInPlace()
    {
        return rightFork != null;
    }

    private void resetLeftFork()
    {
        leftFork = null;
    }

    private void resetRightFork()
    {
        rightFork = null;
    }














    public float getTask() {
        return task;
    }

    public void setTask(float task) {
        this.task = task;
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
        return eatingTime;
    }

    public void setEatingTime(long eatingTime) {
        this.eatingTime = eatingTime;
    }

    public long getThinkingTime() {
        return thinkingTime;
    }

    public void setThinkingTime(long thinkingTime) {
        this.thinkingTime = thinkingTime;
    }
}
