package cn.jbit.datastructure.util;

public class TreeNode<T> {
	public T nodeValue;
	public TreeNode<T> left, right;

	public TreeNode(){
		this(null,null,null);
	}
	
	public TreeNode(T item){
		this(item,null,null);
	}

	public TreeNode (T item, TreeNode<T> left, TreeNode<T> right)		{
		nodeValue = item;
		this.left = left;
		this.right = right;
	}
}
