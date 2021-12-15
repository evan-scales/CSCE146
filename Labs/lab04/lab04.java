S/**
 * written by evan scales
 */
import java.util.*;
public class lab04 {
    public static final int SIZE = 5;
    public static final int RANGE = 100;
    public static void main(String[] args) {
        System.out.println("Welcome to the sum of all combinations program!");
        int[] a = new int[SIZE];
        populateRandomArray(a);
        //int[] a = {1,2,3,4,5};
        sumAndPrintComb(a);
    }
    public static void populateRandomArray(int[] a){
        Random r = new Random();
        System.out.print("Given array = {");
        for(int i=0;i<a.length;i++){
            a[i] = r.nextInt(RANGE);
            System.out.print(a[i]+" ");
        }
        System.out.println("}, all summed combintations are: ");
    }
    public static void sumAndPrintComb(int[] a){
        sumAndPrintComb(a, new int[1], 0, 1);
    }
    public static void sumAndPrintComb(int[] a, int[] workingArray, int currI, int currD){
        if(currI >= a.length || currD > a.length)
            return;
        int[] c = new int[currD];
        for(int i=0;i<workingArray.length;i++){
            c[i] = workingArray[i];
        }
        c[c.length-1] = a[currI];
        print(c);
        sumAndPrintComb(a, c, currI+1, currD+1);
        sumAndPrintComb(a, c, currI+1, currD);
    }
    public static void print(int[] a){
        System.out.print(a[0]);
        for(int i=1;i<a.length;i++)
            System.out.print(" + " + a[i]);
        System.out.println(" = " + sum(a));
    }
    public static int sum(int[] a){
        int ret = 0;
        for(int i=0;i<a.length;i++)
            ret+=a[i];
        return ret;
    }
}