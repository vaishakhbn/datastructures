package ctci.vaishakh.linkedlist;

public class TreeNode 
{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data)
	{
		this.data = data;
	}
	private void setLeft(TreeNode left)
	{
		this.left = left;
	}
	private void setRight(TreeNode right)
	{
		this.right = right;
	}
	public void insertInOrder(int d)
	{
		if(d<data)
		{
			if(left == null)
			{
				setLeft(new TreeNode(d));
			}
			else
				left.insertInOrder(d);
		}
		else
		{
			if(right == null)
			{
				setRight(new TreeNode(d));
			}
			else
				right.insertInOrder(d);
		}
	}
	
	int height()
	{
		int leftHeight = left!=null?left.height():0;
		int rightHeight = right!=null?right.height():0;
		return 1+ Math.max(leftHeight, rightHeight);
	}

}
