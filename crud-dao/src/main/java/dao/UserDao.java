package dao;

import beans.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import java.sql.SQLException;

public class UserDao {
	public User login(User user){
        //查询数据
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User existUser = null;
		try {
			existUser = qr.query("SELECT * FROM `user` WHERE username=? AND password=?",
					new BeanHandler<User>(User.class),
					user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existUser;
	}
}
