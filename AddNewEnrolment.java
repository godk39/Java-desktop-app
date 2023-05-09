package a2_1901040029;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddNewEnrolment extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField textFieldInternal;
	private JTextField textFieldExam;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox<Integer> comboBox1;
	private JComboBox<Integer> comboBox2;

	/**
	 * Create the frame.
	 */
	public AddNewEnrolment() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Add new enrolment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenSize.width, screenSize.height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox1 = new JComboBox<Integer>();
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox1.setModel(DBHelper.getStudentId());
		comboBox1.setBounds(850, 200, 300, 31);
		comboBox1.addActionListener(this);
		contentPane.add(comboBox1);

		comboBox2 = new JComboBox<Integer>();
		comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox2.setModel(DBHelper.getModuleCode());
		comboBox2.setBounds(850, 300, 300, 31);
		comboBox2.addActionListener(this);
		contentPane.add(comboBox2);

		textFieldInternal = new JTextField();
		textFieldInternal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldInternal.setColumns(10);
		textFieldInternal.setBounds(850, 400, 300, 31);
		contentPane.add(textFieldInternal);

		textFieldExam = new JTextField();
		textFieldExam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldExam.setColumns(10);
		textFieldExam.setBounds(850, 500, 300, 31);
		contentPane.add(textFieldExam);

		JLabel lblNewLabel = new JLabel("Student name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(650, 200, 227, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Module code");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(650, 300, 227, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Internal Mark");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(650, 400, 227, 31);		
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Exam Mark");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(650, 500, 227, 31);
		contentPane.add(lblNewLabel_3);

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
			int studentId = Integer.parseInt(comboBox1.getSelectedItem().toString());
			int moduleCode =Integer.parseInt(comboBox2.getSelectedItem().toString());
			double internalMark = Double.parseDouble(textFieldInternal.getText());
			double examMark = Double.parseDouble(textFieldExam.getText());
			double aggregatedMark =  (0.4 * internalMark + 0.6 * examMark);
			String finalGrade = null;
			if (aggregatedMark <= 10 && aggregatedMark >= 9)
				finalGrade = "E";
			if (aggregatedMark < 9 && aggregatedMark >= 7)
				finalGrade = "G";
			if (aggregatedMark < 7 && aggregatedMark >= 5)
				finalGrade = "P";
			if (aggregatedMark < 5)
				finalGrade = "F";
			DBHelper.addNewEnrolment(studentId, moduleCode, internalMark, examMark, finalGrade);
			System.out.println("Add successful!");
		}

	}

}
