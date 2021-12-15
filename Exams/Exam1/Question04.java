/*
 * Evan Scales
 * CSCE 146 S2021 Exam01 Question04
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter------------------------------------------------------------------------
public class Question04 
{
	public class ListNode//Public for testing purposes
	{
		public double data;
		public ListNode link;
		public ListNode(double aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//Public for testing purposes
	public ListNode tail;//Public for testing purposes
		
	public double dequeue()
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		if(head == null)
			return 0;
		double ret = head.data;
		head = head.link;
		return ret;
	}//Do not alter
//Do not alter------------------------------------------------------------------------
	public void enqueue(double aData)
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		ListNode newNode = new ListNode(aData, null);
		if(head == null){
			head = newNode;
			tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = newNode;

	}//Do not alter
	
	//Write any additional helper properties or methods here
	
	//--------------------------------------------------------------------------------
	//Solution Tests
	public static void main(String[] args)
	{
		//Example
		Question04 dQ = new Question04();
		System.out.println("Test01");
		int amt = 10;
		for(int i=0;i<amt;i++)
		{
			dQ.enqueue(i);
		}
		for(int i=0;i<amt;i++)
		{
			System.out.print(dQ.dequeue()+", ");
		}
		
		System.out.println("\nTest02");
		amt *= 2;
		for(int i=0;i<amt;i+=2)
		{
			dQ.enqueue(i);
		}
		for(int i=0;i<amt;i+=2)
		{
			System.out.print(dQ.dequeue()+", ");
		}
		
		System.out.println("\nTest03");
		amt = 55;
		for(int i=0;i<amt;i+=5)
		{
			dQ.enqueue(i);
		}
		for(int i=0;i<amt;i+=5)
		{
			System.out.print(dQ.dequeue()+", ");
		}
	}
	//--------------------------------------------------------------------------------

}//Do not alter
/*Solution Description
 * In this problem we will be adding and removing items from a queue using enqueue and dequeue.
 *  Enqueue works by taking in a parameter of the type double named aData. newNode is created with
 *  aData as the data, and null as the link. If the head is null, meaning the queue is empty, then 
 * head and tail are set to the newNode then returned. If the queue is not empty then the tails link
 *  is set to the newNode and tail is equal to the newNode. In dequeue it first checks if the head
 *  is null, meaning the queue is empty. If the head is null then it returns 0. If the queue is not
 *  empty then a variable of the type double called ret is created and set to the data at head. Head
 *  is then set to head.link to move along the queue then ret is returned. 
 */
