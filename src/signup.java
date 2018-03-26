import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNama;
	private JTextField textFieldEmail;
	private JTextField textFieldUn;
	private JTextField textFieldPIN;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;

	/**
	 * Create the frame.
	 */
	public signup() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbladminform = new JLabel("Sign Up for Admin");
		lbladminform.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbladminform.setHorizontalAlignment(SwingConstants.CENTER);
		lbladminform.setBounds(0, 0, 159, 36);
		contentPane.add(lbladminform);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 47, 77, 14);
		contentPane.add(lblNama);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 72, 77, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUn = new JLabel("Username");
		lblUn.setBounds(10, 97, 77, 14);
		contentPane.add(lblUn);
		
		JLabel lblJPass = new JLabel("Password");
		lblJPass.setBounds(10, 122, 77, 14);
		contentPane.add(lblJPass);
		
		JLabel lblPIN = new JLabel("PIN");
		lblPIN.setBounds(10, 147, 46, 14);
		contentPane.add(lblPIN);
		
		textFieldNama = new JTextField();
		textFieldNama.setBounds(124, 44, 231, 20);
		contentPane.add(textFieldNama);
		textFieldNama.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(124, 69, 231, 20);
		contentPane.add(textFieldEmail);
		
		textFieldUn = new JTextField();
		textFieldUn.setBounds(124, 94, 127, 20);
		contentPane.add(textFieldUn);
		textFieldUn.setColumns(10);
		
		textFieldPIN = new JTextField();
		textFieldPIN.setText("");
		textFieldPIN.setBounds(124, 144, 86, 20);
		contentPane.add(textFieldPIN);
		textFieldPIN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 119, 127, 20);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into admin(ID, username, password, Nama, Email) values(?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldNama.getText());
					pst.setString(2, textFieldEmail.getText());
					pst.setString(3, textFieldUn.getText());
					pst.setString(4, textFieldPIN.getText());
					pst.setString(5, passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next()){
						
						count=count+1;
					}
					if(count ==0){
						JOptionPane.showMessageDialog(null, "Username dan Password tersedia");		
						mhs mhsdata= new mhs();
						mhsdata.setVisible(true);
					}else if(count>1){
						JOptionPane.showMessageDialog(null, "Username telah digunakan");
						
					}
					rs.close();
					pst.close();
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Tersimpan");
					
					pst.close();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setBounds(134, 175, 89, 23);
		contentPane.add(btnSignUp);
	}
}
