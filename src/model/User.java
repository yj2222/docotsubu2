package model;

import java.io.Serializable;

public class User implements Serializable {
	private String nickName;
	private String email;
	private String password;

	public User() {

	}

	public User(String nickName, String email, String password) {
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
