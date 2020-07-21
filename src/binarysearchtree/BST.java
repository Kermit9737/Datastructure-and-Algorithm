package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST <E extends Comparable<E>> {
    private class Node{
        public E e;
        Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //会造成比较次数增加
//    public void add(E e){
//        if (this.root == null){
//            this.root = new Node(e);
//            this.size ++;
//            return;
//        }
//        else {
//            add(this.root,e);
//        }
//
//    }
//
//    private void add(Node node,E e){
//        if (e.equals(node.e)){
//            return;
//        }
//        else if (e.compareTo(node.e) < 0 && node.left != null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if (e.compareTo(node.e) > 0 && node.right != null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0){
//            add(node.left,e);
//        }
//        else {
//            add(node.right,e);
//        }
//
//    }

    /**向二叉树中添加元素，并返回最新的二叉树的根节点*/
    private Node add(Node node,E e){
        if (node == null){
            size++;
            node = new Node(e);
            return node;
            //return new Node(e);//一样的道理
        }

        if (e.compareTo(e) < 0){
            node.left = add(node.left,e);
        }
        else if (e.compareTo(e) > 0){
            node.right = add(node.right,e);
        }
        //如果相等，就什么都不做
        return node;
    }

    /**实际调用的方法，向二叉树中添加元素e*/
    public void add(E e){
        this.root = add(this.root,e);
    }

    /**实际调用的方法，判断二叉树搜索中是否包含元素e*/
    public boolean contains(E e){
        return contains(this.root,e);
    }

    /**查看以node为根节点的二叉树搜索是否包含元素e*/
    private boolean contains(Node node,E e){
        //如果当前的根是空的，证明不存在这个元素
        //因为是二叉搜索树，所以为空一定不存在
        if (node == null){
            return false;
        }

        if (node.e.compareTo(e) == 0){
            return true;
        }
        else if (node.e.compareTo(e) < 0){
            return contains(node.left,e);
        }
        else {
            return contains(node.right,e);
        }

    }

    /**实际调用的方法，前序遍历二分搜索树*/
    public void preOrder(){
        preOrder(this.root);
    }

    /**前序遍历*/
    private void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.e.toString());

        preOrder(node.left);
        preOrder(node.right);
    }

    /**中序遍历----二分搜索树元素的排序*/
    public void inOrder(){
        inOrder(this.root);
    }

    private void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e.toString());
        inOrder(node.right);
    }

    /**后序遍历----内存释放*/
    public void postOrder(){
        postOrder(this.root);
    }

    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e.toString());
    }

    /**前序遍历的非递归写法*/
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e.toString());

            //后入先出，先压右孩子
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**层次遍历（广度优先遍历）*/
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e.toString());
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

}
