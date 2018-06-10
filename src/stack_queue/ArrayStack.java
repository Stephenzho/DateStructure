package stack_queue;

import array.Array;

/**
 * 以数组实现的栈
 *
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }



    @Override
    public void push(E o) {
        array.addLast(o);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
