/*
 * CSCE 146 S2021 Exam02 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Furniture 
{
	private double price;
	public Furniture(double aP)
	{
		this.setPrice(aP);
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		if(price >= 0.0)
			this.price = price;
		else
			this.price = 0.0;
	}
	public String toString()
	{
		return "Furniture $"+this.price;
	}
}
//-----------------------------------------------------------------------------------