package a2_1901040029;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddNewStudent extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDob;
	private JTextField textFieldAddress;
	private JTextField textFieldMail;
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public AddNewStudent() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Add new student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenSize.width, screenSize.height);

		//setBounds(100, 100, 548, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldName.setBounds(850, 200, 300, 31);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDob = new JTextField();
		textFieldDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDob.setBounds(850, 300, 300, 31);
		textFieldDob.setColumns(10);
		contentPane.add(textFieldDob);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldAddress.setBounds(850, 400, 300, 31);
		textFieldAddress.setColumns(10);
		contentPane.add(textFieldAddress);
		
		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldMail.setBounds(850, 500, 300, 31);
		textFieldMail.setColumns(10);
		contentPane.add(textFieldMail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(750, 200, 227, 31);
		contentPane.add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDob.setBounds(750, 300, 227, 31);
		contentPane.add(lblDob);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(750, 400, 227, 31);
		contentPane.add(lblAddress);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMail.setBounds(750, 500, 100, 31);
		contentPane.add(lblMail);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdd.setBounds(1000, 700, 150, 50);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(800, 700, 150, 50);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCancel) {
			this.dispose();
			JFMenu jfMenu = new JFMenu();
		}
		
		if (e.getSource() == btnAdd) {
			String name = textFieldName.getText();
			String dob = textFieldDob.getText();
			String address = textFieldAddress.getText();
			String mail = textFieldMail.getText();

			DBHelper.addNewStudent(name, dob, address, mail);
			System.out.println("Add successful!");
		}
	}
}
