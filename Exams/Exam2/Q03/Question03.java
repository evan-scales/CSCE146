/*
 * Evan Scales
 * CSCE 146 S2021 Exam02 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question03 
{
	public class Node //public for testing purposes
	{
		private Furniture data;
		private Node leftChild;
		private Node rightChild;
		public Node(Furniture aData)
		{
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	public Node root; //public for testing purposes
	public boolean search(Furniture aData)
	{
//-----------------------------------------------------------------------------------
		//Write your solution herel
		return search(root, aData);
	}//Do not alter this
//Do not alter-----------------------------------------------------------------------	
	public Furniture leastExpensive()
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		Node temp = root;
		while(temp.leftChild != null)
			temp = temp.leftChild;
		return temp.data;
	}//Do not alter this
	
	//Write additional methods or properties here
	private boolean search(Node aNode, Furniture aData){
		if(aNode == null)
			return false;
		else if(aData.getPrice() < aNode.data.getPrice())//GO LEFT
			return search(aNode.leftChild, aData);
		else if(aData.getPrice() > aNode.data.getPrice())//GO RIGHT
			return search(aNode.rightChild, aData);
		else
			return true;
	}
	
//Do not alter------------------------------------------------------------------------
	public void test01()
	{
		this.root = new Node(new Furniture(500));
		this.root.leftChild = new Node(new Furniture(250));
		this.root.leftChild.leftChild = new Node(new Furniture(150));
		this.root.leftChild.rightChild = new Node(new Furniture(350));
		this.root.rightChild = new Node(new Furniture(750));
		this.root.rightChild.leftChild = new Node(new Furniture(650));
		this.root.rightChild.rightChild = new Node(new Furniture(950));
	}
	public static void main(String[] args)
	{
		Question03 tree = new Question03();
		tree.test01();
		System.out.println("Testing the search method");
		System.out.println("Does it find the furniture with the price 250? "+tree.search(new Furniture(250)));
		System.out.println("Does it find the furniture with the price 1150? "+tree.search(new Furniture(1150)));
		System.out.println("Does it find the furniture with the price 950? "+tree.search(new Furniture(950)));
		System.out.println("Testing the least expensive method");
		System.out.println("The least expensive furniture is: "+tree.leastExpensive());
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * Search is recursively done in a binary search tree. A recursive search
 *  method which takes in the parameters Node aNode and Furniture aData. Inside
 *  the first method it returns the recursive search method with the parameters root
 *  and the data from the original search method. Inside the recursive method if the node is
 *  null then false is returned. If the price at aData is less than the price at aNode then it
 *  goes left, and recursively calls search using aNodes left child and the original aData. If the
 *  price at aData is greater than the price at aNode then search is recursively called using aNode
 *  righChild. There is then an else statement that just simply returns false. In the method leastExpensive 
 * a node temp is created and set to the root. Since the smallest item in a binary search tree is in the 
 * futhurest down leftChild a while loop is created that goes until temps leftChild is null. Once the loop
 *  is done the data at temp is returned. 

 */
