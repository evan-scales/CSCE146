/**
 * written by Evan Scales
 */
public class Shape implements Comparable<Shape> {
    public String type;
    public double area;
    public Shape(){
        this.type = "";
        this.area = 0.0;
    }
    public Shape(String aT, double aA){
        this.setType(aT);
        this.setArea(aA);
    }
    public String getType(){
        return this.type;
    }
    public double getArea(){
        return this.area;
    }
    public void setType(String aT){
        if(aT != null && (aT.equalsIgnoreCase("circle") || aT.equalsIgnoreCase("rectangle") || aT.equalsIgnoreCase("right triangle")))
            this.type = aT;
        else
            this.type = "";
    }
    public void setArea(double aA){
        if(aA >= 0)
            this.area = aA;
        else
            this.area = 0.0;
    }
    //public String toString(){
        //return this.type+" Area: "+this.area;
    //}
    public int compareTo(Shape aShape){
        if(aShape == null)
            return -1;
        if(this.area < aShape.getArea())
            return -1;
        else if(this.area > aShape.getArea())
            return 1;
        else
            return this.type.compareTo(aShape.getType());
    }
}