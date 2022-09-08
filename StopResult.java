/**
 * Lead Author(s):


 * @author Aliaksei Lenski
 * @author Eric Tyler
 * 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 *
 * 
 * References:
 * Starting out with Java; Java, Java, Java 
 * 
 * 
 * <<add more references here>>
 *  
 * Version/date: 2.0 /12/10/2020
 * 
 * Responsibilities of class:
 * A general structure of StopResult object
 */
public class StopResult
{

	private int resultKey;
	private String result;
	private int code;
	private String resultText;

	

	public StopResult(int stopID, int pid, int key, String result1, int codeResult, String text)
	{
		this.resultKey = key;
		this.result = result1;
		this.code = codeResult;
		this.resultText = text;

	}

//getters and setters of the fields

	public int getResultKey()
	{
		return resultKey;

	}

	public String getResult()
	{
		return result;
	}

	public int getCode()
	{
		return code;
	}

	public String getResultText()
	{
		return resultText;
	}

	public void setResultKey(int resultKey)
	{
		this.resultKey = resultKey;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public void setResultText(String resultText)
	{
		this.resultText = resultText;
	}

//something that the user is going to see 
	public String toString()
	{
		return " The result of stop was: " + result + " Stop Key = " + resultKey + " The code of the reuslt is = "
				+ code + " The officer wrote: " + resultText;
	}
}
