package service;

import beans.College;
import dao.CollegeDao;

import java.util.List;

public class CollegeService {
    CollegeDao collegeDao = new CollegeDao();
    public List<College> findAll() {
        return collegeDao.findAll();
    }
    public College findById(int sno) {
        return collegeDao.findById(sno);
    }
}
