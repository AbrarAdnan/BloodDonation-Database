import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MainMenu {

	private JFrame frame;
	private ButtonGroup group = new ButtonGroup();
	public static String blood;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
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
		
		Statement stmt;
		try {
			stmt = DBConnection.getConnection().createStatement();
			stmt.executeUpdate("use shohan");
			//stmt.executeUpdate("create table bloodinfo (name varchar(20), mobile varchar(20),bloodgroup varchar(5),address varchar(20));");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JRadioButton rdbtnA = new JRadioButton("A +");
		rdbtnA.setBounds(35, 46, 109, 23);
		frame.getContentPane().add(rdbtnA);
		
		JRadioButton rdbtnA_1 = new JRadioButton("A -");
		rdbtnA_1.setBounds(35, 79, 109, 23);
		frame.getContentPane().add(rdbtnA_1);
		
		JRadioButton rdbtnB = new JRadioButton("B +");
		rdbtnB.setBounds(185, 44, 109, 23);
		frame.getContentPane().add(rdbtnB);
		
		JRadioButton rdbtnB_1 = new JRadioButton("B -");
		rdbtnB_1.setBounds(185, 79, 109, 23);
		frame.getContentPane().add(rdbtnB_1);
		
		JRadioButton rdbtnO = new JRadioButton("O +");
		rdbtnO.setBounds(35, 124, 109, 23);
		frame.getContentPane().add(rdbtnO);
		
		JRadioButton rdbtnO_1 = new JRadioButton("O -");
		rdbtnO_1.setBounds(35, 160, 109, 23);
		frame.getContentPane().add(rdbtnO_1);
		
		JRadioButton rdbtnAb = new JRadioButton("AB +");
		rdbtnAb.setBounds(185, 124, 109, 23);
		frame.getContentPane().add(rdbtnAb);
		
		JRadioButton rdbtnAb_1 = new JRadioButton("AB -");
		rdbtnAb_1.setBounds(185, 160, 109, 23);
		frame.getContentPane().add(rdbtnAb_1);
		
		JButton btnEnterData = new JButton("Enter Data");
		btnEnterData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnA.isSelected()) {
					blood="A+";
				}
				else if(rdbtnA_1.isSelected()) {
					blood="A-";
				}
				else if(rdbtnB.isSelected()) {
					blood="B+";
				}
				else if(rdbtnB_1.isSelected()) {
					blood="B-";
				}
				else if(rdbtnO.isSelected()) {
					blood="O+";
				}
				else if(rdbtnO_1.isSelected()) {
					blood="O-";
				}
				else if(rdbtnAb.isSelected()) {
					blood="AB+";
				}
				else if(rdbtnAb_1.isSelected()) {
					blood="AB-";
				}
				
				frame.dispose();
				InsertData.main(new String[] {});
				
			}
		});
		btnEnterData.setBounds(300, 56, 124, 23);
		frame.getContentPane().add(btnEnterData);
		
		JButton btnUpdateData = new JButton("Search Data");
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnA.isSelected()) {
					blood="A+";
				}
				else if(rdbtnA_1.isSelected()) {
					blood="A-";
				}
				else if(rdbtnB.isSelected()) {
					blood="B+";
				}
				else if(rdbtnB_1.isSelected()) {
					blood="B-";
				}
				else if(rdbtnO.isSelected()) {
					blood="O+";
				}
				else if(rdbtnO_1.isSelected()) {
					blood="O-";
				}
				else if(rdbtnAb.isSelected()) {
					blood="AB+";
				}
				else if(rdbtnAb_1.isSelected()) {
					blood="AB-";
				}
				
				frame.dispose();
				SearchData.main(new String[] {});
			}
		});
		btnUpdateData.setBounds(300, 107, 124, 23);
		frame.getContentPane().add(btnUpdateData);
		
		JButton btnDeleteData = new JButton("Delete Data");
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnA.isSelected()) {
					blood="A+";
				}
				else if(rdbtnA_1.isSelected()) {
					blood="A-";
				}
				else if(rdbtnB.isSelected()) {
					blood="B+";
				}
				else if(rdbtnB_1.isSelected()) {
					blood="B-";
				}
				else if(rdbtnO.isSelected()) {
					blood="O+";
				}
				else if(rdbtnO_1.isSelected()) {
					blood="O-";
				}
				else if(rdbtnAb.isSelected()) {
					blood="AB+";
				}
				else if(rdbtnAb_1.isSelected()) {
					blood="AB-";
				}
				frame.dispose();
				DeleteData.main(new String[] {});
			}
		});
		btnDeleteData.setBounds(300, 162, 124, 23);
		frame.getContentPane().add(btnDeleteData);
		
		JLabel lblSelectBloodGroup = new JLabel("Select Blood Group");
		lblSelectBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectBloodGroup.setBounds(60, 11, 131, 28);
		frame.getContentPane().add(lblSelectBloodGroup);
		
		JLabel lblEnterChoice = new JLabel("Enter Choice");
		lblEnterChoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterChoice.setBounds(321, 15, 103, 25);
		frame.getContentPane().add(lblEnterChoice);
		
		JButton btnNewButton = new JButton("Update Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnA.isSelected()) {
					blood="A+";
				}
				else if(rdbtnA_1.isSelected()) {
					blood="A-";
				}
				else if(rdbtnB.isSelected()) {
					blood="B+";
				}
				else if(rdbtnB_1.isSelected()) {
					blood="B-";
				}
				else if(rdbtnO.isSelected()) {
					blood="O+";
				}
				else if(rdbtnO_1.isSelected()) {
					blood="O-";
				}
				else if(rdbtnAb.isSelected()) {
					blood="AB+";
				}
				else if(rdbtnAb_1.isSelected()) {
					blood="AB-";
				}
				frame.dispose();
				UpdateData.main(new String[] {});
			}
		});
		btnNewButton.setBounds(300, 203, 124, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
