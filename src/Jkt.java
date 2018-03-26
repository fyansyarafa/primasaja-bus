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
public class Jkt extends JFrame {

	private JPanel contentPane;
	private JTextField Jam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jkt frame = new Jkt();
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
	private JTextField Jml;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNam;
	private JTextField textFieldTLP;
	private JTextField textFieldCode;

	
	/**
	 * Create the frame.
	 */
	public Jkt() {
		setTitle("New Reservation");
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-268, -48, 463, 261);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTgl = new JLabel("Tgl");
		lblTgl.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTgl.setBounds(41, 98, 46, 14);
		contentPane.add(lblTgl);
		
		JLabel lblPukul = new JLabel("Jam");
		lblPukul.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPukul.setBounds(41, 123, 46, 14);
		contentPane.add(lblPukul);
		
		Jam = new JTextField();
		Jam.setBounds(109, 120, 120, 20);
		Jam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Jam.setToolTipText("");
		contentPane.add(Jam);
		Jam.setColumns(10);
		
		JDateChooser dateChooserSBY = new JDateChooser();
		dateChooserSBY.getCalendarButton().setBackground(new Color(100, 149, 237));
		dateChooserSBY.setDateFormatString("MMM d, yyyy\r\n\r\n");
		dateChooserSBY.setBounds(109, 92, 120, 20);
		contentPane.add(dateChooserSBY);
		
		JLabel lblNewLabelRute = new JLabel("BDG-JKT");
		lblNewLabelRute.setForeground(new Color(0, 128, 0));
		lblNewLabelRute.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblNewLabelRute.setBounds(41, 11, 188, 23);
		contentPane.add(lblNewLabelRute);
		
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
		
		JLabel Tkt = new JLabel("Jumlah");
		Tkt.setFont(new Font("Arial", Font.PLAIN, 11));
		Tkt.setBounds(41, 148, 46, 14);
		contentPane.add(Tkt);
		
		Jml = new JTextField();
		Jml.setBounds(109, 145, 34, 20);
		Jml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(Jml);
		Jml.setColumns(10);
		
		JLabel Org = new JLabel("Org");
		Org.setFont(new Font("Arial", Font.PLAIN, 11));
		Org.setBounds(153, 148, 26, 14);
		contentPane.add(Org);
		
	
		
		JLabel Rp = new JLabel("0");
		Rp.setFont(new Font("Tahoma", Font.BOLD, 17));
		Rp.setForeground(new Color(34, 139, 34));
		Rp.setBounds(239, 148, 203, 29);
		contentPane.add(Rp);
		
		JButton Ok = new JButton("Harga");
		Ok.setFont(new Font("Arial", Font.PLAIN, 11));
		Ok.setForeground(new Color(255, 255, 255));
		Ok.setBackground(new Color(100, 149, 237));
		Ok.setBounds(239, 119, 74, 23);
		Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int totOrg,totHrg;
				try{
					DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
					//DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
					DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
					//DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
					formatRp.setCurrencySymbol("Rp ");
					formatRp.setMonetaryDecimalSeparator(',');
					formatRp.setGroupingSeparator('.');
					totOrg=Integer.parseInt(Jml.getText());
					totHrg=150000*totOrg;
					kursIndonesia.setDecimalFormatSymbols(formatRp);
					Rp.setText(kursIndonesia.format(totHrg));
					
					
					//String t = java.text.NumberFormat.getCurrencyInstance().format(formatRp);
					//Rp.setText(t);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Pilihan Jam Keberangkatan atau Jumlah Penumpang Tidak Boleh Kosong");
					
				}
			}
		});
		contentPane.add(Ok);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(314, 188, 89, 23);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if((      (JTextField)dateChooserSBY.getDateEditor().getUiComponent()).getText().isEmpty() ||          Jam.getText().isEmpty() || textFieldNam.getText().isEmpty() || textFieldTLP.getText().isEmpty() || textFieldCode.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Masih Ada Yang Kosong");
						//btnNewButton.setEnabled(false);
					}else{
						
						String query="insert into main4(Rute,Tanggal, Jam, Jumlah, Harga, Nama, Telepon, KODETKT ) values(?,?,?,?,?,?,?,?)";
						String query2="insert into Jakarta(Rute,Tanggal, Jam, Jumlah, Harga, Nama, Telepon,KODETKT ) values(?,?,?,?,?,?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						PreparedStatement pts=connection.prepareStatement(query2);
						pst.setString(1, lblNewLabelRute.getText());
						pts.setString(1, lblNewLabelRute.getText());
						pst.setString(2, ((JTextField)dateChooserSBY.getDateEditor().getUiComponent()).getText());
						pts.setString(2, ((JTextField)dateChooserSBY.getDateEditor().getUiComponent()).getText());
						pst.setString(3, Jam.getText());
						pts.setString(3, Jam.getText());
						pst.setString(4, Jml.getText());
						pts.setString(4, Jml.getText());
						pst.setString(5, Rp.getText());
						pts.setString(5, Rp.getText());
						pst.setString(6, textFieldNam.getText());
						pts.setString(6, textFieldNam.getText());
						pst.setString(7, textFieldTLP.getText());
						pts.setString(7, textFieldTLP.getText());
						pst.setString(8, textFieldCode.getText());
						pts.setString(8, textFieldCode.getText());
						pst.execute();
						pts.execute();
						JOptionPane.showMessageDialog(null, "Tiket Berhasil Ditambahkan");
						pst.close();
						pts.close();
						close();
					}
					if (Rp.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Tentukan Harga Terlebih Dahulu");
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					//JOptionPane.showMessageDialog(null, "ada yang kosong bro");
					
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel Nama = new JLabel("Nama");
		Nama.setFont(new Font("Arial", Font.PLAIN, 11));
		Nama.setBounds(41, 45, 46, 14);
		contentPane.add(Nama);
		
		textFieldNam = new JTextField();
		textFieldNam.setBounds(109, 42, 120, 20);
		contentPane.add(textFieldNam);
		textFieldNam.setColumns(10);
		
		JLabel Telepon = new JLabel("No Tlp");
		Telepon.setFont(new Font("Arial", Font.PLAIN, 11));
		Telepon.setBounds(41, 70, 46, 14);
		contentPane.add(Telepon);
		
		textFieldTLP = new JTextField();
		textFieldTLP.setBounds(109, 67, 120, 20);
		contentPane.add(textFieldTLP);
		textFieldTLP.setColumns(10);
		
		JButton Code = new JButton("Generate Code");
		Code.setFont(new Font("Arial", Font.PLAIN, 11));
		Code.setBackground(new Color(100, 149, 237));
		Code.setForeground(new Color(255, 255, 255));
		Code.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					Random rdn = new Random();
					textFieldCode.setText(Integer.toString(rdn.nextInt(10000)));
					
					
				}catch(Exception e){
					
					
				}
			}
		});
		Code.setBounds(41, 188, 120, 23);
		contentPane.add(Code);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(171, 189, 86, 20);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		
		
		
		
		
	}
}
