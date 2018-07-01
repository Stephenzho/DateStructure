package bst;

import java.util.ArrayDeque;
import java.util.Stack;

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

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = minimum(root);
        return minNode.e;
    }


    /**
     *  返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node){
        if( node.left == null ) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     *  寻找二分搜索树的最大元素
     */
    public E maximum(){
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    /**
     *  返回以node为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node){
        if( node.right == null ) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
      * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right).e);
            size ++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            size --;

            return successor;
        }
    }


    /**
     * 层序遍历
     */
    public void levelOrder() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            System.out.println(node.e);

            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }

    /**
     * 遍历非递归模式
     */
    public void orderNR() {
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 前序遍历
     */
    public void order() {
        order(root,0);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        order(root, 1);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        order(root, 2);
    }

    private void order(Node node,int i) {
        if (node == null) {
            return;
        }
        if (i == 0) {
            System.out.println(node);
        }

        order(node.left, i);

        if (i == 1) {
            System.out.println(node);
        }

        order(node.right, i);

        if (i == 2) {
            System.out.println(node);
        }
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

        return print(root, 0, sb).toString();
    }

    private StringBuilder print(Node node, int h, StringBuilder sb) {
        if (node == null) {
            return sb.append(placeholder(h) + "null\n");
        }

        sb.append(placeholder(h) + node.e + "\n");

        print(node.left, h + 1, sb);
        print(node.right, h + 1, sb);

        return sb;
    }

    /**
     * 遍历时的占位符
     * @param h
     * @return
     */
    private String placeholder(int h) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
