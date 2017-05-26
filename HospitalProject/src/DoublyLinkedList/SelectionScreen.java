package DoublyLinkedList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionScreen {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Making the selection screen
					SelectionScreen window = new SelectionScreen();
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
	public SelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseStateRequired = new JLabel("Please select required form");
		lblPleaseStateRequired.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseStateRequired.setBounds(137, 77, 181, 14);
		frame.getContentPane().add(lblPleaseStateRequired);
		
		//Making receptionist button
		JButton btnReceptionist = new JButton("Receptionist");
		btnReceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				ReceptionistForm form1 = new ReceptionistForm();
				form1.frame.setVisible(true);	
			}
		});
		btnReceptionist.setBounds(20, 149, 114, 23);
		frame.getContentPane().add(btnReceptionist);
		
		//Making nurse button
		JButton btnNurse = new JButton("Nurse");
		btnNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NurseForm form1 = new NurseForm();
				form1.frame.setVisible(true);	
			}
		});
		btnNurse.setBounds(152, 149, 114, 23);
		frame.getContentPane().add(btnNurse);
		
		//Making doctor button
		JButton btnDoctor = new JButton("Doctor");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				DoctorForm form1 = new DoctorForm();
				form1.frame.setVisible(true);	
			}
		});btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDoctor.setBounds(288, 149, 114, 23);
		frame.getContentPane().add(btnDoctor);
	}
}
