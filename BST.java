public class BST 
{
	private BinaryNode root;
	
	public BST()
	{ 
		this.setRoot(null); 
	}
	
	public BinaryNode getRoot() {
		return root;
	}

	public final void setRoot(BinaryNode root) {
		this.root = root;
	}
	
	// Inserts an element recursively
	public void insert(int x)
	{
		root = insertRecursively(root, x);
	}
        
	private BinaryNode insertRecursively(BinaryNode root, int x)
	{
	if (root == null)  
        { 
            root = new BinaryNode(x); 
            return root; 
        } 
        if (x < root.element) 
        {
            root.left = insertRecursively(root.left, x); 
        }
            
        else if (x > root.element)
        {
            root.right = insertRecursively(root.right, x);
        }   
        return root; 
	}

	public int findDepth(BinaryNode root)
	{	
    if (root == null)
    {
        return 0;
    }

    int leftDepth = findDepth(root.left); 
    int rightDepth = findDepth(root.right); 
    
    if (leftDepth > rightDepth) 
    {
        return (leftDepth + 1); 
    }  
    else 
    {
        return (rightDepth + 1); 
    }
	}

	public void remove(int x)
	
	{
            root = deleteRec(root, x); 
        }
 
    int minValue(BinaryNode root)
    {
        int minv = root.element;
        while (root.left != null) 
        {
            minv = root.left.element;
            root = root.left;
        }
        return minv;
    }
        
    BinaryNode deleteRec(BinaryNode root, int x)
    {
        if (root == null)
            return root;

        if (x < root.element)
        {
            root.left = deleteRec(root.left, x);
        }
            
        else if (x > root.element)
        {
            root.right = deleteRec(root.right, x);
        }

        else 
        {
            if (root.left == null)
            {
                 return root.right;
            }
               
            else if (root.right == null)
            {
                return root.left;
            }
                
            root.element = minValue(root.right);
            root.right = deleteRec(root.right, root.element);
        }
        return root;
	}
    
	public void printTreePreorder(BinaryNode root)
	{
	if(root != null)  
        { 
            printTreePreorder(root.right); 
            System.out.print(root.element + " "); 
            printTreePreorder(root.left); 
        } 
	}
        
    boolean isBST(BinaryNode node)
{
    if (node == null)
    {
        return true;
    }
    else if (node.left != null && node.left.element > node.element)
    {
         return false;
    } 
    else if (node.right != null && node.right.element < node.element) 
    {
       return false;  
    }
    else if (!isBST(node.left) || !isBST(node.right)) 
    {
        return false;
    }
    else
    {
        return true; 
    }
}
}
