import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class hps extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldkode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hps frame = new hps();
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

	/**
	 * Create the frame.
	 */
	public hps() {
		setTitle("Pembatalan Tiket");
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 235, 137);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kode = new JLabel("Kode Tiket");
		kode.setFont(new Font("Arial", Font.PLAIN, 11));
		kode.setBounds(10, 26, 72, 14);
		contentPane.add(kode);
		
		textFieldkode = new JTextField();
		textFieldkode.setBounds(92, 23, 115, 20);
		contentPane.add(textFieldkode);
		textFieldkode.setColumns(10);
		
		JButton Hapus = new JButton("Hapus");
		Hapus.setFont(new Font("Arial", Font.PLAIN, 11));
		Hapus.setBackground(new Color(100, 149, 237));
		Hapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query="delete from main4 where KODETKT='"+textFieldkode.getText()+"'  ";
					String query2="delete from Jakarta where KODETKT='"+textFieldkode.getText()+"'  ";
					String query3="delete from Surabaya where KODETKT='"+textFieldkode.getText()+"'  ";
					String query4="delete from Yogyakarta where KODETKT='"+textFieldkode.getText()+"'  ";
					String query5="delete from Solo where KODETKT='"+textFieldkode.getText()+"'  ";
					PreparedStatement pst=connection.prepareStatement(query);
					PreparedStatement pst2=connection.prepareStatement(query2);
					PreparedStatement pst3=connection.prepareStatement(query3);
					PreparedStatement pst4=connection.prepareStatement(query4);
					PreparedStatement pst5=connection.prepareStatement(query5);
					pst2.execute();
					pst3.execute();
					pst4.execute();
					pst5.execute();
					pst.execute();
					JOptionPane.showMessageDialog(null, "Tiket Dibatalkan");
					
					
					pst.close();
					pst2.close();
					pst3.close();
					pst4.close();
					pst5.close();
					close();
					
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
				}
			
				
				
			}
		});
		Hapus.setBounds(65, 64, 89, 23);
		contentPane.add(Hapus);
	}
}
