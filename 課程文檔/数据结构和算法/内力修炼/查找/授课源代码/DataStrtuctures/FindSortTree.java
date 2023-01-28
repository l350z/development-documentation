/**
 * 二叉查找树之查找算法
 */
public class FindSortTree {
	 private Node root;
	 // 添加数据
	 public void add(int data) {
	  // 递归调用
	  if (null == root)
	   root = new Node(data, null, null);
	  else
	   addTree(root, data);
	 }
	 private void addTree(Node rootNode, int data) {
	  // 添加到左边
	  if (rootNode.data > data) {
	   if (rootNode.left == null)
	    rootNode.left = new Node(data, null, null);
	   else
	    addTree(rootNode.left, data);
	  } else {
	   // 添加到右边
	   if (rootNode.right == null)
	    rootNode.right = new Node(data, null, null);
	   else
	    addTree(rootNode.right, data);
	  }
	 }
	  

		public Node searchNode(int id) {
			Node n = null;
			Node cur = root;
			while (true) {
				if (cur == null)
					break;
				if (id == cur.data) {
					n = cur;
					break;
				}
				if (id > cur.data)
					cur = cur.right;
				else
					cur = cur.left;
			}
			return n;
		}
	 
	 public static void main(String[] args) {
		 
		 FindSortTree tree = new FindSortTree();
		 tree.add(3);
		 tree.add(12);
		 tree.add(7);
		 tree.add(42);
		 tree.add(23);
		 tree.add(37);
		 
		 System.out.println("查找节点为：23");
		 
		 if( tree.searchNode(23)==null )
			 System.out.println("查找失败");
		 else
			 System.out.println("查找成功，查到的节点为："+tree.searchNode(23).data);
		 
	 }
	 

		
		class Node {
			 int data;
			 Node left;
			 Node right;
			 public Node(int data, Node left, Node right) {
			  this.data = data;
			  this.left = left;
			  this.right = right;
			 }
			}
}
