import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ConnectionBean;
import bean.userBean;

/**
 * @author Svitter
 *
 */
@SuppressWarnings("serial")
public class  LoginServlet extends HttpServlet {
	userBean user =  new userBean();
	ConnectionBean connBean = new ConnectionBean();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String checkLogin;
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		checkLogin = connBean.checkUser(username, password);
		if(checkLogin.equals("Success")) {
			user.setUserName(username);
			request.setAttribute("user", user);
			getServletConfig().getServletContext().getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		connBean.addUser(username, password);
		getServletConfig().getServletContext().getRequestDispatcher("/login.html").forward(request, response);
	}
}