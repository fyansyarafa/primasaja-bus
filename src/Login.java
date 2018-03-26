import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login {

	private JFrame frmLoginForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginForm.setVisible(true);
					window.frmLoginForm.setLocationRelativeTo(null);;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setTitle("Login Form");
		frmLoginForm.setBounds(100, 100, 341, 284);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame(" Admin");
		internalFrame.setBounds(10, 29, 305, 186);
		frmLoginForm.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(116, 24, 139, 20);
		internalFrame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 59, 139, 20);
		internalFrame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 62, 58, 14);
		internalFrame.getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 27, 76, 14);
		internalFrame.getContentPane().add(lblUsername);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(104, 106, 89, 23);
		internalFrame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					String query="select * from Daftar where username=? and password=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next()){
						count=count+1;
					}
					if(count ==1){
						JOptionPane.showMessageDialog(null, "Username dan Password cocok");
						frmLoginForm.dispose();
						mhs mhsdata= new mhs();
						mhsdata.setVisible(true);
						mhsdata.setLocationRelativeTo(null);
					
					}else{
						JOptionPane.showMessageDialog(null, "Username dan Password tidak ada yang cocok");
					}
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		internalFrame.setVisible(true);
	}
}
