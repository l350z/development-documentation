/**
 * 二叉查找树之插入算法
 */
public class BinarySortTree {
	private Node root;
	private static BinarySortTree tree = new BinarySortTree();
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

	// 查询数据
	public void show() {
		System.out.print("中序遍历结果为：");
		showTree(root);
	}

	private void showTree(Node node) {
		if (node.left != null) {
			showTree(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			showTree(node.right);
		}
	}
	//创建树
	private static void createTree() {
		tree.add(15);
		tree.add(12);
		tree.add(9);
		tree.add(14);
		tree.add(13);
		tree.add(19);
		tree.add(18);
		tree.add(22);
		tree.add(23);
	}

	public static void main(String[] args) {

		
		createTree();
		//插入节点		
		
		System.out.println("插入节点：17");
		tree.add(17);
		
		tree.show();

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
