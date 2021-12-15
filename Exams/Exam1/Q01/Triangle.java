/*
 * CSCE 146 S2021 Exam01 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Triangle 
{
	private double base;
	private double height;
	
	public Triangle(double aB, double aH)
	{
		this.setBase(aB);
		this.setHeight(aH);
	}

	public double getBase() 
	{
		return base;
	}

	public void setBase(double base) 
	{
		if(base > 0.0)
			this.base = base;
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
		return "Triangle with Base: "+this.base+" Height: "+this.height;
	}
	
}
//Do not alter-----------------------------------------------------------------------
