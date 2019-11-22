package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckUserLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickName = request.getParameter("nickName");
		String password = request.getParameter("password");

		User user = new User(nickName, password);
		CheckUserLogic checkUser = new CheckUserLogic();

		if (checkUser.execute(user) != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signInOK.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginFail.jsp");
			dispatcher.forward(request, response);
		}
	}
}
