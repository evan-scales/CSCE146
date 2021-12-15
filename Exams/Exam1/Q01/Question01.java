/*
 * Evan Scales
 * CSCE 146 S2021 Exam01 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

	public static Triangle[] largerAreaSum(Triangle[] a, Triangle[] b)
	{
//-----------------------------------------------------------------------------------	
		//Write your solution here
		if(getSum(a) > getSum(b))
			return a;
		else if(getSum(b) > getSum(a))
			return b;
		else 
			return null;
	}//Do not alter this
	//Write any additional helper properties or methods here
	//get the sum of the array
	public static double getSum(Triangle[] aT){
		double ret = 0;
		for(int i=0;i<aT.length;i++)
			ret+= (aT[i].getBase() * aT[i].getHeight() * .5);
		return ret;
	}
	
	//--------------------------------------------------------------------------------
	//Solution Tests
	public static void main(String[] args)
	{
		
		System.out.println("Test 01");
		Triangle[] triArray1 = {new Triangle(1.0, 2.0), new Triangle(3.0, 4.0), new Triangle(5.0, 6.0)};
		Triangle[] triArray2 = {new Triangle(7.0, 8.0), new Triangle(9.0, 10.0), new Triangle(11.0, 12.0)};
		
		Triangle[] largerSum = largerAreaSum(triArray1,triArray2);
		System.out.println("The triangle array with the larger area sum is: ");
		if(largerSum == null)
			System.out.println("null");
		else
			for(int i=0;i<largerSum.length;i++)
				System.out.println(largerSum[i]);
		
		System.out.println("\nTest 02");
		Triangle[] triArray3 = {new Triangle(92.0, 35.0), new Triangle(27.0, 9.0), new Triangle(83.0, 89.0)};
		Triangle[] triArray4 = {new Triangle(51.0, 11.0), new Triangle(42.0, 35.0), new Triangle(32.0, 7.0)};
		
		largerSum = largerAreaSum(triArray3,triArray4);
		System.out.println("The triangle array with the larger area sum is: ");
		if(largerSum == null)
			System.out.println("null");
		else
			for(int i=0;i<largerSum.length;i++)
				System.out.println(largerSum[i]);
		
		System.out.println("\nTest 03");
		Triangle[] triArray5 = {new Triangle(1.0, 1.0), new Triangle(1.0, 1.0), new Triangle(1.0, 1.0)};
		Triangle[] triArray6 = {new Triangle(1.0, 1.0), new Triangle(1.0, 1.0), new Triangle(1.0, 1.0)};
		
		largerSum = largerAreaSum(triArray5,triArray6);
		System.out.println("The triangle array with the larger area sum is: ");
		if(largerSum == null)
			System.out.println("null");
		else
			for(int i=0;i<largerSum.length;i++)
				System.out.println(largerSum[i]);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * To find the array with the larger sum of areas it is first important to find the sum. I made a method 
 * called getSum that takes in a parameter array of the type Triangle. In the method a variable of the type
 *  double called ret is created and set to 0. The method then enters a for loop where i = 0, i is less than
 *  the parameters length, and i goes up by 1. Inside the for loop at index i getBase and getHeight are used
 *  from the Triangle class to find the base and height and that is multiplied by .5 to find the area of a triangle. 
 * That area is then added to ret and at the end of the method ret is returned. This method is then implemented in the 
 * largerAreaSum method to compare the sums. There is an else if statement where it will compare the sums of the arrays.
 *  If the sum for array a is larger than b then a is returned, and if b is bigger then b is returned. Finally there is 
 * an else statement that will just return null.
 */