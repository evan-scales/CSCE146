/**
 * written by Evan Scales
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class DrawTriangle extends Canvas{
    public static final int SIZE = 900;
    public static void main(String[] args) {
        JFrame frame = new JFrame("triangle");
        frame.setSize(SIZE,SIZE);
        DrawTriangle triangle = new DrawTriangle();
        frame.add(triangle);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g){
       drawOGTriangle(g);
    }
    public void drawOGTriangle(Graphics g){
        //find the side of the triangle, height, and the width 
        double sub = SIZE * .5; 
        double height = sub * Math.sin(Math.toRadians(60)); //finds the height of the triangle in order to make it equilateral
        double width = this.getSize().width;
        
        //first 3 points
        Point p1 = new Point((width/2),0); //upper point
        Point p2 = new Point((width/2)+(sub/2),height); //bottom right point
        Point p3 = new Point((width/2)-(sub/2),height); //bottom left point
        
        //put the cords of the 3 points into its cord arrays
        int[] xPoints = {p1.getX(), p2.getX(), p3.getX()};
        int[] yPoints = {p1.getY(), p2.getY(), p3.getY()};

        g.setColor(Color.BLACK);
        g.fillPolygon(xPoints, yPoints, 3);

        drawTriangle(p1, p2, p3, sub/2, g);
    }
    public void drawTriangle(Point p1, Point p2, Point p3, double sub, Graphics g){
        if(sub >= 4){
            //find the midpoint to draw next triangle
            Point midPoint1 = new Point((p2.getX()+p3.getX())/2, (p2.getY()+p3.getY())/2); //between bottom left and bottom right point
            Point midPoint2 = new Point((p1.getX()+p3.getX())/2, (p1.getY()+p3.getY())/2); //between upper and bottom left point
            Point midPoint3 = new Point((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2); //between upper and bottom right point

            int[] xPoints = {midPoint1.getX(), midPoint2.getX(), midPoint3.getX()};
            int[] yPoints = {midPoint1.getY(), midPoint2.getY(), midPoint3.getY()};

            g.setColor(Color.PINK);
            g.fillPolygon(xPoints, yPoints, 3);

            drawTriangle(p1, midPoint2, midPoint3, sub/2, g); //upper triangle
            drawTriangle(p3, midPoint2, midPoint1, sub/2, g); //bottom right triangle
            drawTriangle(p2, midPoint1, midPoint3, sub/2, g); //bottom left triangle
        }

        
    }
}