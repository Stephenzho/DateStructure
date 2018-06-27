package bst;

/**
 * 二分搜索树
 *
 * @author zhoushuyi
 * @since 2018/6/24
 */
public class BST<E extends Comparable<E>> {


    private Node node;
    private int h;

    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {

            return e.toString();
        }
    }

    private Node root;
    private int size;


    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 查看时候含有e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        }else if (node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }


    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node);

        preOrder(node.left);
        preOrder(node.right);
    }

    public int size(){
        return size;
    }

    public boolean inEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return order(root, 0, sb).toString();
    }

    private StringBuilder order(Node node, int h, StringBuilder sb) {

        if (node == null) {
            return sb.append(placeholder(h) + "null\n");
        }

        sb.append(placeholder(h) + node.e + "\n");


        order(node.left, h + 1, sb);
        order(node.right, h + 1, sb);

        return sb;
    }

    private String placeholder(int h) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
