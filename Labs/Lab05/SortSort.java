iiS/**
 * Evan Scales
 */
import java.util.Scanner;
public class SortSort {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        Scanner keybaord = new Scanner(System.in);
        SortCounter[] sorts = new SortCounter[SIZE];
        System.out.println("Enter any number of string and I will sort by sorts. Once youre done enter \"quit\"");
        String input = "";
        int count = 0;
        while(count < SIZE){
            input = keybaord.nextLine();
            if(input.equalsIgnoreCase("quit"))
                break;
            sorts[count] = new SortCounter(input);
            count++;
        }
        mergeSort(sorts);
        System.out.println("Sort SORTED!");
        for(SortCounter s : sorts){
            if(s == null)
                break;
            System.out.println(s.getStr());
        }
    }
    public static void mergeSort(SortCounter[] sortArray){
        int size = sortArray.length;
        if(size < 2)
            return;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        SortCounter[] left = new SortCounter[leftSize];
        SortCounter[] right = new SortCounter[rightSize];
        for(int i=0;i<mid;i++)
            left[i] = sortArray[i];
        for(int i=mid;i<size;i++)
            right[i-mid] = sortArray[i];
        mergeSort(left);
        mergeSort(right);
        merge(left, right, sortArray);
    }
    public static void merge(SortCounter[] left, SortCounter[] right, SortCounter[] a){
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0; //Index for left array
        int j =0;// index for right array
        int k = 0; //index for merged array a
        while(i < leftSize && j < rightSize){
            if(left[i] == null || right[j] == null)
                break;
            if(left[i].getNumOfSorts() <= right[j].getNumOfSorts()){
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
}