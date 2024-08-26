package dao;

import beans.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    //查询全部学生
    //因为数据库表student中没有college和course这两项，而这两个属性值默认为空
    //所以查询到的数据封装为Student对象后，上面属性值都为 null
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    List<Student> students = null;
    Student student = null;
    public List<Student> findAll() {
        try {
            students = qr.query("select * from student", new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> findByName(String sname) {
        try {
            /**
             * 如果模糊匹配查询不到可能是字符编码导致的错误
             * 原因：jdbc的url没有添加utf-8的编码设置。
             * 解决方法：在jdbc配置文件中添加参数 characterEncoding=utf-8&&useUnicode=true
             */
            students = qr.query("SELECT * FROM student WHERE sname LIKE ?", new BeanListHandler<Student>(Student.class), "%" + sname + "%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public void deleteBySno(int sno) {
        try {
            qr.update("DELETE FROM student WHERE sno = ?",sno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Student student) {
        try {
            qr.update("INSERT INTO student VALUES(?,?,?,?,?)",
                    student.getSno(),student.getSname(),student.getSgender(),
                    student.getSbirthday(),student.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student findBySno(int sno) {
        try {
            student = qr.query("SELECT * FROM student WHERE sno = ?",
                    new BeanHandler<Student>(Student.class), sno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    public void update(Student student, String[] cons) {
        try {
            qr.update("UPDATE student SET sname = ?, sgender = ?, sbirthday = ?, cid = ? WHERE sno = ?",
                    student.getSname(),student.getSgender(),
                    student.getSbirthday(),student.getCid(),student.getSno());

            //删除原有的选课信息
            studentCourseDao.deleteBySno(student.getSno());

            //添加新的选课信息
            for (String con : cons) {
                studentCourseDao.save(student.getSno(),Integer.parseInt(con));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param beginIndex 查询的起始索引
     * @param pageSize  每页查询的条数
     * @return  查询到本页的学生数据集合
     */
    public List<Student> findByPage(int beginIndex, int pageSize) {
        try {
            students = qr.query("SELECT * FROM student limit ?,?",new BeanListHandler<Student>(Student.class),
                    beginIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public long count(){
        Long count = null;
        try {
            count = qr.query("select count(*) from student",new ScalarHandler<Long>());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
