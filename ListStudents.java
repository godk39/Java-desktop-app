package a2_1901040029;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListStudents extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable student;
	private JButton btnReturn;

	/**
	 * Create the frame.
	 */
	public ListStudents() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("List students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenSize.width, screenSize.height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		student = new JTable();
		student.setEnabled(false);
		student.setModel(DBHelper.displayListStudent(student));
		student.setRowHeight(120);
		student.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		student.setSize(screenSize.width, 800);
		JScrollPane sp = new JScrollPane(student);
		sp.setSize(screenSize.width, 600);
		contentPane.add(sp);

		btnReturn = new JButton("Return");
		btnReturn.setBounds(850, 700, 200, 80);
		btnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnReturn.addActionListener(this);
		contentPane.add(btnReturn);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnReturn) {
			this.dispose();
			JFMenu jfMenu = new JFMenu();
		}
	}

}
