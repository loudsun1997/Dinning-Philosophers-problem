public enum PhilosopherStatus {
    THINKING{
        public String toString()
        {
            return "thinking";
        }
    },
    WAIT_LEFT_FORK{
        public String toString()
        {
            return "waiting for left fork";
        }
    },
    WAIT_RIGHT_FORK{
        public String toString()
        {
            return "waiting for right fork";
        }
    },
    EATING{
        public String toString()
        {
            return "eating";
        }
    }


}
