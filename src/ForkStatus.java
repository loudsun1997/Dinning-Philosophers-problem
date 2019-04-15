public enum ForkStatus {
    IDLE{
        public String toString()
        {
            return "idling";
        }
    },
    BEING_USED{
        public String toString()
        {
            return "being used";
        }
    }
}
