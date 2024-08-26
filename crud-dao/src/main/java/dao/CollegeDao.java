package dao;

import beans.College;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CollegeDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    //根据id查询所在学院信息
    public College findById(int id) {
        College college = null;
        try {
            college = qr.query("SELECT * FROM college WHERE id = ?",
                    new BeanHandler<>(College.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return college;
    }
    public List<College> findAll() {
        List<College> colleges = null;
        try {
            colleges = qr.query("SELECT * FROM college", new BeanListHandler<College>(College.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }
}
