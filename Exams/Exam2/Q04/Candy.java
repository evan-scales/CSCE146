/*
 * CSCE 146 S2021 Exam02 Question04
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Candy implements Comparable<Candy>
{
	private double weight;
	public Candy(double aW)
	{
		this.setWeight(aW);
	}
	public double getWeight() 
	{
		return weight;
	}
	public void setWeight(double weight) 
	{
		if(weight > 0.0)
			this.weight = weight;
		else
			this.weight = 1.0;
	}
	public String toString()
	{
		return "Candy Weight: "+this.weight;
	}
	public int compareTo(Candy aC)
	{
		if(aC == null)
			return 1;
		else if(this.weight > aC.getWeight())
			return 1;
		else if(this.weight < aC.getWeight())
			return -1;
		else
			return 0;
	}
}
//-----------------------------------------------------------------------------------