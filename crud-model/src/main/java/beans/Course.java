package beans;

public class Course {
    private int cno;
    private String cname;
    public Course() {}
    public Course(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
