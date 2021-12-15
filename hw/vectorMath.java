/**
 * written by Evan Scales
 */
import java.util.Scanner;
public class vectorMath {

    public static void main(String[] args) {
        vectorMath v = new vectorMath();
        v.start();
        System.out.println("Goodbye!");
    }
        //start method
        public void start(){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Welcome to the Vector Operations Program!");
            boolean quit = false;
            while(!quit){
                printGreetings();
                int choice = keyboard.nextInt();
                if(choice == 1 || choice == 2){
                    //build array
                    System.out.println("Enter the size of the vectors");
                    int vectorSize = keyboard.nextInt();
                    if(vectorSize <= 0){
                        System.out.println("Invalid Input. Please try again");
                        continue;
                    }
                    double[] vector1 = new double[vectorSize];
                    double[] vector2 = new double[vectorSize];
                    for(int i = 0;i<2;i++){
                        System.out.println("Enter values for vector"+(i+1));
                        for(int j = 0;j<vectorSize;j++){
                            double value = keyboard.nextDouble();
                            if(i == 0)
                                vector1[j] = value;
                            else
                                vector2[j] = value;
                        }
                    }
                    //do the stuff
                    if(choice == 1){
                        printResults(vector1, vector2, vectorSize, "+");
                        addVectors(vector1, vector2, vectorSize);
                    }
                    else if(choice == 2){
                        printResults(vector1, vector2, vectorSize, "-");
                        subtractVectors(vector1, vector2, vectorSize);
                    }
                }
                else if(choice == 3){
                    //build array
                    System.out.println("Enter the size of the vector");
                    int vectorSize = keyboard.nextInt();
                    if(vectorSize <= 0){
                        System.out.println("Invalid Input. Please try again");
                        continue;
                    }
                    double[] vector = new double[vectorSize];
                    System.out.println("Enter the values for the vector");
                    for(int i = 0;i<vectorSize;i++)
                        vector[i] = keyboard.nextDouble();
                    System.out.println("The magnitude is: "+findMag(vector, vectorSize));
                    
                }
                else if(choice == 9){
                    quit = true;
                }
                else{
                    System.out.println("Invalid Input. Please try again");
                    continue;
                }          

            }
        }
        //methd for adding vectors
        public void addVectors(double[] vector1, double[] vector2, int size){
            for(int i = 0;i<size;i++){
                System.out.println(vector1[i]+vector2[i]);
            }
        }
        //method for subtracting methods
        public void subtractVectors(double[] vector1, double[] vector2, int size){
            for(int i = 0;i<size;i++){
                System.out.println(vector1[i]-vector2[i]);
            }
        }
        //method for finding the magnitude of a vector
        public double findMag(double[] vector, int size){
            double ret = 0;
                for(int i = 0;i<size;i++){
                    ret += Math.pow(vector[i], 2);
                }
            return Math.sqrt(ret);
        }
        //method for results
        public void printResults(double[] vector1, double[] vector2, int size, String word){
            System.out.println("Result:");
            for(int i = 0;i<size;i++)
                System.out.println(vector1[i]);
            System.out.println(word);
            for(int i = 0;i<size;i++)
                System.out.println(vector2[i]);
            System.out.println("=");
        }
        //method for welcome thing
        public void printGreetings(){
            System.out.println("Enter 1. To Add 2 Vectors");
            System.out.println("Enter 2. To Subtract 2 Vectors");
            System.out.println("Enter 3. To Find the Magnitude of a Vector");
            System.out.println("Enter 9. To Quit");
        }
}