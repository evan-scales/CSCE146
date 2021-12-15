/**
 * written by Evan Scales
 */
import java.util.*;
import java.io.*;
public class ShapeTester {

    public static void main(String[] args) {
        System.out.println("Welcome to the shape tree tester!\nEnter a shape file name");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        LinkedBST<Shape> shapes = new LinkedBST<Shape>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while(fileScanner.hasNextLine()){
                String currentLine = fileScanner.nextLine();
                String[] splitLine = currentLine.split("\t");
                if(splitLine[0].equalsIgnoreCase("Rectangle")){
                    Rectangle rectangle = new Rectangle(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
                    //Shape newShape = new Shape(rectangle.getType(), rectangle.getArea());
                    shapes.add(rectangle);
                    System.out.println(currentLine);
                }
                else if(splitLine[0].equalsIgnoreCase("Right Triangle")){
                    RightTriangle triangle = new RightTriangle(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
                    //Shape newShape = new Shape(triangle.getType(), triangle.getArea());
                    shapes.add(triangle);
                    System.out.println(currentLine);
                }
                else if(splitLine[0].equalsIgnoreCase("Circle")){
                    Circle circle = new Circle(Double.parseDouble(splitLine[1]));
                    //Shape newShape = new Shape(circle.getType(), circle.getArea());
                    shapes.add(circle);
                    System.out.println(currentLine);
                }
                else
                    System.out.println("Not properly formatted line. Yes you should check for these.  Not intentionally causing a kerfuffle");
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("\nPrinting pre-order");
        shapes.printPreOrder();
        System.out.println("\nPrinting in-order");
        shapes.printInOrder();
        System.out.println("\nPrinting post-order");
        shapes.printPostOrder();

        System.out.println("\nThe max area is: "+shapes.findMaxInTree());
        System.out.println("\nDeleting Rectangle Side 1: 2.0 Side 2: 7.0 Area: 14.0\nPrinting in-order");
        shapes.remove(new Rectangle(2, 7));
        shapes.printInOrder();
        System.out.println("\nDeleting values larger than 30\nPrinting in-order");
        shapes.deleteAreaGreaterThan(30);
        shapes.printInOrder();
    }
}