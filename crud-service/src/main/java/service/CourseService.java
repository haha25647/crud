package service;

import beans.Course;
import dao.CourseDao;

import java.util.List;

public class CourseService {
    CourseDao courseDao = new CourseDao();
    public List<Course> findAll(){
        return courseDao.findAll();
    }
    public List<Course> findAllById(int sno){
        return courseDao.findAllBySno(sno);
    }
}
