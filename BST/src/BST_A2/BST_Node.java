package BST_A2;

public class BST_Node {

	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public boolean insertNode(String s) {
		
		if(containsNode(s)) {
			return false;
		}
		
		if(s.compareTo(data) > 0) {
			
			if(right == null) {
				right = new BST_Node(s);
				parent = this;
				return true;
			}
			
			right.insertNode(s);
			
		} else if(s.compareTo(data) < 0) {
			
			if(left == null) {
				left = new BST_Node(s);
				parent = this;
				return true;
			}
			
			left.insertNode(s);
		}
		
		return false;
	}

	public boolean containsNode(String s) {
		
		if(s.compareTo(data) == 0) {
			
			return true;
		
		} else if(s.compareTo(data) > 0) {
			
			if(right != null) {
				return right.containsNode(s);
			} else {
				return false;
			}
			
		} else if(s.compareTo(data) < 0) {
			if(left != null) {
				return left.containsNode(s);
			} else {
				return false;
			}
		}
		
		return false;
	}

	public boolean removeNode(String s) {
		
		if(s.compareTo(data) > 0) {
			
			if(right == null) {
				return false;
			}
			
			if(s.compareTo(right.getData()) == 0) {
				
				if(right.right == null && right.left != null) {

					right = right.left;
					
					return true;
					
				} else if (right.right != null && right.left == null) {
					
					right = right.right;
			
					return true;
					
				} else if (right.right != null && right.left != null) {
				
					String temp = right.left.findMax().getData();
			
					right.removeNode(temp);
					
					right.data = temp;
					
					return true;
					
				} else if(right.right == null && right.left == null) {
					
					right = null;
					
					return true;
				} 
			} else {
				return right.removeNode(s);
			}
			
		} else if(s.compareTo(data) < 0) {
			
			if(left == null) {
				return false;
			}

			if(s.compareTo(left.getData()) == 0) {
				
				if(left.right == null && left.left != null) {

					left = left.left;
					
					return true;
					
				} else if (left.right != null && left.left == null) {
					
					left = left.right;
			
					return true;
					
				} else if (left.right != null && left.left != null) {
					
					String temp = left.left.findMax().getData();
					
					left.removeNode(temp);
					
					left.data = temp;
					
					return true;
					
				} else if(left.right == null && left.left == null) {
					left = null;
					
					return true;
				} 
			} else {
				return left.removeNode(s);
			}
		} 
		
		return false;
	}

	public boolean testRemove(String s) {
		
		if(s.compareTo(data) > 0) {
			
		} else if(s.compareTo(data) < 0) {
			/*
			 * Left Side
			 */
			if(s.compareTo(left.getData()) == 0) {
				System.out.println("Equal");
			} else {
				return left.testRemove(s);
			}
			
		} 
		
		
		return false;
	}
	
	public BST_Node findMin() {
		
		if(left == null) {
			return this;
		} else {
			return left.findMin();
		}

	}

	public BST_Node findMax() {
		if(right == null) {
			return this;
		} else {
			return right.findMax();
		}
	}

	public int getHeight() {
		
		if(right == null && left == null) {
			return 0;
		} else if(right == null && left != null) {
			return 1 + left.getHeight();
		} else if(right != null && left == null) {
			return 1 + right.getHeight();
		} else {
			return 1 + Math.max(right.getHeight(), left.getHeight());
		}
		
	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
	
	
//	if(s.compareTo(right.getData()) == 0) {
//		
//		if(right.right == null && right.left != null) {
//
//			right = right.left;
//			
//			return true;
//			
//		} else if (right.right != null && right.left == null) {
//			
//			right = right.right;
//	
//			return true;
//			
//		} else if (right.right != null && right.left != null) {
//			
//			right.data = right.left.findMax().getData();
//			
//			right.removeNode(right.data);
//			return true;
//			
//		} else {
//			
//			right = null;
//			
//			return true;
//		} 
//	}
}
