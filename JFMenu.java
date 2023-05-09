package a2_1901040029;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JFMenu extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu studentMenu;
	private JMenu moduleMenu;
	private JMenu enrolmentMenu;
	private JMenuItem exitItem;
	private JMenuItem newStudentItem;
	private JMenuItem listStudentItem;
	private JMenuItem newModuleItem;
	private JMenuItem listModuleItem;
	private JMenuItem newEnrolmentItem;
	private JMenuItem iniReportItem;
	private JMenuItem assessReportItem;

	public JFMenu() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenSize.width, screenSize.height);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		studentMenu = new JMenu("Student");
		studentMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		moduleMenu = new JMenu("Module");
		moduleMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		enrolmentMenu = new JMenu("Enrolment");
		enrolmentMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		menuBar.add(fileMenu);
		menuBar.add(studentMenu);
		menuBar.add(moduleMenu);
		menuBar.add(enrolmentMenu);
		menuBar.setSize(screenSize.width, 100);

		exitItem = new JMenuItem("Exit");
		exitItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		exitItem.addActionListener(this);
		newStudentItem = new JMenuItem("New student");
		newStudentItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		newStudentItem.addActionListener(this);
		listStudentItem = new JMenuItem("List students");
		listStudentItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		listStudentItem.addActionListener(this);
		newModuleItem = new JMenuItem("New module");
		newModuleItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		newModuleItem.addActionListener(this);
		listModuleItem = new JMenuItem("List modules");
		listModuleItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		listModuleItem.addActionListener(this);
		newEnrolmentItem = new JMenuItem("New enrolment");
		newEnrolmentItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		newEnrolmentItem.addActionListener(this);
		iniReportItem = new JMenuItem("Initial report");
		iniReportItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		iniReportItem.addActionListener(this);
		assessReportItem = new JMenuItem("Assessment report");
		assessReportItem.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		assessReportItem.addActionListener(this);

		fileMenu.add(exitItem);
		studentMenu.add(newStudentItem);
		studentMenu.add(listStudentItem);
		moduleMenu.add(newModuleItem);
		moduleMenu.add(listModuleItem);
		enrolmentMenu.add(newEnrolmentItem);
		enrolmentMenu.add(iniReportItem);
		enrolmentMenu.add(assessReportItem);

		this.setJMenuBar(menuBar);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitItem) {
			System.exit(0);
		}

		if (e.getSource() == newStudentItem) {
			this.dispose();
			AddNewStudent addNewStudent = new AddNewStudent();
		}

		if (e.getSource() == newModuleItem) {
			this.dispose();
			AddNewModule addNewModule = new AddNewModule();
		}

		if (e.getSource() == newEnrolmentItem) {
			this.dispose();
			AddNewEnrolment addNewEnrolment = new AddNewEnrolment();
		}

		if (e.getSource() == listStudentItem) {
			this.dispose();
			ListStudents listStudents = new ListStudents();
		}
		
		if (e.getSource() == listModuleItem) {
			this.dispose();
			ListModules listModules = new ListModules();
		}
		
		if (e.getSource() == assessReportItem) {
			this.dispose();
			AssessmentReport assessmentReport = new AssessmentReport();
		}

		if (e.getSource() == iniReportItem) {
			this.dispose();
			InitialReport initialReport = new InitialReport();
		}
		
		
	}
}
