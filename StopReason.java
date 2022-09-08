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
 * A general structure of StopReason object
 */
public class StopReason
{

///////////////////////////////////////////////Fields////////////////////////////////////////

	private String reason;
	private int stopCode;
	private String reasonText;
	private String reasonDetails;
	private String reasonExplanation;

////////////////////////////////////Constructors///////////////////////////////////

	

	public StopReason(int stopID, int pid, String reasonStop, int code, String text, String details, String explanation)
	{
		
		this.reason = reasonStop;
		this.stopCode = code;
		this.reasonText = text;
		this.reasonDetails = details;
		this.reasonExplanation = explanation;

	}

/////////////////////////////////////////////Methods///////////////////////////////////////////	

//getters for fields	
	public String getReason()
	{
		return reason;
	}

	public int getStopCode()
	{
		return stopCode;
	}

	public String getReasonText()
	{
		return reasonText;
	}

	public String getReasonDetails()
	{
		return reasonDetails;
	}

	public String getReasonExplanation()
	{
		return reasonExplanation;
	}

//setters for fields	

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public void setReasonText(String text)
	{
		this.reasonText = text;
	}

	public void setStopCode(int code)
	{
		this.stopCode = code;

	}

	public void setReasonDetails(String details)
	{
		this.reasonDetails = details;

	}

	public void setReasonExplanation(String explanation)
	{
		this.reasonExplanation = explanation;
	}

//something that the user is going to see 	
	public String toString()
	{
		return "The stop code is:" + stopCode + " which is :" + reasonText + ". In more details: " + reasonDetails
				+ ". The officer on duty explained it as:" + reasonExplanation;
	}

/* You said that From class StopReason we have to take stopID and pid. BUt in this case I won't be able to find
 * stopReason without stopID. Maybe you meant that I have to merge all the files in one arrayList with one StopId field for all data items?
 * 
 * 	
 */
	
}
