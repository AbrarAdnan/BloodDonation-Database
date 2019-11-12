import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertData {

	private JFrame frame;
	private JTextField textName;
	private JTextField textMobile;
	private JTextField textAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertData window = new InsertData();
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
	public InsertData() {
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
		
		JButton btnEnterInfo = new JButton("Enter Info");
		btnEnterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textName.getText(),mobile=textMobile.getText(),address=textAddress.getText();
				Statement stmt;
				try {
					stmt = DBConnection.getConnection().createStatement();
					stmt.executeUpdate("use shohan");
					stmt.executeUpdate("insert into bloodinfo values('"+name+"','"+mobile+"','"+MainMenu.blood+"','"+address+"')");
					JOptionPane.showMessageDialog(null, "Data inserted");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnterInfo.setBounds(10, 201, 114, 23);
		frame.getContentPane().add(btnEnterInfo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenu.main(new String[] {});
			}
		});
		btnBack.setBounds(287, 201, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textName = new JTextField();
		textName.setBounds(87, 28, 174, 26);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 28, 67, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(10, 65, 67, 23);
		frame.getContentPane().add(lblMobile);
		
		textMobile = new JTextField();
		textMobile.setColumns(10);
		textMobile.setBounds(87, 65, 174, 26);
		frame.getContentPane().add(textMobile);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(10, 99, 89, 23);
		frame.getContentPane().add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 135, 67, 23);
		frame.getContentPane().add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(87, 135, 174, 26);
		frame.getContentPane().add(textAddress);
		
		JLabel bloodlbl = new JLabel(MainMenu.blood);
		bloodlbl.setBounds(117, 102, 89, 20);
		frame.getContentPane().add(bloodlbl);
	}
}
