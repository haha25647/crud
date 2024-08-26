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
import java.util.List;

@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService ss = new StudentService();
        List<Student> students = ss.findAll();
        pageBean pageBean = new pageBean();

        request.setAttribute("students", students);
        request.getRequestDispatcher("showStudent.jsp").forward(request, response);
    }
}
