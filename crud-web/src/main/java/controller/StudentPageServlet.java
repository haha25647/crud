package controller;

import beans.Student;
import beans.pageBean;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentPageServlet")
public class StudentPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        if (currentPage == null) {
            currentPage = "1";
        }
        StudentService studentService = new StudentService();
        pageBean<Student> pageBean = studentService.findAllByPage(Integer.parseInt(currentPage),5);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/showStudent.jsp").forward(request, response);
    }
}
