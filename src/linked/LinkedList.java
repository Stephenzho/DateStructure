package linked;

/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class LinkedList<E> {

    private class Node<E>{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.size = 0;
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node<E> prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }


    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node<E> prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.e = e;
    }

    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node<E> prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node prve = dummyHead;
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }

        Node indexNode = prve.next;
        prve.next = indexNode.next;
        indexNode.next = null;

        size--;
        return (E) indexNode.e;
    }

    public E removeLast(){
        return remove(size-1);
    }
    public E removeFirst(){
        return remove(0);
    }


    public boolean contains(E e) {
        Node<E> prev = dummyHead.next;
        do {
            if (prev.e.equals(e)) {
                return true;
            }

            prev = prev.next;
        } while (prev != null);

        return false;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }

        return res.toString();
    }

}
