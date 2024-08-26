package service;

import beans.College;
import beans.Course;
import beans.Student;
import beans.pageBean;
import dao.CollegeDao;
import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    private CollegeDao collegeDao = new CollegeDao();

    private CourseDao courseDao = new CourseDao();

    private StudentCourseDao studentCourseDao = new StudentCourseDao();


    public List<Student> findAll() {
        List<Student> students = studentDao.findAll();
        findCollegeAndCourse(students);
        return students;
    }

    private void findCollegeAndCourse(List<Student> students) {
        //若不进行该操作，则封装的学生对象中 college 和 course 都为空
        for (Student student : students) {
            //根据student的cid=College的id 来确定学院
            College college = collegeDao.findById(student.getCid());
            student.setCollege(college);

            List<Course> courses = courseDao.findAllBySno(student.getSno());
            student.setCourses(courses);
        }
    }

    public List<Student> findByName(String sname) {
        List<Student> students = studentDao.findByName(sname);
        findCollegeAndCourse(students);
        return students;
    }

    public void deleteBySno(int sno) {
        //因为删除了学生信息的话，对于学院数据库表来说没有多少影响，cid对应着id
        //而对于课程表来说，其中学号sno对应的课程course依旧存在，所以需要将其删除

        //删除学生信息
        studentDao.deleteBySno(sno);

        //删除学生对应的课程信息，避免造成数据冗余
        studentCourseDao.deleteBySno(sno);
    }

    public void save(Map<String, String[]> parameterMap) {
        String sbirthday = parameterMap.get("sbirthday")[0];
        Date date = null;
        try {
            date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(sbirthday).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //因为在数据库中的student表中，没有college和courses这两列，所以只能先将其余的保存到表中，course另外添加
        Student student = new Student(Integer.parseInt(parameterMap.get("sno")[0]),
                parameterMap.get("sname")[0],
                parameterMap.get("sex")[0],
                date,
                Integer.parseInt(parameterMap.get("id")[0]));

        //2.调用studentDao将页面中学生表相关的信息保存
        studentDao.save(student);

        //3.将学生的选课信息保存选课表
        String[] cnos = parameterMap.get("selectedCourse");
        for (String cno : cnos) {

            //4.每遍历一个课程号,就将改学生的学号和课程号保存到选课表中
            studentCourseDao.save(Integer.parseInt(parameterMap.get("sno")[0]),
                    Integer.parseInt(cno));
        }
    }

    public Student findBySno(int sno) {
        Student student = studentDao.findBySno(sno);
        College college = collegeDao.findById(student.getCid());
        student.setCollege(college);

        List<Course> courses = courseDao.findAllBySno(student.getSno());
        student.setCourses(courses);
        return student;
    }

    public void update(Map<String, String[]> parameterMap) {
        String[] cons = parameterMap.get("selectedCourse");
        String sbirthday = parameterMap.get("sbirthday")[0];
        Date date = null;
        try {
            date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(sbirthday).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(Integer.parseInt(parameterMap.get("sno")[0]),
                parameterMap.get("sname")[0],
                parameterMap.get("sex")[0],
                date,
                Integer.parseInt(parameterMap.get("id")[0]));
        //更新学生表的信息,更新课表的信息，采用先删除，再添加
        studentDao.update(student,cons);
    }

    /**
     *
     * @param currentPage 当前页码
     * @param pageSize  每页显示的条数
     * @return  返回一个pageBean<Student>对象，该对象中封装分页相关的参数以及当前页的数据
     */
    public pageBean<Student> findAllByPage(int currentPage, int pageSize) {
        int beginIndex = (currentPage-1)*pageSize;
        List<Student> students = studentDao.findByPage(beginIndex,pageSize);
        findCollegeAndCourse(students);
        long count = studentDao.count();
        return new pageBean<Student>(currentPage,pageSize,count,students);
    }
}
