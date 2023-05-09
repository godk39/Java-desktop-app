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

public class InitialReport extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable initialReport;
	private JButton btnReturn;

	/**
		 * Create the frame.
		 */
		public InitialReport() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setTitle("Initial Report");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(screenSize.width, screenSize.height);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			initialReport = new JTable();
			initialReport.setEnabled(false);
			initialReport.setModel(DBHelper.displayInitialReport(initialReport));
			initialReport.setRowHeight(120);
			initialReport.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			initialReport.setSize(screenSize.width, 800);
			JScrollPane sp = new JScrollPane(initialReport);
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
