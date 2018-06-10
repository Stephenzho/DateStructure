package stack_queue;

/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
