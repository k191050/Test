import java.sql.*;

public class Data {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql:///new_schema";
		final String user = "root";
		final String password = "fast1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		if (con == null) {
		System.out.println("JDBC Connection is not established");
		return;
		} else {
		System.out.println("Congratulations," + "JDBC con done");
		}
		
		// insert query
//		PreparedStatement st = con.prepareStatement(q2);
		String q2 = "insert into person values ('35', 'baji2')";
		PreparedStatement st = con.prepareStatement(q2);
		int count = st.executeUpdate();
		
		// update query
		int id = 100;
		String name = "b";
		String q3 = "UPDATE person SET id = ? WHERE name = ?";
		PreparedStatement st2 = con.prepareStatement(q3);
		st2.setInt(1, id);
		st2.setString(2, name);
		int count2 = st2.executeUpdate();
//		
		// delete query
		String q4 = "Delete from person where id = 3";
		PreparedStatement st3 = con.prepareStatement(q4);
		int count3 = st3.executeUpdate();
		
		// select query
		String query = "select * from person";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		con.close();
	}
}