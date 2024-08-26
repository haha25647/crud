package controller;

import beans.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.request.getParameter()方法中的name参数对应页面表单中name属性
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//2.将页面提交的数据进行对象的封装,将对象交给service层做业务处理
		UserService userService = new UserService();
		User user = userService.login(new User(username, password));

		//3.根据DAO=>Service=>Web返回的User对象来判断
		if (user != null) {
			request.getSession().setAttribute("existUser",user);
            response.sendRedirect(request.getContextPath()+"/StudentPageServlet");
		} else {
            request.setAttribute("user",new User(username,password));//将来在页面回显用户输错的用户名和密码
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
