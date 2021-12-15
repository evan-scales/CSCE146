/*
 * CSCE 146 S2021 Exam02 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class PepperoniPizza 
{
	private int pepperonis;
	public PepperoniPizza(int aP)
	{
		this.setPepperonis(aP);
	}
	public int getPepperonis() 
	{
		return pepperonis;
	}
	public void setPepperonis(int pockets) 
	{
		if(pockets >= 1)
			this.pepperonis = pockets;
		else
			this.pepperonis = 1;
	}
	public String toString()
	{
		return "Pizza with "+this.pepperonis+" pepperonis";
	}
}
//-----------------------------------------------------------------------------------	