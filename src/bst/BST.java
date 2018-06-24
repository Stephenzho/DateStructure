package bst;

/**
 * 二分搜索树
 *
 * @author zhoushuyi
 * @since 2018/6/24
 */
public class BST<E extends Comparable<E>> {



    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;


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



    public int size(){
        return size;
    }

    public boolean inEmpty() {
        return size == 0;
    }

}
