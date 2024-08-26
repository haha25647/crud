package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.JDBCUtils;

import java.sql.SQLException;

public class StudentCourseDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    public void deleteBySno(int sno) {
        try {
            qr.update("DELETE FROM student_course WHERE sno = ?",sno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(int sno, int cno) {
        try {
            qr.update("INSERT INTO student_course VALUES(?,?)",sno,cno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
