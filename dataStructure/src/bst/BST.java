package bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    /**
     * 节点类
     */
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为节点的树中添加元素e
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    //查询是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //查询以node为节点的树中是否包含元素e
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);

    }

    //递归实现前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //非递归实现前序遍历
    public void preOrderNR(){
        preOrderNR(root);
    }
    private void preOrderNR(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.e);
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
    }
    //递归实现中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //递归实现后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    //使用队列实现层序遍历
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.e);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
    //递归实现寻找二分搜索树的最小值
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
       return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }
    //非递归实现寻找二分搜索树的最小值
    public E minimumNR(){
        return minimumNR(root).e;
    }
    private Node minimumNR(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    //递归实现寻找二分搜索树的最大值
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }
    //非递归实现寻找二分搜索树的最大值
    public E maximumNR(){
        return maximumNR(root).e;
    }
    private Node maximumNR(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
    //从二分搜索树中删除最小的元素，并返回最小的值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除以node 为根的二分搜索树中的最小节点
    //返回删除之后的二分搜索树的根
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

    //从二分搜索树中删除最小的元素，并返回最大的值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    //删除以node 为根的二分搜索树中的最大节点
    //返回删除之后的二分搜索树的根
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
    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }
    private Node remove(Node node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);

            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);


    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<depth; i++)
            res.append("--");
        return res.toString();
    }

}
