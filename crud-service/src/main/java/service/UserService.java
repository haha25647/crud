package service;

import beans.User;
import dao.UserDao;

public class UserService {
	private UserDao userDao=new UserDao();

	public User login(User user) {
		//通过dao,访问数据库,进行用户查询
		return userDao.login(user);
	}
}
