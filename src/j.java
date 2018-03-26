import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class j extends JPanel {
	private JTextField textFielda;
	private JTextField textFieldb;

	/**
	 * Create the panel.
	 */
	public j() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("x^2");
		lblNewLabel.setBounds(110, 86, 46, 14);
		add(lblNewLabel);
		
		textFielda = new JTextField();
		textFielda.setBounds(10, 83, 86, 20);
		add(textFielda);
		textFielda.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.setBounds(242, 86, 46, 14);
		add(lblNewLabel_1);
		
		textFieldb = new JTextField();
		textFieldb.setBounds(146, 83, 86, 20);
		add(textFieldb);
		textFieldb.setColumns(10);

	}

}
