/*
 * Evan Scales
 * CSCE 146 S2021 Exam01 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question02 
{
	public class ListNode//public for testing purposes
	{
		public String data;//public for testing purposes
		public ListNode link;//public for testing purposes
		public ListNode(String aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//public for testing purposes
	public int getVowelCount()
	{
//-----------------------------------------------------------------------------------
		//Write your solution here
		int ret = 0;
		ListNode currNode = head;
		while(currNode != null){
			String aString = currNode.data.toLowerCase();
			for(int i=0;i<aString.length();i++){
				if(aString.charAt(i) =='a' || aString.charAt(i) == 'e' || aString.charAt(i) == 'i' ||
                aString.charAt(i) == 'o' || aString.charAt(i) == 'u')
                    ret++;
			}
			currNode = currNode.link;
		}
		return ret;
	}//Do not alter this
	//Write additional methods or properties here
			
	//--------------------------------------------------------------------------------
	//Solution Tests
	public void test01()
	{
		head = new ListNode("aaaa",
					new ListNode("bbbb",
						new ListNode("CCCC",
							new ListNode("dddd",
								new ListNode("EeEe",null)))));
	}
	public void test02()
	{
		head = new ListNode("hey",
					new ListNode("Everyone",
						new ListNode("HOW",
							new ListNode("goes",
								new ListNode("IT",null)))));
	}
	public void test03()
	{
		head = new ListNode("R",
					new ListNode("S",
						new ListNode("T",
							new ListNode("L",
								new ListNode("N",null)))));
	}
	public static void main(String[] args)
	{
		//Example
		System.out.println("Test01");
		Question02 q2 = new Question02();
		q2.test01();
		int vowelCount = q2.getVowelCount();
		System.out.println(vowelCount);
		
		System.out.println("\nTest02");
		q2.test02();
		vowelCount = q2.getVowelCount();
		System.out.println(vowelCount);
		
		System.out.println("\nTest03");
		q2.test03();
		vowelCount = q2.getVowelCount();
		System.out.println(vowelCount);
		//Printing Results
		
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * To get the vowel count a variable called ret of the type integer is created and set to 0. Since this
 *   method will iterate through multiple items in a list the method needs to be iterable. This is done by
 *  creating currNode and setting it to head. There is then a while loop that will continue running as long as
 *  currNode is not equal to null. A variable called aString of the type string is created and is set to the
 *  data at currNode, it is also converted to all lowercase for the purpose of finding the vowels easier. A
 *  for loop is created where i = 0, and it will continue running as long as i is less than the length of aString,
 *  and i goes up by 1. There is an if statement in the for loop that checks if the character at index i is equal 
 * to a, e, i, o, or u. If there are any matches then ret goes up by 1. Outside the for loop but inside the while
 *  loop currNode is set to the next node, this makes the list iterable. Finally at the end of the method outside
 *  the while loop ret is returned.
 */
