package beans;

import java.sql.Date;
import java.util.List;

public class Student {
    private int sno;
    private String sname;
    private String sgender;
    private Date sbirthday;
    /*学院编号*/
    private int cid;

    /*一个学生属于一个学院*/
    private College college;

    /*一个学生可以选择多门课程*/
    private List<Course> courses;

    public Student() {
    }

    public Student(int sno, String sname, String sgender, Date sbirthday, int cid, College college, List<Course> courses) {
        this.sno = sno;
        this.sname = sname;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.cid = cid;
        this.college = college;
        this.courses = courses;
    }

    public Student(int sno, String sname, String sgender, Date sbirthday, int cid) {
        this.sno = sno;
        this.sname = sname;
        this.sgender = sgender;
        this.sbirthday = sbirthday;
        this.cid = cid;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sbirthday=" + sbirthday +
                ", cid=" + cid +
                ", college=" + college +
                ", courses=" + courses +
                '}';
    }
}
