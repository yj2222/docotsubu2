package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostUserLogic;
import model.User;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
		dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータ取得
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// JavaBeanz呼び出し。ユーザ情報をセット。
		User user = new User(nickName, email, password);
		// DB保存のインスタンス生成
		PostUserLogic postUserLogic = new PostUserLogic();
		// 新規作成のmodel実行
		if (postUserLogic.execute(user)) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signInOK.jsp");
		dispatcher.forward(request, response);
		} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
		dispatcher.forward(request, response);
		}
  }
}
