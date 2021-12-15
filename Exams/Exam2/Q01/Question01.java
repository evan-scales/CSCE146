/*
 * Evan Scales
 * CSCE 146 S2021 Exam02 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

	public static void sort(PepperoniPizza[] pizzas)
	{
//-----------------------------------------------------------------------------------	
		//Write your solution here
		int size = pizzas.length;
		if(size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		PepperoniPizza[] left = new PepperoniPizza[leftSize];
		PepperoniPizza[] right = new PepperoniPizza[rightSize];
		for(int i=0;i<mid;i++)
			left[i] = pizzas[i];
		for(int i=mid;i<size;i++)
			right[i-mid] = pizzas[i];
		sort(left);
		sort(right);
		merge(left, right, pizzas);
	}//Do not alter this
	//Write any additional helper properties or methods here
	public static void merge(PepperoniPizza[] left, PepperoniPizza[] right, PepperoniPizza[] a){
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0; //Index for left array
        int j =0;// index for right array
        int k = 0; //index for merged array aopb
        while(i < leftSize && j < rightSize){
            if(left[i] == null || right[j] == null)
                break;
            if(left[i].getPepperonis() >= right[j].getPepperonis()){
                a[k] = left[i];
                i++;
                k++;
            }
            else{
                a[k] = right[j];
                j++;
                k++;
            }
        }
        while(i<leftSize){
            a[k] = left[i];
            i++;
            k++;
        }
        while(j<rightSize){
            a[k] = right[j];
            j++;
            k++;
        }
    }

	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		PepperoniPizza[] array = {new PepperoniPizza(10),
				new PepperoniPizza(5),
				new PepperoniPizza(3),
				new PepperoniPizza(1),
				new PepperoniPizza(8),
				new PepperoniPizza(6)};
		sort(array);
		for(PepperoniPizza w : array)
			System.out.println(w);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * The sort method takes in an array of the type PepperoniPizza called pizzas. Insisde the method 
 * an integer variable called size is set to the length of the pizza. If the size is less than 2 it 
 * returns because that would mean the array only has 1 element which also makes it sorted. Three
 *  integer varaibles called mid, leftSize, and rightSize are created. Merge sort works by breaking up 
 * the array into a left and right side then sorting each side. Mid is set to size / 2, leftSize is equal
 *  to mid, and rightSize is equal to size – mid. Two arrays of the type SortCounter are created called left 
 * and right, where left has the size of leftSize and right has the size of rightSize. These arrays are populated 
 * using a for loop where the left array adds values up the the mid values, then the right array adds values from
 *  the mid value to the size value. sort is recursively called for these 2 arrays. Merge is called passing in left,
 *  right, and pizza from the sort parameter. Merge takes in the parameters left, right, and a all are PepperoniPizza 
 * arrays. leftSize and rightSize are set to the length of their respective arrays. And 3 values are created to keep 
 * index of the 3 arrays. I for left, j for right, and k for the merged array. While i and j are both less than their 
 * respective sizes if the element at index i or j in the respective arrays is null then the code breaks. It then 
 * determines which array has the most pepperonis and adds that to the merged array. Finally 2 while loops are created
 *  to add any remaining elements to the merged array. 
 */