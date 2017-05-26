package DoublyLinkedList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class NurseForm {
	
	private DoublyLinkedList PatientList;
	private PatientDatabase MockDatabase;
	
	JFrame frame;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField AgeField;
	private JTextField MobileNumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseForm window = new NurseForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//Creating input and output, and the list which will hold the information
	public NurseForm()
	{
		this.PatientList = new DoublyLinkedList();
		this.MockDatabase = new PatientDatabase("C:/tmp/NursePatients.csv");
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		//Reads the receptionist list, grabs the final entry (FIFO)
		PatientList = MockDatabase.FileToDoublyLinkedList("C:/tmp/ReceptionistPatients.csv");
		//Attempts check to see if the Receptionist has any patients
		boolean NoPatients = PatientList.isEmpty();
		Patient SamplePatient = new Patient();
		if(!NoPatients)
		{
			SamplePatient = PatientList.GetLastPatient();
		}	
		//Removing the selected entry from the receptionist list by rewriting the list without it TODO: This is slightly bugged
		MockDatabase.DoublyLinkedListToFile("C:/tmp/ReceptionistPatients.csv", PatientList);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientForm = new JLabel("Patient Form");
		lblPatientForm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientForm.setBounds(188, 42, 95, 14);
		frame.getContentPane().add(lblPatientForm);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setToolTipText("Enter Name Here");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBackground(Color.GRAY);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBounds(10, 74, 73, 14);
		frame.getContentPane().add(lblName);
		
		FirstNameField = new JTextField();
		FirstNameField.setBounds(93, 71, 101, 20);
		frame.getContentPane().add(FirstNameField);
		FirstNameField.setColumns(10);
		
		JLabel lblForname = new JLabel("Last Name");
		lblForname.setBounds(10, 108, 73, 14);
		frame.getContentPane().add(lblForname);
		
		LastNameField = new JTextField();
		LastNameField.setBounds(93, 105, 101, 20);
		frame.getContentPane().add(LastNameField);
		LastNameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(10, 143, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		AgeField = new JTextField();
		AgeField.setBounds(93, 140, 37, 20);
		frame.getContentPane().add(AgeField);
		AgeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setBounds(10, 178, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox GenderField = new JComboBox();
		GenderField.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		GenderField.setBounds(93, 175, 59, 20);
		frame.getContentPane().add(GenderField);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No.");
		lblNewLabel_3.setBounds(10, 215, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		MobileNumberField = new JTextField();
		MobileNumberField.setBounds(93, 212, 101, 20);
		frame.getContentPane().add(MobileNumberField);
		MobileNumberField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(10, 247, 59, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea AddressField = new JTextArea();
		AddressField.setBounds(93, 257, 200, 74);
		frame.getContentPane().add(AddressField);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(10, 343, 73, 14);
		frame.getContentPane().add(lblSymptoms);
		
		JTextArea SymptomsField = new JTextArea();
		SymptomsField.setBounds(93, 353, 200, 74);
		frame.getContentPane().add(SymptomsField);
		
		JButton btnSave = new JButton("Save ");
		btnSave.setBounds(93, 487, 73, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(188, 487, 73, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel PriorityLabel = new JLabel("Priority Level (1-10)");
		PriorityLabel.setBounds(10, 446, 127, 14);
		frame.getContentPane().add(PriorityLabel);
		
		JComboBox PriorityField = new JComboBox();
		PriorityField.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		PriorityField.setBounds(147, 443, 59, 20);
		frame.getContentPane().add(PriorityField);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(285, 487, 73, 23);
		frame.getContentPane().add(btnClose);
		
		//Filling NurseForm fields with ReceptionistPatient information
		if(!NoPatients)
		{
			FirstNameField.setText(SamplePatient.FirstNameField);
			LastNameField.setText(SamplePatient.LastNameField);
			AgeField.setText(SamplePatient.AgeField);
			GenderField.setSelectedItem(SamplePatient.GenderField);
			MobileNumberField.setText(SamplePatient.MobileNumberField);
			AddressField.setText(SamplePatient.AddressField);
			SymptomsField.setText(SamplePatient.SymptomsField);
		}
		else
		{
			//Attempted pop-up if no patients are available. 
			JOptionPane.showMessageDialog(null, "There are no current patients.");
		}
		
		
		//Check if any fields are empty
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(FirstNameField.getText().isEmpty()||(LastNameField.getText().isEmpty())||(AgeField.getText().isEmpty())||(GenderField.getSelectedItem().equals(""))||
						(MobileNumberField.getText().isEmpty())||(AddressField.getText().isEmpty())||(SymptomsField.getText().isEmpty())||(PriorityField.getSelectedItem().equals("")))
					JOptionPane.showMessageDialog(null, "Information Missing");
				else
				{		
					//If all are filled, create new patient using data held in fields
				Patient NursePatient = new Patient(FirstNameField.getText()/*.trim()*/, LastNameField.getText(), AgeField.getText(), 
						GenderField.getSelectedItem().toString(), MobileNumberField.getText(), AddressField.getText(), SymptomsField.getText());
				//Creating connection to the file and adding the priority field
				NursePatient.PriorityField = Integer.parseInt(PriorityField.getSelectedItem().toString());
				MockDatabase.write(NursePatient.giveInfoAsArrayList());
				//Show pop-up that message is submitted
				JOptionPane.showMessageDialog(null, "Patient Information Submitted");
				}
			}
		});
		//Setting text for all fields to null with a "clear" button
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FirstNameField.setText(null);
				LastNameField.setText(null);
				AgeField.setText(null);
				MobileNumberField.setText(null);
				GenderField.setSelectedItem("");
				AddressField.setText(null);
				SymptomsField.setText(null);
				PriorityField.setSelectedItem("");
				
			}
			});
	  
		//Adds close button, disposes of current frame and recreates the selection screen menu
			btnClose.addActionListener(new ActionListener()
			{
	
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose();
					SelectionScreen menu = new SelectionScreen();
					menu.frame.setVisible(true);
				}
		
			});
		
	}
}

