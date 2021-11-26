
public class Main {

	public static void main(String[] args) 
	{
		BST bst = new BST();
                
                BinaryNode root = new BinaryNode(3);
                root.right = new BinaryNode(7);
                root.left = new BinaryNode(2);
                
                root.right.right = new BinaryNode(8);
                root.right.left = new BinaryNode(5);
                
                root.right.left.right = new BinaryNode(6);
                root.right.left.left = new BinaryNode(4);
                
                bst.insert(3);
                bst.insert(7);
                bst.insert(5);
                bst.insert(8);
                bst.insert(2);
                bst.insert(6);  
                bst.insert(4);
                
                bst.printTreePreorder(bst.getRoot());
                
                System.out.println(bst.isBST(root));                
	}
}
