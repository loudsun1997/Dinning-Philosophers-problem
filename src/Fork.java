public class Fork {

    private ForkStatus FStatus;
    private int FNumber;

    public Fork(int FNumber)
    {
        FStatus = ForkStatus.IDLE;
        this.FNumber = FNumber;
    }

    public ForkStatus getFStatus() {
        return FStatus;
    }

    public synchronized void setFStatus(ForkStatus FStatus) {
        this.FStatus = FStatus;
    }
}
