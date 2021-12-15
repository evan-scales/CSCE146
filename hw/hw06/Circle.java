/**
 * written by Evan Scales
 */
public class Circle extends Shape{
    public double radius;
    public Circle(){
        this.radius = 0.0;
    }
    public Circle(double aR){
        super();
        this.radius = aR;
        super.area = this.radius*this.radius*Math.PI;
        super.type = "Circle";
    }
    @Override
    public String toString(){
        return "Circle Radius: "+this.radius+" Area: "+super.area;
    }
    
}