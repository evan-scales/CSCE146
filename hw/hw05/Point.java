/**
 * written by Evan Scales
 */
public class Point {
    double x;
    double y;
    public Point(double xPoint, double yPoint){
        this.x = xPoint;
        this.y = yPoint;
    }
    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }
    public void setX(double xPoint){
        this.x = xPoint;
    }
    public void setY(double yPoint){
        this.y = yPoint;
    }
    
}