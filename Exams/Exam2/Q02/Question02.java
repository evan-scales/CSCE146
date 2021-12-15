/*
 * Evan Scales
 * CSCE 146 S2021 Exam02 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question02 
{
	public class Node //public for testing purposes
	{
		private Book data;
		private Node leftChild;
		private Node rightChild;
		public Node(Book aData)
		{
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	public Node root; //public for testing purposes
	public void add(Book aData)
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		if(root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}//Do not alter this
	

//Do not alter-----------------------------------------------------------------------	
	public Book getBookWithMostWords()
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		Node temp = root;
		while(temp.rightChild != null)
			temp = temp.rightChild;
		return temp.data;
	}//Do not alter this
	
	
	//Write additional methods or properties here
	private Node add(Node aNode, Book aData){
		if(aNode == null)
            aNode = new Node(aData);
        else if(aData.getWordCount() < aNode.data.getWordCount())//GO LEnFT
            aNode.leftChild = add(aNode.leftChild, aData);
        else if(aData.getWordCount() > aNode.data.getWordCount())//GO RIGHT
            aNode.rightChild = add(aNode.rightChild, aData);
        return aNode;
	}
	//--------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
		{
			System.out.print("leaf, ");
			return;
		}
		System.out.print(aNode.data+", ");
		printPreorder(aNode.leftChild);
		printPreorder(aNode.rightChild);
	}
//-----------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		System.out.println("Adding books to book tree");
		Book[] books = {new Book(800),
				new Book(600),
				new Book(400),
				new Book(200),
				new Book(100),
				new Book(700),
				new Book(500),
				new Book(3000)};
		Question02 tree = new Question02();
		for(Book b: books)
			tree.add(b);
		System.out.println("Printing the preorder traversal of books");
		tree.printPreorder();
		
		System.out.println("\nThe book with the most words is: "+tree.getBookWithMostWords());

	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * When adding elements to a binary search tree it is recursive.
 *  If the root is null then the binary search tree has not been created and root is set to the data.
 *  There is then an else statement that calls the second add method that takes in the parameters Node 
 * aNode and Book aData. In the else statement it passes in root and aData from the original add method as
 *  the parameters. In the second add method if aNode is null then a new node is created passing in aData as 
 * the data. If the word count at aData is less than the word count at aNode then it recursively goes left by 
 * setting the leftChild at aNode to add with the parameters aNode.leftChild and aData. If the word count at aData 
 * is greater than the word count at aNode then it recursively goes right by setting the rightChild at aNode to add 
 * with the parameters aNode.rightChild and aData. After all that aNode is returned. The method getBookWithMostWords 
 * starts by creating an instance of Node called temp and setting it equal to the root. The node in a binary search
 *  tree with the largest value will be the most bottom right child. There is a loop that runs until temps rightchild no 
 * longer equals null. Inside that loop it sets temp to temps rightChild. In the end temps data is returned. 
 */
