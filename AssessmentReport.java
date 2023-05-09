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

public class AssessmentReport extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable enrolment;
	private JButton btnReturn;

	/**
		 * Create the frame.
		 */
		public AssessmentReport() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setTitle("Assessment Report");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(screenSize.width, screenSize.height);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			enrolment = new JTable();
			enrolment.setEnabled(false);
			enrolment.setModel(DBHelper.displayAssessmentReport(enrolment));
			enrolment.setRowHeight(120);
			enrolment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			enrolment.setSize(screenSize.width, 800);
			JScrollPane sp = new JScrollPane(enrolment);
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
