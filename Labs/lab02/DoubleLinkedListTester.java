/*
 * Written by JJ Shepherd
 */
public class DoubleLinkedListTester {
	public static final double[] TEST_VALS_1 = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
	public static final double[] TEST_VALS_2 = {1.0,3.0,4.0,5.0,6.0,7.0,8.0};
	public static final double[] TEST_VALS_3 = {1.0,3.0,-4.0,5.0,-6.0,7.0,-8.0};
	
	public static final String DEC = "------------------------------------------------------\n";
	public static void main(String[] args) {
		printDecorated("Double Double Linked List Tester");
		DoubleDoubleLL ddList = new DoubleDoubleLL();

		System.out.println("SUCCESS: "+insertAndContainsTest(ddList)+"\n");
		System.out.println("SUCCESS: "+deleteTest(ddList)+"\n");
		System.out.println("SUCCESS: "+modifyingValuesTest(ddList)+"\n");
		
		printDecorated("Printing the list");
		ddList.print();
		
		ddList.gotoEnd();
		System.out.println("Print last element: "+ddList.getCurrent());
	}
	
	public static boolean insertAndContainsTest(DoubleDoubleLL ddList)
	{
		printDecorated("Inserting and Contains Test");
		for(int i=0;i<TEST_VALS_1.length;i++)
			ddList.add(TEST_VALS_1[i]);
		return valuesMatch(ddList,TEST_VALS_1);
	}
	public static boolean deleteTest(DoubleDoubleLL ddList)
	{
		printDecorated("Removing Test\nRemoving first item, third item, and last item");
		ddList.reset();
		ddList.removeCurrent();
		
		ddList.gotoNext();
		ddList.removeCurrent();
		
		while(ddList.hasMore())
		{
			ddList.gotoNext();
		}
		ddList.removeCurrent();
		return valuesMatch(ddList,TEST_VALS_2);
	}
	public static boolean modifyingValuesTest(DoubleDoubleLL ddList)
	{
		printDecorated("Modified Values Test\nChanging all even values to negative values");
		ddList.reset();
		while(ddList.hasMore())
		{
			if(ddList.getCurrent() % 2 == 0)
				ddList.setCurrent(-ddList.getCurrent());
			ddList.gotoNext();
		}
		return valuesMatch(ddList,TEST_VALS_3);
	}
	public static boolean valuesMatch(DoubleDoubleLL ddList, double[] testVals)
	{
		for(int i=0;i<testVals.length;i++)
			if(!ddList.contains(testVals[i]))
				return false;
		return true;
	}
	public static void printDecorated(String str)
	{
		System.out.println(DEC+str+"\n"+DEC);
	}
}