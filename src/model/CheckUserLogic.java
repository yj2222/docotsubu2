package model;

import dao.UserDAO_Production;

public class CheckUserLogic {
//	public User execute(User user) {
//    UserDAO dao = new UserDAO();
//    return dao.findUser(user);
//	}

	// Production環境用DAO呼び出し。
	public User execute(User user) {
    UserDAO_Production daoProduction = new UserDAO_Production();
    return daoProduction.findUser(user);
	}
}
