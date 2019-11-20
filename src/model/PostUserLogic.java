package model;

import dao.UserDAO;

public class PostUserLogic {
	public boolean execute(User user) {
	    UserDAO dao = new UserDAO();
	    return dao.create(user);
	}
}
