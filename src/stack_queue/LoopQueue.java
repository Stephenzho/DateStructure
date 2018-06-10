package stack_queue;

/**
 * 循环队列
 *
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class LoopQueue<E> implements Queue<E>{

    private int size;
    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(){
        this(10);
    }
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }


    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from a empty queue.");
        }

        E e = data[front];
        data[front] = null;
        front++;
        size--;

        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from a empty queue.");
        }


        return data[front];
    }


    public void resize(int capacity){
        E[] newdata = (E[]) new Object[capacity + 1];

        for (int i = 0; i < size; i++) {
            // (i + front) % data.length 循环下标
            newdata[i] = data[(i + front) % data.length];
        }

        data = newdata;
        front = 0;
        tail = size;
    }



    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
