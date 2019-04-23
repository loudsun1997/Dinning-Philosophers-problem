public class Fork {

    private ForkStatus FStatus;

    public Fork()
    {
        FStatus = ForkStatus.IDLE;
    }

    public ForkStatus getFStatus() {
        return FStatus;
    }

    public synchronized void setFStatus(ForkStatus FStatus) {
        this.FStatus = FStatus;
    }
}
