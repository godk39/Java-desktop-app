package a2_1901040029;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBHelper {
	private static File temp = new File("src\\a2_1901040029\\database.sqlite3.db");
	private static final String JDBC_URL = "jdbc:sqlite:" + temp.getAbsolutePath().replace("\\","\\\\");

	public static void addNewStudent(String name, String dob, String address, String mail) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "INSERT INTO student (name, dob, address, mail) " + "VALUES(?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, dob);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, mail);
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
		}

	}

	public static void addNewCompulModule(String name, int semester, int credits) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "INSERT INTO compulsoryModule (name, semester, credits) " + "VALUES(?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, semester);
			preparedStatement.setInt(3, credits);
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
		}

	}

	public static void addNewModule(String name, int semester, int credits) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "INSERT INTO module (name, semester, credits) " + "VALUES(?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, semester);
			preparedStatement.setInt(3, credits);
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
		}

	}

	public static void addNewElecModule(String name, int semester, int credits, String departmentName) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "INSERT INTO electiveModule (name, semester, credits, departmentName) " + "VALUES(?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, semester);
			preparedStatement.setInt(3, credits);
			preparedStatement.setString(4, departmentName);
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
		}

	}

	public static void addNewEnrolment(int studentId, int moduleCode, double internalMark, double examMark,
			String finalGrade) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "INSERT INTO enrolment (studentId, moduleId, internalMark, examMark, finalGrade) "
					+ "VALUES(?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, moduleCode);
			preparedStatement.setDouble(3, internalMark);
			preparedStatement.setDouble(4, examMark);
			preparedStatement.setString(5, finalGrade);
			preparedStatement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
		}

	}

	public static DefaultTableModel displayListStudent(JTable student) {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT * FROM student";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) student.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(colName);

			String id, name, dob, address, mail;
			while (rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				dob = rs.getString(3);
				address = rs.getString(4);
				mail = rs.getString(5);
				String[] row = { id, name, dob, address, mail };
				model.addRow(row);
			}

			statement.close();
			connection.close();
			return model;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}

	public static DefaultTableModel displayListModule(JTable module) {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT * FROM module";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) module.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(colName);

			String id, name, semester, credits;
			while (rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				semester = rs.getString(3);
				credits = rs.getString(4);
				String[] row = { id, name, semester, credits };
				model.addRow(row);
			}

			statement.close();
			connection.close();
			return model;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}

	public static DefaultTableModel displayInitialReport(JTable enrolment) {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT enrolment.id, enrolment.studentId, "
					+ "enrolment.moduleId, student.name AS studentName, " + "module.name AS moduleName\r\n"
					+ "FROM enrolment\r\n" + "JOIN student ON enrolment.studentId = student.id\r\n"
					+ "JOIN module ON enrolment.moduleId = module.id;";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) enrolment.getModel();
			String[] colName = { "id", "Student Id", "Module code", "Student name", "Module name" };

			model.setColumnIdentifiers(colName);

			String id, studentId, moduleCode, studentName, moduleName;
			while (rs.next()) {
				id = rs.getString(1);
				studentId = rs.getString(2);
				moduleCode = rs.getString(3);
				studentName = rs.getString(4);
				moduleName = rs.getString(5);
				String[] row = { id, studentId, moduleCode, studentName, moduleName };
				model.addRow(row);
			}

			statement.close();
			connection.close();
			return model;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}

	public static DefaultTableModel displayAssessmentReport(JTable enrolment) {

		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT * FROM enrolment";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) enrolment.getModel();
			String[] colName = { "id", "Student Id", "Module code", "Internal mark", "Examination mark",
					"Final Grade" };

			model.setColumnIdentifiers(colName);

			String id, studentId, moduleCode, internalMark, examMark, finalGrade;
			while (rs.next()) {
				id = rs.getString(1);
				studentId = rs.getString(2);
				moduleCode = rs.getString(3);
				internalMark = rs.getString(4);
				examMark = rs.getString(5);
				finalGrade = rs.getString(6);
				String[] row = { id, studentId, moduleCode, internalMark, examMark, finalGrade };
				model.addRow(row);
			}

			statement.close();
			connection.close();
			return model;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}

	public static DefaultComboBoxModel<Integer> getStudentId() {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT id FROM student";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			DefaultComboBoxModel<Integer> studentId = new DefaultComboBoxModel<Integer>();
			int id;
			while (rs.next()) {
				id = rs.getInt(1);
				studentId.addElement(id);

			}

			statement.close();
			connection.close();
			return studentId;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}

	public static DefaultComboBoxModel<Integer> getModuleCode() {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL);
			String sql = "SELECT id FROM module";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			DefaultComboBoxModel<Integer> moduleCode = new DefaultComboBoxModel<Integer>();
			int code;
			while (rs.next()) {
				code = rs.getInt(1);
				moduleCode.addElement(code);

			}

			statement.close();
			connection.close();
			return moduleCode;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error connecting to db");
			e.printStackTrace();
			return null;
		}
	}
}
