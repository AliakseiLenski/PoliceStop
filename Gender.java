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
 *         Responsibilities of class: A general structure of Gender object
 */

public class Gender
{

/////////////////////////////////////////fields///////////////////////////////////////////////

	private String gender;

////////////////////////////////Constructors//////////////////////////////////////////////////	

	public Gender()
	{

	}

	public Gender(int stopID, int pid, String gender)
	{

		this.gender = gender;

	}

///////////////////////////////Methods/////////////////////////////////////////////////////////

	/**
	 * finding an element insied of a Gender object
	 * 
	 * @return gender
	 */

	public String getGender()
	{
		return gender;
	}

	/*
	 * general toString for the output
	 */

	public String toString()
	{
		return "The person was a " + gender;
	}

}
