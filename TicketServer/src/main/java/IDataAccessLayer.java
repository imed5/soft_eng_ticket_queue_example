public interface IDataAccessLayer {
    public int getCurrentQueueNumber();
    public int getCurrentServedNumber();
    public void updateServedNumber(int number);
    public void updateQueueNumber(int number);
}
