import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteData {

	private JFrame frame;
	private JTextField textName;
	private JTextField textMobile;
	private JTextField textAddress;
	private int i=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteData window = new DeleteData();
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
	public DeleteData() {
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
		
		JButton btnEnterInfo = new JButton("Search Info");
		btnEnterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Statement stmt;
				try {
					stmt = DBConnection.getConnection().createStatement();
				    stmt.executeUpdate("use shohan");
					ResultSet rs=stmt.executeQuery("select * from bloodinfo where bloodgroup='"+MainMenu.blood+"'");
					if(rs.absolute(i)) {
						textName.setText(rs.getString("name"));
						textMobile.setText(rs.getString("mobile"));
						textAddress.setText(rs.getString("address"));
						i++;
						
					}
					
					else
						JOptionPane.showMessageDialog(null, "End of records");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnterInfo.setBounds(10, 201, 108, 23);
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
		bloodlbl.setBounds(131, 102, 89, 20);
		frame.getContentPane().add(bloodlbl);
		
		JButton btnDeleteInfo = new JButton("Delete Info");
		btnDeleteInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt=DBConnection.getConnection().createStatement();
					stmt.executeUpdate("use shohan;");
					stmt.executeUpdate("DELETE from bloodinfo where name = '"+textName.getText()+"'");
					JOptionPane.showMessageDialog(null, "Deleted","Alert",JOptionPane.PLAIN_MESSAGE);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteInfo.setBounds(140, 201, 121, 23);
		frame.getContentPane().add(btnDeleteInfo);
	}
}
