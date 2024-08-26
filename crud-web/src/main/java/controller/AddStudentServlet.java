package controller;

import beans.College;
import beans.Course;
import service.CollegeService;
import service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 查询所有的学院以及所有的课程
        CourseService courseService = new CourseService();
        List<Course> courses = courseService.findAll();
        CollegeService collegeService = new CollegeService();
        List<College> colleges = collegeService.findAll();

        //2.将查询到的数据存储到请求域中，并携带信息转发到addStudent.jsp中
        request.setAttribute("courses", courses);
        request.setAttribute("colleges", colleges);
        request.getRequestDispatcher("addStudent.jsp").forward(request, response);
    }
}
