import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * Evan Scales
 * CSCE 146 S2021 Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question03 
{
	public class ListNode//public for testing purposes
	{
		public Rectangle data;//public for testing purposes
		public ListNode link;//public for testing purposes
		public ListNode(Rectangle aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//public for testing purposes
	public void removeAreasLessThan(double area)
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		ListNode pTemp = null;
		ListNode temp = head;
		while(temp != null){
			Rectangle aRectangle = temp.data;
			if(temp == head && getArea(aRectangle) < area){
				head = head.link;
				temp = head;
			}
			else if(getArea(aRectangle) < area){
				pTemp.link = temp.link;
				temp = temp.link;
			}
			else{
				pTemp = temp;
				temp = temp.link;
			}
		}

	}//Do not alter this

	//Write additional methods or properties here
	public static double getArea(Rectangle aR){
		return (aR.getHeight() * aR.getWidth());
	}
	//--------------------------------------------------------------------------------
	//Solution Tests
	public void test01()
	{
		head = new ListNode(new Rectangle(1.0, 1.0),
					new ListNode(new Rectangle(10.0, 10.0),
							new ListNode(new Rectangle(2.0, 2.0),
								new ListNode(new Rectangle(9.0, 9.0),
										new ListNode(new Rectangle(3.0, 3.0),
												new ListNode(new Rectangle(8.0, 8.0),null))))));
	}
	public void test02()
	{
		head = new ListNode(new Rectangle(73.0, 85.0),
					new ListNode(new Rectangle(29.0, 60.0),
							new ListNode(new Rectangle(93.0, 50.0),
									new ListNode(new Rectangle(76.0, 98.0),
											new ListNode(new Rectangle(4.0, 48.0),
													new ListNode(new Rectangle(32.0, 11.0),null))))));
	}
	public void test03()
	{
		head = new ListNode(new Rectangle(1.0, 1.0),
				new ListNode(new Rectangle(10.0, 10.0),
						new ListNode(new Rectangle(2.0, 2.0),
							new ListNode(new Rectangle(9.0, 9.0),
									new ListNode(new Rectangle(3.0, 3.0),
											new ListNode(new Rectangle(8.0, 8.0),null))))));
	}
	public void print()
	{
		if(head == null)
			System.out.println("Empty");
		for(ListNode temp = head;temp != null;temp = temp.link)
			System.out.print(temp.data+", ");
		System.out.println();
	}
	public static void main(String[] args)
	{
		//Example
		Question03 q3 = new Question03();
		System.out.println("Test01");
		q3.test01();
		q3.removeAreasLessThan(50.0);
		q3.print();
		
		System.out.println("\nTest02");
		q3.test02();
		q3.removeAreasLessThan(740.0);
		q3.print();
		
		System.out.println("Test03");
		q3.test03();
		q3.removeAreasLessThan(101.0);
		q3.print();
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * In this method we are removing rectangles from a list with an area less than the area in
 *  the parameter. The first thing to do was to create a method that can find the area of a given
 *  rectangle. The method getArea takes in a parameter of the type Rectangle then uses getHeight and
 *  getWidth to find the height and width and multiples them together to find the area then returns that
 *  number. Back inside the removeAreaLessThan method starts by setting the pTemp variable to null, and setting
 *  temp to head. pTemp is the previous node and since temp is set to the head the previous node will be null.
 *  There is then a while loop that will continue running while temp is not equal to null. I then created a variable
 *  called aRectangle which is of the type Rectangle and set it equal to the data at temp. There is then an else if 
 * statement where the first if statement checks to see if the temp is equal to the head and the area of aRectangle is 
 * less than the area in the parameter. If this is true then head is set to head.link and temp is set to the head.
 *  This basically removes the rectangle from the list. The next statement in the else if chain checks if the area of
 *  aRectangle is less than the given area. If this is true then pTemp.link is set to temp.link. This once again removes
 *  the data at temp and replaces it with the data in pTemp. Temp is set to temp.link to move along the list. If none of
 *  those are true then pTemp is set to temp, and temp is set to temp.link to move the iterators along.

 */
