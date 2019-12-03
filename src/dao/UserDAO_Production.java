package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO_Production {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}

	public boolean create(User user) {

		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			// データベースへ接続
			try(Connection conn = getConnection()) {
				String sql = "INSERT INTO USER (NICKNAME, EMAIL, PASSWORD) VALUES(?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getNickName());
				pStmt.setString(2, user.getEmail());
				pStmt.setString(3, user.getPassword());
				int result = pStmt.executeUpdate();
				if (result != 1) {
					return false;
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return false;
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

	public User findUser(User user) {
		User findedUser = null;

		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			// データベースへ接続
			try(Connection conn = getConnection()) {
				// SELECT文を準備
				String sql = "SELECT * FROM account WHERE nickname = ? AND password = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getNickName());
				pStmt.setString(2, user.getPassword());
				// SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery();
				// 一致したユーザーが存在した場合
				// そのユーザーを表すAccountインスタンスを生成
				if (rs.next()) {
				// 結果表からデータを取得
					String nickName = rs.getString("nickname");
					String email = rs.getString("email");
					String password = rs.getString("password");
					findedUser = new User(nickName, email, password);
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
		return findedUser;
	}

}

