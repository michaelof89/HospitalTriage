package DoublyLinkedList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class ReceptionistForm {
	
	public JFrame frame;
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
					ReceptionistForm window = new ReceptionistForm();
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
	public ReceptionistForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
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
		FirstNameField.setBounds(93, 75, 101, 20);
		frame.getContentPane().add(FirstNameField);
		FirstNameField.setColumns(10);
		
		JLabel lblForname = new JLabel("Last Name");
		lblForname.setBounds(10, 108, 73, 14);
		frame.getContentPane().add(lblForname);
		
		LastNameField = new JTextField();
		LastNameField.setBounds(93, 109, 101, 20);
		frame.getContentPane().add(LastNameField);
		LastNameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(10, 143, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		AgeField = new JTextField();
		AgeField.setBounds(93, 144, 37, 20);
		frame.getContentPane().add(AgeField);
		AgeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setBounds(10, 178, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox GenderField = new JComboBox();
		GenderField.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		GenderField.setBounds(93, 179, 59, 20);
		frame.getContentPane().add(GenderField);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile No.");
		lblNewLabel_3.setBounds(10, 215, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		MobileNumberField = new JTextField();
		MobileNumberField.setBounds(93, 216, 101, 20);
		frame.getContentPane().add(MobileNumberField);
		MobileNumberField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(10, 247, 59, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea AddressField = new JTextArea();
		AddressField.setBounds(93, 265, 200, 74);
		frame.getContentPane().add(AddressField);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(10, 343, 73, 14);
		frame.getContentPane().add(lblSymptoms);
		
		JTextArea SymptomsField = new JTextArea();
		SymptomsField.setBounds(93, 361, 200, 74);
		frame.getContentPane().add(SymptomsField);
		
		JButton btnSave = new JButton("Save ");
		btnSave.setBounds(128, 486, 65, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(203, 486, 65, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setBounds(278, 486, 73, 23);
		frame.getContentPane().add(btnClose);
		
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Check if any fields are empty
				if(FirstNameField.getText().isEmpty()||(LastNameField.getText().isEmpty())||(AgeField.getText().isEmpty())||(GenderField.getSelectedItem().equals(""))||
						(MobileNumberField.getText().isEmpty())||(AddressField.getText().isEmpty())||(SymptomsField.getText().isEmpty()))
					JOptionPane.showMessageDialog(null, "Information Missing");
				else
				{		
					//If all are filled, create new patient using data held in fields
				Patient ReceptionistPatient = new Patient(FirstNameField.getText().trim(), LastNameField.getText(), AgeField.getText(), 
						GenderField.getSelectedItem().toString(), MobileNumberField.getText(), AddressField.getText(), SymptomsField.getText());
				//Creating connection to the file
				PatientDatabase MockDatabase = new PatientDatabase("C:/tmp/ReceptionistPatients.csv");
				MockDatabase.write(ReceptionistPatient.giveInfoAsArrayList());
				//Show pop-up that message is submitted
				JOptionPane.showMessageDialog(null, "Patient Information Submitted");
				}
			}
			});
		
		//Setting text for all fields to null with a "clear" button
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstNameField.setText(null);
				LastNameField.setText(null);
				AgeField.setText(null);
				MobileNumberField.setText(null);
				GenderField.setSelectedItem("");
				AddressField.setText(null);
				SymptomsField.setText(null);
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


