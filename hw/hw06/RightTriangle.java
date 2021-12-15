/**
 * written by Evan Scales
 */
public class RightTriangle extends Shape{
    public double base, height;
    public RightTriangle(){
        this.base = 0;
        this.height = 0;
    }
    public RightTriangle(double aB, double aH){
        super();
        this.base = aB;
        this.height = aH;
        super.area = this.base*this.height*.5;
        super.type = "Right Triangle";
    }
    @Override
    public String toString(){
        return "Right Triangle Side 1: "+this.base+" Side 2: "+this.height+" Area: "+super.area; 
    }
}