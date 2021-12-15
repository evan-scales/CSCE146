/**
 * written by Evan Scales
 */
import java.util.*;
import java.io.*;
public class FruitTreeTester {

    public static void main(String[] args) {
        System.out.println("Welcome to the fruit tree!\nPlease enter a fruit file name.");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        System.out.println("Populating tree file");

        LinkedBST<Fruit> fruitTree = new LinkedBST<Fruit>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while(fileScanner.hasNextLine()){
                String currentLine = fileScanner.nextLine();
                String[] splitLine = currentLine.split("\t");
                if(splitLine.length == 2){
                    Fruit f = new Fruit(Double.parseDouble(splitLine[1]), splitLine[0]);
                    fruitTree.add(f);
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Print the in-order traversal");
        fruitTree.printInOrder();
        System.out.println("\nPrint the pre-order traversal");
        fruitTree.printPreOrder();
        System.out.println("\nPrint the post-order traversal");
        fruitTree.printPostOrder();
        System.out.println(fruitTree.search(new Fruit(0.4859853412170728, "Apple")));
        System.out.println("\nDeleting Apple     0.4859853412170728");
        fruitTree.remove(new Fruit(0.4859853412170728, "Apple"));
        System.out.println("Printing in-order traversal");
        fruitTree.printInOrder();
    }
}