/*
 * Written by Evan Scales
 */
//Packages
import java.util.Scanner;
import java.util.Random;;
//Do not alter-----------------------------------------------
public class BubbleSorter {
    //-----------------------------------------------------------
        public static final int ARRAY_SIZE = 10;
    //Do not alter-----------------------------------------------
        public static void main(String[] args) {
    //-----------------------------------------------------------
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter "+ARRAY_SIZE+" numbers and I'll sort them");
            int[] array = new int[ARRAY_SIZE];
            for(int i=0;i<array.length;i++){
                System.out.println("Enter value "+i);
                array[i] = keyboard.nextInt();
            }
            //bubble sort
            boolean hasSwapped = true;
            while(hasSwapped){
                hasSwapped = false;
                for(int i=0;i<array.length-1;i++){
                    if(array[i] > array[i+1]){
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        hasSwapped = true; 
                    } 
                }
            }
            //print shit
            for(int i=0;i<array.length;i++)
                System.out.println(array[i]);
        }//Do not alter
    
    }//Do not alter