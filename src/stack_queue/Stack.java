package stack_queue;

/**
 * 栈接口
 *
 * @author zhoushuyi
 * @since 2018/6/10
 */
public interface Stack<E> {


    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();


}
