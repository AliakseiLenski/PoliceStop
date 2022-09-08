import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

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
 *         Version/date: 2.0 /12/12/2020
 * 
 *         Responsibilities of class: Work with GUIs and implementation of
 *         FileWork and PoliceStop classes via GUI widgets
 */

public class PoliceStopWithGuis
{
	
//////////////////////////////////fields//////////////////////////////////////////
	
	private FileWork files;
	int stopIDInput = 0;
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;

	JRadioButton reasonButton;
	JRadioButton resultButton;
	JLabel label1;
	JTextField textfield1;
	JCheckBox race;
	JCheckBox gender;
	JButton button;
	JTextArea text1;

//////////////////////////////////Constructor//////////////////////////////////////////	
	
	public PoliceStopWithGuis(FileWork policeStop)
	{
		this.files = policeStop;

		frame = new JFrame("Police Stop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 400);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		
//decided to make it easier for me and added three top panel to one and place it North
		panel6.add(panel1);
		panel6.add(panel2);
		panel6.add(panel3);

		frame.add(panel6, BorderLayout.NORTH);
		frame.add(panel4, BorderLayout.CENTER);
		frame.add(panel5, BorderLayout.SOUTH);

		this.policeStopUI();
		frame.setVisible(true);
	}
	
////////////////////////////Methods///////////////////////////////////////
	
/**
 * A method where GUIs are created and placed
 * 
 * 	
 */
	
	public void policeStopUI()
	{
		String output = "";

		label1 = new JLabel("Enter Stop ID");
		textfield1 = new JTextField();

		panel1.setLayout(new BorderLayout());
		panel1.add(label1, BorderLayout.NORTH);
		panel1.add(textfield1, BorderLayout.CENTER);

		ButtonGroup bG = new ButtonGroup();

		reasonButton = new JRadioButton("Reason");
		resultButton = new JRadioButton("Result");
		bG.add(reasonButton);
		bG.add(resultButton);
		panel2.add(reasonButton);
		panel2.add(resultButton);

		race = new JCheckBox("Race");
		gender = new JCheckBox("Gender");

		panel3.setLayout(new BorderLayout());
		panel3.add(race, BorderLayout.NORTH);
		panel3.add(gender, BorderLayout.SOUTH);

		JPanel buttonPanel = new JPanel();
		button = new JButton("See the Output");
		button.addActionListener(new ButtonListener());
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(button, BorderLayout.CENTER);
		panel4.add(buttonPanel);

		text1 = new JTextArea(output);
		panel5.setLayout(new FlowLayout());
		text1.setEditable(false);
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		text1.setSize(600, 500);
		panel5.add(text1);

	}
/**
 * A method for giving all the widgets some functionality.
 * Basically event handlers for all the widgets except the button.
 * This all will work after the button is pressed
 * 
 */
	public void displayOutput()
	{

		StringBuilder outputInfo = new StringBuilder();

		int stopIDInput = Integer.parseInt(textfield1.getText());

		try
		{
			int stopIDIndex = files.findStopIDIndex(stopIDInput);

			if (stopIDIndex >= 0)
			{
				if (reasonButton.isSelected())
				{

					String reason = files.getStopReason(stopIDInput);
					outputInfo.append(reason);
					System.out.println(outputInfo);

				} else if (resultButton.isSelected())
				{
					String result = files.getStopResult(stopIDInput);
					outputInfo.append(result);
					System.out.println(outputInfo);
				}

				if (race.isSelected())
				{
					String race1 = files.getRace(stopIDInput);
					outputInfo.append(race1);
					System.out.println(outputInfo);
				}
				if (gender.isSelected())
				{
					String gender1 = files.getGender(stopIDInput);
					outputInfo.append(gender1);
					System.out.println(outputInfo);
				}

				text1.setText(outputInfo.toString());
			}

		}

		catch (NullPointerException e)
		{
			e.printStackTrace();
			text1.setText(outputInfo.toString());
		}

	}
/**
 * A main method where the program is being executed
 * 
 * @param args
 */
	public static void main(String[] args)
	{

		new PoliceStopWithGuis(new FileWork());
	}

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
	 *         Version/date: 2.0 /12/12/2020
	 * 
	 *         Responsibilities of class: ActionListener for JButton button, implementing
	 *         actions from other widgets after the buttton is pressed
	 */
	class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			displayOutput();

		}

	}

}
