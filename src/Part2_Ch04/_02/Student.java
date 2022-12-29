package Part2_Ch04._02;

public class Student implements Cloneable {

    private int studentNum;
    private String studentName;

    public Student(int studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public String toString() {
        return (studentNum + ", " + studentName);
    }

    // 논리적으로 같음을 재정의
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student std = (Student)obj; // 다운캐스팅
            if (this.studentNum == std.studentNum)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentNum;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
