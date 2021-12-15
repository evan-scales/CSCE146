/*
 * CSCE 146 S2021 Exam02 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Book
{
	private int wordCount;
	public Book()
	{
		this.wordCount = 1;
	}
	public Book(int aC)
	{
		this.setWordCount(aC);
	}
	public int getWordCount()
	{
		return this.wordCount;
	}
	public void setWordCount(int aC)
	{
		if(aC > 0)
			this.wordCount = aC;
		else
			this.wordCount = 1;
	}
	public String toString()
	{
		return "Book with "+this.wordCount+" words";
	}
}
//-----------------------------------------------------------------------------------