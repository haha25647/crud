package dao;

import beans.Course;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
public class CourseDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    List<Course> courses = null;
    public List<Course> findAllBySno(int sno) {
        try {
            courses = qr.query("SELECT * FROM course WHERE cno in (SELECT cno FROM student_course WHERE sno = ?)",
                    new BeanListHandler<>(Course.class), sno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public List<Course> findAll() {
        try {
            courses = qr.query("SELECT * FROM course", new BeanListHandler<Course>(Course.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
