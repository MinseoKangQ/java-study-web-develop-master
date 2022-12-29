package Part2_Ch04._02;

// Object 클래스의 메서드 활용

public class EqualsTest {

    public static void main(String [] args) throws CloneNotSupportedException {

        Student std1 = new Student(100, "Lee");
        Student std2 = new Student(100, "Lee");

        System.out.println(std1 == std2);
        System.out.println(std1.equals(std2)); // 재정의

        // 학번 리턴하도록 함
        System.out.println(std1.hashCode());
        System.out.println(std2.hashCode());

        // 객체의 실제 해시코드 알아내기
        System.out.println(System.identityHashCode(std1));
        System.out.println(System.identityHashCode(std2));

        // 객체 복사
        std1.setStudentName("Kim");
        Student copyStudent = (Student)std1.clone();
        System.out.println(copyStudent);
    }
}
