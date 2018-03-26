
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class mhs extends JFrame {

	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mhs frame = new mhs();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
							
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JButton btnHapus;
	private JButton btnNewButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textFieldkode;
	/**
	 * Create the frame.
	 */
	public mhs() {
		setTitle("Main Menu");
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnLoadData = new JButton("All");
		btnLoadData.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLoadData.setBackground(new Color(100, 149, 237));
		btnLoadData.setForeground(new Color(255, 255, 255));
		buttonGroup_1.add(btnLoadData);
		btnLoadData.setBounds(390, 468, 62, 23);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="SELECT * FROM main4 ORDER BY Rute, Tanggal ASC, Jam ASC";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLoadData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 730, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnHapus = new JButton("Pembatalan Tiket");
		btnHapus.setForeground(new Color(255, 255, 255));
		btnHapus.setBackground(new Color(100, 149, 237));
		btnHapus.setFont(new Font("Arial", Font.PLAIN, 11));
		btnHapus.setBounds(534, 149, 115, 23);
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hps h=new hps();
				h.setVisible(true);
				h.setLocationRelativeTo(null);
			}
		});
		contentPane.add(btnHapus);
		
		btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(662, 149, 78, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatee edt=new updatee();
				edt.setVisible(true);
				edt.setLocationRelativeTo(null);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabelUser = new JLabel("");
		lblNewLabelUser.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		lblNewLabelUser.setBounds(439, 11, 46, 14);
		contentPane.add(lblNewLabelUser);
		
		
		
		JButton Cari = new JButton("Cari");
		Cari.setForeground(new Color(255, 255, 255));
		Cari.setBackground(new Color(100, 149, 237));
		Cari.setFont(new Font("Arial", Font.PLAIN, 11));
		Cari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (textFieldkode.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Masukkan Kode Tiket Terlebih Dahulu");
						
					}else{
					//	if(textFieldkode)
						String query="select * from main4  where KODETKT='"+textFieldkode.getText()+"'  ";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						

						
						
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
				} catch (Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
				}
			}
		});
		Cari.setBounds(678, 23, 62, 23);
		contentPane.add(Cari);
		
		textFieldkode = new JTextField();
		textFieldkode.setBounds(582, 24, 86, 20);
		contentPane.add(textFieldkode);
		textFieldkode.setColumns(10);
		
		JLabel lblNewLabeltiket = new JLabel("Kode Tiket");
		lblNewLabeltiket.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabeltiket.setBounds(510, 27, 71, 14);
		contentPane.add(lblNewLabeltiket);
		
		JButton Reset = new JButton("Reset");
		Reset.setFont(new Font("Arial", Font.PLAIN, 11));
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="DELETE FROM main4";
					String query2="DELETE FROM Jakarta";
					String query3="DELETE FROM Yogyakarta";
					String query4="DELETE FROM Solo";
					String query5="DELETE FROM Surabaya";

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
					
					JOptionPane.showMessageDialog(null, "Data Telah Direset");
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		Reset.setBounds(291, 468, 89, 23);
		contentPane.add(Reset);
		
		
		
		JButton Go = new JButton("SOL");
		Go.setForeground(new Color(255, 255, 255));
		Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT * FROM main4 WHERE Rute='BDG-SOL' ORDER BY Tanggal ASC, Jam ASC";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception r){
					
					
				}
			}
		});
		
		
		
		Go.setBackground(new Color(100, 149, 237));
		Go.setFont(new Font("Arial", Font.PLAIN, 11));
		Go.setBounds(678, 468, 62, 23);
		contentPane.add(Go);
		
		JButton btnNewButton_1 = new JButton("JOG");
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT * FROM main4 WHERE Rute='BDG-JOG' ORDER BY Tanggal ASC, Jam ASC";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception r){
					
					
				}
			}
		});
		btnNewButton_1.setBounds(606, 468, 62, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("JKT");
		btnNewButton_2.setBackground(new Color(100, 149, 237));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT * FROM main4 WHERE Rute='BDG-JKT' ORDER BY Tanggal ASC, Jam ASC";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception r){
					
					
				}
			}
		});
		btnNewButton_2.setBounds(462, 468, 62, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SBY");
		btnNewButton_3.setBackground(new Color(100, 149, 237));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT * FROM main4 WHERE Rute='BDG-SBY' ORDER BY Tanggal ASC, Jam ASC";

					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception r){
					
					
				}
			}
		});
		btnNewButton_3.setBounds(534, 468, 62, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("PrimaSaja");
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 52));
		lblNewLabel.setBounds(10, 32, 368, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUS");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(266, 83, 78, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton SBY = new JButton("BDG-SBY");
		SBY.setBounds(10, 128, 96, 44);
		contentPane.add(SBY);
		SBY.setFont(new Font("Arial", Font.BOLD, 13));
		SBY.setBackground(new Color(100, 149, 237));
		SBY.setForeground(new Color(255, 255, 255));
		
		JButton JKT = new JButton("BDG-JKT");
		JKT.setBounds(116, 128, 96, 44);
		contentPane.add(JKT);
		JKT.setFont(new Font("Arial", Font.BOLD, 13));
		JKT.setBackground(new Color(100, 149, 237));
		JKT.setForeground(new Color(255, 255, 255));
		
		JButton SOL = new JButton("BDG-SOL");
		SOL.setBounds(328, 128, 96, 44);
		contentPane.add(SOL);
		SOL.setFont(new Font("Arial", Font.BOLD, 13));
		SOL.setBackground(new Color(100, 149, 237));
		SOL.setForeground(new Color(255, 255, 255));
		
		JButton JOG = new JButton("BDG-JOG");
		JOG.setBounds(222, 128, 96, 44);
		contentPane.add(JOG);
		JOG.setFont(new Font("Arial", Font.BOLD, 13));
		JOG.setForeground(new Color(255, 255, 255));
		JOG.setBackground(new Color(100, 149, 237));
		
		
		
		JOG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jog add=new Jog();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
				
			}
		});
		
		
		
		
		SOL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sol add=new Sol();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		});
		JKT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jkt add=new Jkt();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
				
				
			}
		});
		SBY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tambah add=new tambah();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
			}
		});
		
		
		try{
			
		}catch(Exception y){
			
		}
	}
}
