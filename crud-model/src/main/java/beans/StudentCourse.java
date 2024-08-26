package beans;

public class StudentCourse {
    private int sno;
    private int cno;

    public StudentCourse() {
    }

    public StudentCourse(int sno, int cno) {
        this.sno = sno;
        this.cno = cno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "sno=" + sno +
                ", cno=" + cno +
                '}';
    }
}
