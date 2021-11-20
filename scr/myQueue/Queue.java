package homework8.homework8Three;



public class Queue<T> {
    private final int capacity;
    private final T[] q;
    private int elemNum;
    private int head;
    private int tail;


    public Queue(int size) {
        capacity = size;
        q = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return elemNum == 0;
    }

    public void add(T elem) {
        if (tail == capacity) {
            tail = 0;
            q[tail++] = elem;
            elemNum++;
        }
        else {
            q[tail] = elem;
            tail++;
            elemNum++;
        }
    }
    public T remove(){
        if (isEmpty())
            new Exception("Empty");
        elemNum--;
        return q[head++];
    }
    public int size() {
        return elemNum;
    }
    public void clear() {
        for (int i = 0; i < capacity; i++)
            q[i] = null;
        elemNum = 0;

    }

    public T peek() {
        return  q[0];
    }

    public T poll() {
        if (isEmpty())
            return null;
        elemNum--;
        return q[head++];

    }


}
