public class Philosophers extends Thread
{
    private float task;
    private PhilosopherStatus;
    private boolean leftForkInPlace;
    private boolean rightForkInPlace;
    private Fork leftFork;
    private Fork rightFork;
    private int eatingCount;
    private long eatingTime;
    private long thinkingTime;

    public Philosophers(float assignTask, String name)
    {
        task = assignTask;
        setName(name);

    }


    public void run()
    {
        while (! time to go home)
        {
            System.out.println (this.getName() + “THINKING”);
// TODO: think for random number of milliseconds <=1 sec
// TODO: obtain the fork on the left
            // TODO: obtain the fork on the right
            System.out.println (ID + “EATING”);
            // TODO: eat for random number of milliseconds <= 1sec
            // TODO: release the fork on the left
            // TODO: release the fork on the right
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
