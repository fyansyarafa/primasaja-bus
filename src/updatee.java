import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class updatee extends JFrame {

	private JPanel contentPane;
	private JTextField Jam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatee frame = new updatee();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		WindowEvent  winClosingEvent = new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	Connection connection=null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNam;
	private JTextField textFieldTLP;

	
	/**
	 * Create the frame.
	 */
	public updatee() {
		setTitle("Ubah Data Penumpang");
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-268, -48, 468, 198);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPukul = new JLabel("Jam");
		lblPukul.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPukul.setBounds(41, 77, 46, 14);
		contentPane.add(lblPukul);
		
		Jam = new JTextField();
		Jam.setBounds(109, 74, 120, 20);
		Jam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Jam.setToolTipText("");
		contentPane.add(Jam);
		Jam.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(239, 11, 164, 90);
		panel.setBorder(new TitledBorder(null, "Waktu Keberangkatan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_17 = new JButton("07.00");
		btnNewButton_17.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_17.setBackground(new Color(100, 149, 237));
		btnNewButton_17.setForeground(new Color(255, 255, 255));
		btnNewButton_17.setBounds(6, 16, 74, 30);
		panel.add(btnNewButton_17);
		
		JButton button8 = new JButton("08.00");
		button8.setFont(new Font("Arial", Font.BOLD, 13));
		button8.setBackground(new Color(100, 149, 237));
		button8.setForeground(new Color(255, 255, 255));
		button8.setBounds(84, 16, 74, 30);
		panel.add(button8);
		
		JButton button9 = new JButton("09.00");
		button9.setFont(new Font("Arial", Font.BOLD, 13));
		button9.setBackground(new Color(100, 149, 237));
		button9.setForeground(new Color(255, 255, 255));
		button9.setBounds(6, 53, 74, 30);
		panel.add(button9);
		
		JButton button10 = new JButton("10.00");
		button10.setFont(new Font("Arial", Font.BOLD, 13));
		button10.setBackground(new Color(100, 149, 237));
		button10.setForeground(new Color(255, 255, 255));
		button10.setBounds(84, 53, 74, 30);
		panel.add(button10);
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Jam.setText("10.00");
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Pilih Waktu keberangkatan");
					
				}
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Jam.setText("09.00");
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Pilih Waktu keberangkatan");
					
				}
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Jam.setText("08.00");
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Pilih Waktu keberangkatan");
					
				}
			}
		});
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					Jam.setText("07.00");
					
				}catch(Exception e){
					
					
				}
			}
		});
		//comboBox.addItem("Pilih Rute");
		//comboBox.getsele
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(187, 120, 89, 23);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update main4 set Nama='"+textFieldNam.getText()+"' ,Telepon='"+textFieldTLP.getText()+"' ,Jam='"+Jam.getText()+"';          ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Diperbarui");
					
					pst.close();
					close();                
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel Nama = new JLabel("Nama");
		Nama.setFont(new Font("Arial", Font.PLAIN, 11));
		Nama.setBounds(41, 27, 46, 14);
		contentPane.add(Nama);
		
		textFieldNam = new JTextField();
		textFieldNam.setBounds(109, 24, 120, 20);
		contentPane.add(textFieldNam);
		textFieldNam.setColumns(10);
		
		JLabel Telepon = new JLabel("No Tlp");
		Telepon.setFont(new Font("Arial", Font.PLAIN, 11));
		Telepon.setBounds(41, 52, 46, 14);
		contentPane.add(Telepon);
		
		textFieldTLP = new JTextField();
		textFieldTLP.setBounds(109, 49, 120, 20);
		contentPane.add(textFieldTLP);
		textFieldTLP.setColumns(10);
		
		
		
		
		
		
	}
}
