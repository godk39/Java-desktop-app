package a2_1901040029;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddNewModule extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSemester;
	private JTextField textFieldCredits;
	private JTextField textFieldDepartment;
	private JLabel lblNewLabel_4;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox<String> comboBox;

	/**
	 * Create the frame.
	 */
	public AddNewModule() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Add new module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenSize.width, screenSize.height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Compulsory Module", "Elective Module" }));
		comboBox.setBounds(850, 200, 300, 31);
		comboBox.addActionListener(this);
		contentPane.add(comboBox);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldName.setBounds(850, 300, 300, 31);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldSemester = new JTextField();
		textFieldSemester.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldSemester.setColumns(10);
		textFieldSemester.setBounds(850, 400, 300, 31);
		contentPane.add(textFieldSemester);

		textFieldCredits = new JTextField();
		textFieldCredits.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldCredits.setColumns(10);
		textFieldCredits.setBounds(850, 500, 300, 31);
		contentPane.add(textFieldCredits);

		textFieldDepartment = new JTextField();
		textFieldDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDepartment.setColumns(10);
		textFieldDepartment.setBounds(850, 600, 300, 31);
		textFieldDepartment.setVisible(false);
		contentPane.add(textFieldDepartment);

		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(650, 200, 100, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(650, 300, 100, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Semester");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(650, 400, 100, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Credits");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(650, 500, 100, 31);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Department name");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(650, 600, 150, 31);
		lblNewLabel_4.setVisible(false);
		contentPane.add(lblNewLabel_4);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdd.setBounds(1000, 800, 150, 50);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(800, 800, 150, 50);
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

		if (e.getSource() == comboBox) {
			if (comboBox.getSelectedItem().toString() == "Compulsory Module") {
				lblNewLabel_4.setVisible(false);
				textFieldDepartment.setVisible(false);
				
			} else {
				lblNewLabel_4.setVisible(true);
				textFieldDepartment.setVisible(true);
			}
		}
		
		if (e.getSource() == btnAdd && comboBox.getSelectedItem().toString() == "Compulsory Module") {
			String name = textFieldName.getText();
			int semester = Integer.parseInt(textFieldSemester.getText());
			int credits = Integer.parseInt(textFieldCredits.getText());

			DBHelper.addNewCompulModule(name, semester, credits);
			DBHelper.addNewModule(name, semester, credits);
			System.out.println("Add successful!");
		}
		
		if (e.getSource() == btnAdd && comboBox.getSelectedItem().toString() == "Elective Module") {
			String name = textFieldName.getText();
			int semester = Integer.parseInt(textFieldSemester.getText());
			int credits = Integer.parseInt(textFieldCredits.getText());
			String departmentName = textFieldDepartment.getText();
			DBHelper.addNewElecModule(name, semester, credits, departmentName);
			DBHelper.addNewModule(name, semester, credits);
			System.out.println("Add successful!");
		}
	}
}
