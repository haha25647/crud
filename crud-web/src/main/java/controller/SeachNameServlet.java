package controller;

import beans.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SeachNameServlet")
public class SeachNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("seachName");
        //Controller模块应与service层交互，而不应直接与Dao层交互
        //StudentDao sd = new StudentDao();
        StudentService ss = new StudentService();
        List<Student> students=ss.findByName(searchName);
        request.setAttribute("students", students);
        request.getRequestDispatcher("showStudent.jsp").forward(request, response);
    }
}
