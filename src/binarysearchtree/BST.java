package binarysearchtree;

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

    public void add(E e){
        if (this.root == null){
            this.root = new Node(e);
            this.size ++;
            return;
        }
        else {
            add(this.root,e);
        }

    }

    private void add(Node node,E e){
        if (e.equals(node.e)){
            return;
        }
        else if (e.compareTo(node.e) < 0 && node.left != null){
            node.left = new Node(e);
            size++;
            return;
        }
        else if (e.compareTo(node.e) > 0 && node.right != null){
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0){
            add(node.left,e);
        }
        else {
            add(node.right,e);
        }

    }
}
