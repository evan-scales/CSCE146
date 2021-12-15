/*
 * CSCE 146 S2021 Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Rectangle 
{
	private double width;
	private double height;
	
	public Rectangle(double aW, double aH)
	{
		this.setWidth(aW);
		this.setHeight(aH);
	}

	public double getWidth() 
	{
		return width;
	}

	public void setWidth(double width) 
	{
		if(width > 0.0)
			this.width = width;
	}

	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) 
	{
		if(height > 0.0)
			this.height = height;
	}
	public String toString()
	{
		return "Rectangle with Width: "+this.width+" Height: "+this.height;
	}
	
}
//Do not alter-----------------------------------------------------------------------
