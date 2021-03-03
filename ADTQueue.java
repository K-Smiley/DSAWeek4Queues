package week4;

public interface ADTQueue<E> {

    //public void createQueue();
    public void createQueue();

    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public E front();

    public boolean enqueue(E e);

    public E dequeue();
}
