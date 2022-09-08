import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
 * A class designed for reading necessary files and passing their data into the PoliceStop array list
 *  Also multiple methods about searching objects by stopID in these array lists 
 */
public class FileWork
{

//	declaring  ArrayLists of object on a class level	
	private ArrayList<PoliceStop> policeStopArr;
	
	

	public FileWork()
	{
//		in a constructor creating an ArrayList where all the data from the files is going to be passed
		policeStopArr = new ArrayList<PoliceStop>();
		readReason("C:/Users/Aliaksei/Documents/PoliceStopDatabase/ripa_stop_reason_datasd.csv");
		readResult("C:/Users/Aliaksei/Documents/PoliceStopDatabase/ripa_stop_result_datasd.csv");
		readRace("C:/Users/Aliaksei/Documents/PoliceStopDatabase/ripa_race_datasd.csv");
		readGender("C:/Users/Aliaksei/Documents/PoliceStopDatabase/ripa_gender_datasd.csv");
		
	}
		

	// tool dividing rows of our data tables on columns, separating columns with
	// commas

	public static final String delimiter = ",";

	/**
	 * purpose : read the StopReason file
	 * 
	 * 
	 * 
	 * @param: String
	 * @return: void
	 * 
	 */

	public void readReason(String csvFile)
	{
		try
		{
			File file = new File(csvFile); // new file
			Scanner sc = new Scanner(file);

			String line = "";

			String[] tempArr; // A new String Array created for our objects (must write a method to parse
								// String to int for particular variables
			boolean isHeader = true; // keep true if the first line is a header
//         initializing some variables of the array	that earlier caused an error or an exception to later catch an exception
			int stopID = 0;
			int pid = 0;
			String reason = "";
			int code = 0;
			String text = "";
			String detail = "";
			String explanation = "";
			
			while (sc.hasNextLine()) // while there is a next line of the scanner of object to read
			{
				
				line = sc.nextLine();
				
				if (!isHeader) // if not the first line (headers)
				{
					tempArr = line.split(delimiter); // splitting each line in my data table on separated objects with
														// the comma

					try
					{
//	    	   	I used IfNull for every single element of the array in case if any of them is null
//	    	    I used Integer.parseInt to convert the value of an element from String to int
//	    	   	I used replace to remove " element  where it created an exception	
						stopID = Integer.parseInt(ifNull(tempArr[0]).replace("\"",""));
						pid = Integer.parseInt(ifNull(tempArr[1]).replace("\"",""));
						reason = ifNull(tempArr[2]);
						if (tempArr[3].length()==0) tempArr[3]="0";
						code = Integer.parseInt(tempArr[3]);//.replace("\"",""));
						text = ifNull(tempArr[4]);
						detail = ifNull(tempArr[5]);
						explanation = ifNull(tempArr[6]);

					} catch (Exception e)
						
					{
						stopID = 0;
						pid = 0;
						code = 0;
						e.printStackTrace();
						
					}

//				adding a new object to the ArrayList
					int stopIDIndex = findStopIDIndex(stopID);
				
					if(stopIDIndex >= 0)
					{
						policeStopArr.get(stopIDIndex).addReason(new StopReason(stopID, pid, reason, code, text, detail, explanation));
					}
					else {
						StopReason sr = new StopReason(stopID, pid, reason, code, text, detail, explanation);
						
						PoliceStop ps = new PoliceStop(stopID, pid, sr);
						
						policeStopArr.add(ps);
						
					}
					
					
				}
				else
				{
					isHeader = false;
				}	
			}
			sc.close();
			
		}

//	    catching IOException

		catch (IOException io)
		{
			io.printStackTrace();
		}

	}

	/**
	 * purpose : read the StopResult file
	 * 
	 * 
	 * 
	 * @param: String
	 * @return: void
	 * 
	 */

	public  void readResult(String csvFile)
	{
		Scanner sc = null;
		try
		{
			File file = new File(csvFile); // new file
			 sc = new Scanner(file);
			String line = "";
			String[] tempArr; // A new String Array created for our objects (must write a method to parse
								// String to int for particular variables
			boolean isHeader = true; // true if the first line exists
//         initializing variables of the array	       
			int stopID = 0;
			int pid = 0;
			int key = 0;
			int code = 0;
			String result = "";
			String resultText = "";
//			int i=0;
			while (sc.hasNextLine()) // while there is a line of the arrayList of object to read
			{

				line = sc.nextLine();
				
				if (!isHeader)// if not the first line (headers)
				{
					
					tempArr = line.split(delimiter); // splitting each line in my data table on separated objects with
														// the comma
					
					try
					{
//	    	   	I used IfNull for every single element of the array in case if any of them is null
//	    	    I used Integer.parseInt to convert the value of an element from String to int
//	    	   	I used replace to replace " element with the empty field where it created an exception
						stopID = Integer.parseInt(ifNull(tempArr[0]).replace("\"", ""));
						pid = Integer.parseInt(ifNull(tempArr[1]).replace("\"", ""));
						key = Integer.parseInt(ifNull(tempArr[2]).replace("\"", ""));
						result = ifNull(tempArr[3]);
						if (tempArr.length > 4) 
						{
						code = Integer.parseInt(ifNull(tempArr[4]).replace("\"", ""));
						resultText = ifNull(tempArr[5]);
						}
					} catch (Exception e) // caught multiple exceptions
					{	
						stopID = 0;
						pid = 0;
						key = 0;
						code = 0;
						e.printStackTrace();
					}

					
					int stopIDIndex = findStopIDIndex(stopID);
					if(stopIDIndex >= 0)
					{
						StopResult rslt = new StopResult(stopID, pid, key, result, code, resultText);
						PoliceStop police = policeStopArr.get(stopIDIndex);
						
						police.addResult(rslt);
					}
					else policeStopArr.add(new PoliceStop(stopID, pid, new StopResult(stopID, pid, key, result, code, resultText)));			
					
			}
				else
			{
				isHeader = false;
			}	
				
			}
			sc.close();
		}

//	    catching a printStackTrace Exception

		catch (IOException io)
		{
			io.printStackTrace();
		} 
			sc.close();
		

	}

	

	/**
	 * checking for null in our ArrayList or if one of the variables of the
	 * ArrayList is missing
	 * 
	 * 
	 * @param val
	 * @return empty String line or val
	 */

	public static String ifNull(String val)
	{
		if (val.equals(null))
			return "";
		else
			return val;

	}
	/**
	 * purpose : read the Race file
	 * 
	 * 
	 * 
	 * @param: String
	 * @return: void
	 * 
	 */
	public void readRace(String csvFile)
	{
		try
		{
			File file = new File(csvFile); // new file
			Scanner sc = new Scanner(file);

			String line = "";

			String[] tempArr; // A new String Array created for our objects (must write a method to parse
								// String to int for particular variables
			boolean isHeader = true; // keep true if the first line is a header
//         initializing some variables of the array	that earlier caused an error or an exception to later catch an exception
			int stopID = 0;
			int pid = 0;
			String race = "";
//			int i = 0;
			while (sc.hasNextLine()) // while there is a next line of the scanner of object to read
			{

				line = sc.nextLine();
				if (!isHeader) // if not the first line (headers)
				{
					tempArr = line.split(delimiter); // splitting each line in my data table on separated objects with
														// the comma

					try
					{
//	    	   	I used IfNull for every single element of the array in case if any of them is null
//	    	    I used Integer.parseInt to convert the value of an element from String to int
//	    	   	I used replace to remove " element  where it created an exception	
						stopID = Integer.parseInt(ifNull(tempArr[0]).replace("\"", ""));
						pid = Integer.parseInt(ifNull(tempArr[1]).replace("\"", ""));
						race = ifNull(tempArr[2]);

					} catch (Exception e)
					{
						stopID = 0;
						pid = 0;

					}

//				adding a new object to the ArrayList
					
					int stopIDIndex = findStopIDIndex(stopID);
					if(stopIDIndex >= 0)
					{
						
						Race rc = new Race(stopID, pid, race);
						
						policeStopArr.get(stopIDIndex).addRace(rc);
					
					}
					else policeStopArr.add(new PoliceStop(stopID, pid, new Race(stopID, pid, race)));					

				} else
				{
					isHeader = false;
				}
			}
			sc.close();
		}

//	    catching IOException

		catch (IOException io)
		{
			io.printStackTrace();
		}

	}
	/**
	 * purpose : read the Gender file
	 * 
	 * 
	 * 
	 * @param: String
	 * @return: void
	 * 
	 */
	public void readGender(String csvFile)
	{
		try
		{
			File file = new File(csvFile); // new file
			Scanner sc = new Scanner(file);

			String line = "";

			String[] tempArr; // A new String Array created for our objects (must write a method to parse
								// String to int for particular variables
			boolean isHeader = true; // keep true if the first line is a header
//         initializing some variables of the array	that earlier caused an error or an exception to later catch an exception
			int stopID = 0;
			int pid = 0;
			String gender = "";
			while (sc.hasNextLine()) // while there is a next line of the scanner of object to read
			{
				line = sc.nextLine();
				if (!isHeader) // if not the first line (headers)
				{
					tempArr = line.split(delimiter); // splitting each line in my data table on separated objects with
														// the comma

					try
					{
//	    	   	I used IfNull for every single element of the array in case if any of them is null
//	    	    I used Integer.parseInt to convert the value of an element from String to int
//	    	   	I used replace to remove " element  where it created an exception	
						stopID = Integer.parseInt(ifNull(tempArr[0]).replace("\"", ""));
						pid = Integer.parseInt(ifNull(tempArr[1]).replace("\"", ""));
						gender = ifNull(tempArr[2]);

					} catch (Exception e)
					{
						stopID = 0;
						pid = 0;
					}

//				adding a new object to the ArrayList
//					policeStopArr.add(new Gender(stopID, pid, gender));
					
					int stopIDIndex = findStopIDIndex(stopID);
					if(stopIDIndex >= 0)
					{
						policeStopArr.get(stopIDIndex).addGender(new Gender(stopID, pid, gender));;
					}
					else policeStopArr.add(new PoliceStop(stopID, pid, new Gender(stopID, pid, gender)));		

				} else
				{
					isHeader = false;
				}
			}
			sc.close();
		}

//	    catching IOException

		catch (IOException io)
		{
			io.printStackTrace();
		}

	}
	
/**
 * 	A method of getting a Stop Reason from an ArrayList after reading the file
 * using stopID. Getting a String line from a read file with the matching stopID
 * 
 * @param stopIDInput
 * @return reason.toString()
 */
	public String getStopReason(int stopIDInput)
	{
		int stopIDIndex = findStopIDIndex(stopIDInput);
		if(stopIDIndex >= 0 )
		{
			PoliceStop element = policeStopArr.get(stopIDIndex);
			ArrayList <StopReason> rsn = new ArrayList <StopReason>();
			  rsn = element.getFullReason();
		
			return rsn.toString();
		}
		return "";
	}
	
/**
 * 	A method of getting a StopResult from an ArrayList after reading the file
 * using stopID.Getting a String line from a read file with the matching stopID
 * 
 * @param stopIDInput
 * @return result.toString()
 */
	public String getStopResult(int stopIDInput)
	{
		int stopIDIndex = findStopIDIndex(stopIDInput);
		if(stopIDIndex >= 0 )
		{
			PoliceStop element = policeStopArr.get(stopIDIndex);
			ArrayList <StopResult> rslt = new ArrayList <StopResult>();
			  rslt = element.getFullResult();
			return rslt.toString();
		}
		return "";
	}
	
	/**
	 * 	A method of getting a Race from an ArrayList after reading the file
	 * using stopID.Getting a String line from a read file with the matching stopID
	 * 
	 * @param stopIDInput
	 * @return race.toString()
	 */
	public String getRace(int stopIDInput)
	{
		int stopIDIndex = findStopIDIndex(stopIDInput);
		if(stopIDIndex >= 0 )
		{
			PoliceStop element = policeStopArr.get(stopIDIndex);
			Race rc = new Race ();
			element.addRace(rc);
			return element.toString();
		}
		return "";
	}
	/**
	 * 	A method of getting a Gender from an ArrayList after reading the file
	 * using stopID.Getting a String line from a read file with the matching stopID
	 * 
	 * @param stopIDInput
	 * @return gender.toString()
	 */	
	public String getGender(int stopIDInput)
	{
		int stopIDIndex = findStopIDIndex(stopIDInput);
		if(stopIDIndex >= 0 )
		{
			PoliceStop element = policeStopArr.get(stopIDIndex);
			Gender gndr = new Gender();
			element.addGender(gndr);
			return element.toString();
		}
		return "";
	}
	/**
	 * 
	 * A method used in readers and getters of this class primarily to find 
	 * a matching stopID in a file with whatever a user typed
	 * 
	 * @param stopIDInput
	 * @return matching stopID
	 */
	public int findStopIDIndex(int stopIDInput)
	{
		int stopReasonArrLength = policeStopArr.size(); // assigning a size of an array list
		
		for (int i = 0; i < stopReasonArrLength; i++)
		{
			

//		create a new variable element of type StopReason, the object StopReason inside the ArrayList which has a particular index assign to this new variable
			PoliceStop element = policeStopArr.get(i);
//			id of type int assigned to the  int element stopID of the object StopReason
			
			int id = element.getStopID();
			
//			 if the user input matches with some stopID in the object in the ArrayList
			if (id == stopIDInput)
			{
				
				return i;
				
			}

		}
		return -1;
	}
	


}
