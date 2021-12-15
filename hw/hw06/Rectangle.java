/**
 * written by Evan Scales
 */
public class Rectangle extends Shape{
    public double side1, side2;
    public Rectangle(){
        this.side1 = 0.0;
        this.side2 = 0.0;
    }
    public Rectangle(double s1, double s2){
        super();
        this.side1 = s1;
        this.side2 = s2;
        super.type = "Rectangle";
        super.area = this.side1*this.side2;
    }
    public double getSide1() {
        return side1;
    }
    @Override
    public String toString(){
        return "Rectangle Side 1: "+this.side1+" Side 2: "+this.side2+" Area: "+super.area;
    }
    
}