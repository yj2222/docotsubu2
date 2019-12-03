package model;

import dao.UserDAO_Production;

public class PostUserLogic {
//	public boolean execute(User user) {
//	    UserDAO dao = new UserDAO();
//	    return dao.create(user);
//	}
	public boolean execute(User user) {
		UserDAO_Production daoProduction = new UserDAO_Production();
    return daoProduction.create(user);
	}
}
