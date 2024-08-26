package controller;

import beans.College;
import beans.Course;
import beans.Student;
import service.CollegeService;
import service.CourseService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收页面传递过来的sno
        String sno = request.getParameter("sno");
        //2.根据sno查询该学生所有信息
        StudentService studentService = new StudentService();
        Student student = studentService.findBySno(Integer.parseInt(sno));
        //3.查询所有学院
        CollegeService collegeService = new CollegeService();
        List<College> colleges = collegeService.findAll();
        //4.查询所有课程
        CourseService courseService = new CourseService();
        List<Course> courses = courseService.findAll();
        //5.学生信息存放到域中（回显数据）
        request.setAttribute("student", student);
        request.setAttribute("colleges", colleges);
        request.setAttribute("courses", courses);

        request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
    }
}
