package cn.jbit.datastructure.util;

public class BinaryTree<E> {
    protected TreeNode<E> root;                //根结点

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(TreeNode<E> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public TreeNode<E> getRoot(){
        return this.root;
    }
}
