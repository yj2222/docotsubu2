package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu2";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean create(User user) {
		try {
			Class.forName ("org.h2.Driver");

		    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		    	String sql = "INSERT INTO USER (NICKNAME, EMAIL, PASSWORD) VALUES(?, ?, ?)";
		        PreparedStatement pStmt = conn.prepareStatement(sql);
		        
		        pStmt.setString(1, user.getNickName());
		        pStmt.setString(2, user.getEmail());
		        pStmt.setString(3, user.getPassword());
		        int result = pStmt.executeUpdate();
		        if (result != 1) {
		          return false;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}
}

