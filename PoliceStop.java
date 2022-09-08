import java.util.ArrayList;

/**
 * Lead Author(s):
 * 
 * 
 * @author Aliaksei Lenski
 * @author Eric Tyler
 * 
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors: <<add additional contributors (mentors, tutors,
 *         friends) here, with contact information>>
 *
 * 
 *         References: Starting out with Java; Java, Java, Java
 * 
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 2.0 /12/10/2020
 * 
 *         Responsibilities of class: A general structure of PoliceStop object
 *         with the methods for adding fields used in other classes
 */
public class PoliceStop
{

/////////////////////////////////////Fields///////////////////////////////////////////

	private int stopID;
	private int pid;

	private ArrayList<StopReason> stopReasonArr;
	private ArrayList<StopResult> stopResultArr;
	private ArrayList<Race> raceArr;
	private ArrayList<Gender> genderArr;

////////////////////////////Constructors/////////////////////////////////////////////

	// created a bunch of constructor in case of any combination each button or
	// checkbox selected
	public PoliceStop()
	{
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		genderArr = new ArrayList<Gender>();

	}

	public PoliceStop(int stopID, int pid, StopReason reason)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopReasonArr.add(reason);
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		genderArr = new ArrayList<Gender>();
	}

	public PoliceStop(int stopID, int pid, StopResult result)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopResultArr = new ArrayList<StopResult>();
		stopResultArr.add(result);
		stopReasonArr = new ArrayList<StopReason>();
		raceArr = new ArrayList<Race>();
		genderArr = new ArrayList<Gender>();
	}

	public PoliceStop(int stopID, int pid, Race race)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		raceArr.add(race);
		genderArr = new ArrayList<Gender>();
	}

	public PoliceStop(int stopID, int pid, Gender gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		genderArr = new ArrayList<Gender>();
		genderArr.add(gender);

	}

	public PoliceStop(int stopID, int pid, StopReason reason, Race race)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopReasonArr.add(reason);
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		raceArr.add(race);
		genderArr = new ArrayList<Gender>();
	}

	public PoliceStop(int stopID, int pid, StopReason reason, Gender gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopReasonArr.add(reason);
		stopResultArr = new ArrayList<StopResult>();
		genderArr = new ArrayList<Gender>();
		genderArr.add(gender);
		raceArr = new ArrayList<Race>();

	}

	public PoliceStop(int stopID, int pid, StopReason reason, Race race, Gender gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopReasonArr.add(reason);
		stopResultArr = new ArrayList<StopResult>();
		raceArr = new ArrayList<Race>();
		raceArr.add(race);
		genderArr = new ArrayList<Gender>();
		genderArr.add(gender);
	}

	public PoliceStop(int stopID, int pid, StopResult result, Race race)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		stopResultArr.add(result);
		raceArr = new ArrayList<Race>();
		raceArr.add(race);
		genderArr = new ArrayList<Gender>();
	}

	public PoliceStop(int stopID, int pid, StopResult result, Gender gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		stopResultArr.add(result);
		raceArr = new ArrayList<Race>();
		genderArr = new ArrayList<Gender>();
		genderArr.add(gender);
	}

	public PoliceStop(int stopID, int pid, StopResult result, Race race, Gender gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		stopResultArr = new ArrayList<StopResult>();
		stopResultArr.add(result);
		raceArr = new ArrayList<Race>();
		raceArr.add(race);
		genderArr = new ArrayList<Gender>();
		genderArr.add(gender);
	}

	public PoliceStop(int stopID, int pid, ArrayList<StopReason> reason, ArrayList<StopResult> result,
			ArrayList<Race> race, ArrayList<Gender> gender)
	{
		this.stopID = stopID;
		this.pid = pid;
		stopReasonArr = new ArrayList<StopReason>();
		this.stopReasonArr = reason;

		stopResultArr = new ArrayList<StopResult>();
		this.stopResultArr = result;

		raceArr = new ArrayList<Race>();
		this.raceArr = race;

		genderArr = new ArrayList<Gender>();

		this.genderArr = gender;

	}

////////////////////////////////Methods////////////////////////////////////////////	

//getters and setters for our fields

	public int getStopID()
	{
		return stopID;
	}

	public void setStopID(int stopID)
	{

		this.stopID = stopID;
	}

	public int getPid()
	{
		return pid;
	}

	public void setPid(int pid)
	{

		this.pid = pid;
	}

	/**
	 * A getter for the Array list of type StopReason
	 * 
	 * 
	 * @return <StopReason>
	 */
	public ArrayList<StopReason> getFullReason()
	{

		return stopReasonArr;
	}

	/**
	 * A method for adding an object to the ArrayList
	 * 
	 * 
	 * @param rsn
	 */
	public void addReason(StopReason rsn)
	{
		stopReasonArr.add(rsn);
	}

	/**
	 * A getter for the Array list of type StopResult
	 * 
	 * 
	 * @return <StopResult>
	 */
	public ArrayList<StopResult> getFullResult()
	{
		return stopResultArr;
	}

	/**
	 * A method for adding an object to the ArrayList
	 * 
	 * 
	 * @param rslt
	 */
	public void addResult(StopResult rslt)
	{
		stopResultArr.add(rslt);
	}

	/**
	 * A getter for the Array list of type Race
	 * 
	 * 
	 * @return <Race>
	 */
	public ArrayList<Race> getFullRace()
	{
		return raceArr;
	}

	/**
	 * A method for adding an object to the ArrayList
	 * 
	 * 
	 * @param rc
	 */
	public void addRace(Race rc)
	{
		raceArr.add(rc);
	}

	/**
	 * A getter for the Array list of type Gender
	 * 
	 * 
	 * @return <Gender>
	 */
	public ArrayList<Gender> getFullGender()
	{
		return genderArr;
	}

	/**
	 * A method for adding an object to the ArrayList
	 * 
	 * 
	 * @param gndr
	 */
	public void addGender(Gender gndr)
	{
		genderArr.add(gndr);
	}

	/**
	 * The method for setting the text output on the screen
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(stopID + " " + pid);
		if (stopReasonArr != null)
		{
			sb.append(stopReasonArr.toString());
		}
		if (stopResultArr != null)
		{
			sb.append(stopResultArr.toString());
		}
		if (raceArr != null)
		{
			sb.append(raceArr.toString());
		}
		if (genderArr != null)
		{
			sb.append(genderArr.toString());
		}
		return sb.toString();
	}

}
