package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ 
	  size = 0; 
	  root = null; 
  }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ 
	  return root; 
  }

@Override
public boolean insert(String s) {
	
	if(empty()) {
		root = new BST_Node(s);
		
		size++;
		return true;
	}
	
	if(contains(s)) {
		return false;
	}
	
	root.insertNode(s);

	size++;
	
	return true;
}

@Override
public boolean remove(String s) {
	
	if(root == null) {
		
		return false;
	} else if(!contains(s)) {
		
		return false;
		
	} else if(s.compareTo(root.getData()) == 0) {
		
		if(root.getRight() == null && root.getLeft() != null) {
			root = root.getLeft();
			size--;
			return true;
		} else if(root.getRight() != null && root.getLeft() == null) {
			root = root.getRight();
			size--;
			return true;
		} else if(root.getRight() == null && root.getLeft() == null) {
			root = null;
			size--;
			return true;
		} else {
//			root = root.getLeft();
			size--;
			return root.removeNode(s);
		}
		
	} else {
		size--;
		return root.removeNode(s);
	}
	
}

@Override
public String findMin() {
	if(root == null) {
		return null;
	} else {
		return root.findMin().getData();
	}
}

@Override
public String findMax() {
	if(root == null) {
		return null;
	} else {
		return root.findMax().getData();
	}
}

@Override
public boolean empty() {
	// TODO Auto-generated method stub
	return size <= 0;
}

@Override
public boolean contains(String s) {
	
	if(root == null) {
		return false;
	} else {
		return root.containsNode(s);
	}
	
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public int height() {
	if(root == null) {
		return -1;
	} else {
		return root.getHeight();
	}
}

}