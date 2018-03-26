import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
public class hapus extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNIM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hapus frame = new hapus();
					frame.setVisible(true);
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
	private JTable tableCari;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public hapus() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 324, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Masukkan Kode Tiket");
		lblNewLabel.setBounds(24, 46, 130, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNIM = new JTextField();
		textFieldNIM.setBounds(164, 43, 86, 20);
		contentPane.add(textFieldNIM);
		textFieldNIM.setColumns(10);
		
		JButton btnHapus = new JButton("Cari");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select Nama, KODETKT,Telepon,Rute from main where KODETKT='"+textFieldNIM.getText()+"'  ";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnHapus.setBounds(108, 71, 89, 23);
		contentPane.add(btnHapus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 288, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton hps = new JButton("Hapus");
		hps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hps h=new hps();
				h.setVisible(true);
			}
		});
		hps.setBounds(209, 71, 89, 23);
		contentPane.add(hps);
		
		
		
		
	}
}
