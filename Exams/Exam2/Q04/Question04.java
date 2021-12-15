/*
 * Evan Scales
 * CSCE 146 S2021 Exam01 Question04
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 */
//Do not alter------------------------------------------------------------------------
public class Question04 
{
	private Candy[] heap = new Candy[10];
	public int size;//First null element
		
	public void add(Candy aData)
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		if(heap[heap.length-1] != null)
            return;
        heap[size] = aData;
        bubbleUp();
        size++;
	}//Do not alter

//Do not alter------------------------------------------------------------------------	
	public Candy remove()
	{
//------------------------------------------------------------------------------------	
		//Write your code here
		Candy ret = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = null;
        size--;
        bubbleDown();
        return ret;
	}//Do not alter

	//Write any additional helper properties or methods here
	private void bubbleUp(){
		int index = size;
		while (index > 0 && heap[(index-1)/2].compareTo(heap[index])>0){
			Candy temp = heap[(index-1)/2];
            heap[(index-1)/2] = heap[index];
            heap[index] = temp;
            index = (index-1)/2;
		}
	}
	private void bubbleDown(){
        int index = 0;
        while((index*2)+1 < size){
            int bigIndex = index*2+1;
            if(index*2+2 < size && heap[index*2+1].compareTo(heap[index*2+2])>0)
                bigIndex = index*2+2;
            if(heap[index].compareTo(heap[bigIndex])>0){
                Candy temp = heap[index];
                heap[index] = heap[bigIndex];
                heap[bigIndex] = temp;
            }
            else
                break;
            index = bigIndex;
        }
    }
	//--------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------

	public void printBreadthOrder()
	{
		for(Candy c : this.heap)
		{
			if(c != null)
				System.out.print(c+", ");
			else
				System.out.print("null, ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		System.out.println("Testing the Add Method");
		Candy[] array = {
				new Candy(100.0),
				new Candy(80.0),
				new Candy(60.0),
				new Candy(40.0),
				new Candy(20.0),
				new Candy(10.0),
				new Candy(30.0),
				new Candy(50.0),
				new Candy(70.0),
				new Candy(90.0)};
		Question04 heap = new Question04();
		for(Candy c : array)
			heap.add(c);
		heap.printBreadthOrder();
		
		System.out.println("Testing the Remove Method");
		for(int i=0;i<array.length;i++)
			System.out.print(heap.remove()+", ");
	}
	//--------------------------------------------------------------------------------

}//Do not alter
/*Solution Description
 * When adding an element to the heap you first check if the array is full by checking if
 *  the last index is null. If that last index is not null then the heap is full, and it is returned.
 *  Otherwise the data is added at index size, where size is originally zero because it is the first
 *  null element in the array. The method bubbleUp is called to arrange the data, then size is increased
 *  by 1. Remove works by first creating a new instance of Candy called ret and setting it equal to the 
 * heaps element at index 0. The heap at index 0 is then replaced with the last element in the heap. Size
 *  is then decreased by 1 then bubbleDown is called and ret is returned. The method bubbleUp works by
 *  swapping the information if the childs data is smaller than the parents information. This will continue 
 * until either the root index is reached or the parents data is smaller than the childs. The bubbleDown
 *  method starts by picking the smaller child. If the chosen value is smaller than the parent then the values
 *  are swapped. This is continued until the parents value is smaller or or the trees bound is reached.

 */