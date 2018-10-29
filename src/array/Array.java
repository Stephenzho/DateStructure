package array;


/**
 * @author zhoushuyi
 * @since 2018/6/9
 */
public class Array<T> {

    private T[] data;

    /**
     * 指 到第一个null值的下标
     */
    private int size = 0;


    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return data[index];
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }
    public void set(int index, T e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        data[index] = e;
    }

    public T remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        T re = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // loitering objects
        data[size] = null;

        if (size < data.length >> 2 && data.length >> 1 != 0) {
            resize(data.length >> 1);
        }

        return re;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     * @return
     */
    public T removeLast(){
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

    }



    /**
     * 查找某元素的下标
     * @param e
     * @return
     */
    public int find(T e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 查看数组中有e没有
     * @param e
     * @return
     */
    public boolean contains(T e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }



    public void add(int index, T e) {

        if (size == data.length) {
            resize(size << 1);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 向右移动数据
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 设置数据
        data[index] = e;
        // 更新size
        size++;
    }
    public void addFirst(T e) {
        this.add(0, e);
    }
    public void addLast(T e){
        this.add(size, e);
    }
    public void add(T e) {
        this.add(size , e);
    }




    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        T d  = data[i];
        data[i] = data[j];
        data[j] = d;
    }




    public int getSize() {
        return size;
    }

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array(T[] arr) {
        data = arr;
    }

    public Array() {
        this(10);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getCapacity() {
        return data.length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
