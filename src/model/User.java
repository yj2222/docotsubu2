package model;

import java.io.Serializable;

public class User implements Serializable {
	private String nickName;
	private String email;
	private String password;
	private String failMsg = "※ユーザ名またはパスワードが違います。アカウントをお持ちでない方はサインインページへ移行願います。";

	public User() {

	}

	public User(String nickName, String password) {
		this.nickName = nickName;
		this.password = password;
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

	public String getFailMsg() {
		return failMsg;
	}

}
