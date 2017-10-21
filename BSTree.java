
public class BSTree {
	
	private class BSTNode {

		String data;
		BSTNode left;
		BSTNode right;	
		
		public BSTNode(String s) {
			data = s;
		}
		
	}
	
	private BSTNode root;

	public void insert(String val) {
		root = insert(val, root);
	}
	
	public BSTNode insert(String val, BSTNode n) {
		if (n == null) {
			n = new BSTNode(val);
			return n;
		}
		else if (n.data.compareTo(val) > 0) { // If val < n.data
			n.left = insert(val, n.left);
			return n;
		}
		else {
			n.right = insert(val, n.right);  // If val > n.data
			return n;
		}
	}
	
	public boolean find(String val) {
		return find(val, root);
	}
	
	public boolean find(String val, BSTNode n) {
		if (n == null)  // Base case
			return false;
		if (n.data.compareTo(val) == 0)  // If val == n.data
			return true;
		else if (n.data.compareTo(val) > 0)	 // If val < n.data
			return find(val, n.left);
		else if (n.data.compareTo(val) < 0)	 // If val > n.data
			return find(val, n.right);
		return true;
	}
	
	public void delete(String val) {
		root = delete(root, val);
	}
	
	public BSTNode delete(BSTNode node, String val) {
		if (node == null)
			return null;
		if (node.data.compareTo(val) == 0) {
			if (node.left == null) {
				return node.right;
			}
			else if (node.right == null) {
				return node.left;
			}
			else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}
		else if (node.data.compareTo(val) > 0) {
			node.left = delete(node.left, val);
		}
		else 
			node.right = delete(node.right, val);
		return null;
	}
	
	public String removeSmallest(BSTNode node) {
		if (node.left.left == null) {
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else {
			return removeSmallest(node.left);
		}
	}

	public String toStringInOrder() {
		String s = "";
		s = toStringInOrder(root);
		s = s.trim();
//		System.out.println(s);
		return s;
	}
	
	public String toStringInOrder(BSTNode n) {
		if (n == null) 
			return "";
		String l = toStringInOrder(n.left);
		String r = toStringInOrder(n.right);
		String s = l + " " + n.data + r;
		return s;
	}

	public String toStringPreOrder() {
		String s = "";
		s = toStringPreOrder(root);
		s = s.trim();
//		System.out.println(s);
		return s;
	}
	
	public String toStringPreOrder(BSTNode n) {
		if (n == null) 
			return "";
		String l = toStringPreOrder(n.left);
		String r = toStringPreOrder(n.right);
		String s = n.data + " " + l + r;
		return s;
	}
}
