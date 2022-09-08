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
 *         Responsibilities of class: A general structure of Race object
 */

public class Race
{

///////////////////////////////////////fileds///////////////////////////////////////////

	private String race;

/////////////////////////////////Constructors//////////////////////////////////////////

	public Race()
	{

	}

	public Race(int stopID, int pid, String race)
	{
		this.race = race;

	}

///////////////////////////////////Methods////////////////////////////////////////////

	/**
	 * finding an element inside of a Race object
	 * 
	 * @return race
	 */

	public String getRace()
	{
		return race;
	}

	/*
	 * general toString for the output
	 */

	public String toString()
	{
		return "The race of a person was " + race;
	}

}
