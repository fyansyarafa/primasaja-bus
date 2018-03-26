import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class abc extends JPanel {
	private JTextField textFielda;
	private JTextField textFieldb;
	private JTextField textFieldc;

	/**
	 * Create the panel.
	 */
	public abc() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("x^2");
		lblNewLabel.setBounds(108, 77, 29, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setBounds(197, 77, 18, 14);
		add(lblNewLabel_1);
		
		textFielda = new JTextField();
		textFielda.setHorizontalAlignment(SwingConstants.CENTER);
		textFielda.setToolTipText("a");
		textFielda.setBounds(58, 74, 40, 20);
		add(textFielda);
		textFielda.setColumns(10);
		
		textFieldb = new JTextField();
		textFieldb.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldb.setToolTipText("b");
		textFieldb.setBounds(147, 74, 40, 20);
		add(textFieldb);
		textFieldb.setColumns(10);
		
		textFieldc = new JTextField();
		textFieldc.setToolTipText("c");
		textFieldc.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldc.setBounds(225, 74, 40, 20);
		add(textFieldc);
		textFieldc.setColumns(10);
		
		JLabel lblNewLabela = new JLabel("");
		lblNewLabela.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabela.setBounds(80, 178, 46, 14);
		add(lblNewLabela);
		
		JLabel lblNewLabel_2 = new JLabel("a = ");
		lblNewLabel_2.setBounds(58, 178, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("b = ");
		lblNewLabel_3.setBounds(58, 203, 29, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabelb = new JLabel("");
		lblNewLabelb.setBounds(80, 203, 46, 14);
		add(lblNewLabelb);
		
		JLabel lblNewLabel_4 = new JLabel("c =");
		lblNewLabel_4.setBounds(58, 228, 29, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabelc = new JLabel("");
		lblNewLabelc.setBounds(80, 228, 46, 14);
		add(lblNewLabelc);
		
		JButton btnNewButtonsub = new JButton("SUBMIT");
		btnNewButtonsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					double x1,x2;
				    textFielda.getText();
					int a =Integer.parseInt(textFielda.getText());
					int b =Integer.parseInt(textFieldb.getText());
					int c =Integer.parseInt(textFieldc.getText());
					/*
					double b =Double.parseDouble(textFieldb.getText());
					double c =Double.parseDouble(textFieldc.getText());
					*/
					textFieldc.getText();
					x2 = ((-1)*b-Math.sqrt(Math.pow(b, 2)-4*a*c))/2*a;
					x1=((-1)*b+Math.sqrt(Math.pow(b, 2)-4*a*c))/2*a;
					// totOrg=Integer.parseInt(Jml.getText());
					//  x2= ((-1)*b-Math.sqrt(Math.pow(b, 2)-4*a*c))/2*a;
				   //  x1=((-1)*b+Math.sqrt(Math.pow(b, 2)-4*a*c))/2*a;
					
					/*
					 * double d = 3.14;
						String s = String.valueOf(d);
					 */
					String s=String.valueOf(x2);
					String s1=String.valueOf(x1);
					lblNewLabela.setText(s);
					lblNewLabelb.setText(s1);
					
					
				}catch(Exception a){
					a.printStackTrace();
					JOptionPane.showMessageDialog(null, "lengkapi dulu bos");
					
				}
			}
		});
		btnNewButtonsub.setBounds(255, 243, 89, 23);
		add(btnNewButtonsub);

	}
}
