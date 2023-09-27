package ra.model;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Mark {
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void inputData(List<Student> students, List<Subject> subjects) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Danh sách học sinh:");
        students.forEach(s -> System.out.println(s.getStudentId() + ". " + s.getStudentName()));
        System.out.println("Danh sách môn học:");
        subjects.forEach(s -> System.out.println(s.getSubjectId() + ". " + s.getSubjectName()));

        System.out.print("Nhập mã học sinh: ");
        int studentId = scanner.nextInt();
        System.out.print("Nhập mã môn học: ");
        String subjectId = scanner.next();

        Optional<Student> selectedStudent = students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst();
        Optional<Subject> selectedSubject = subjects.stream()
                .filter(s -> s.getSubjectId().equals(subjectId))
                .findFirst();

        if (selectedStudent.isPresent() && selectedSubject.isPresent()) {
            this.student = selectedStudent.get();
            this.subject = selectedSubject.get();
        } else {
            System.out.println("Không tìm thấy học sinh hoặc môn học.");
            System.out.println("Vui lòng thêm học sinh và môn học trước.");
        }

        System.out.print("Nhập điểm số: ");
        this.point = scanner.nextDouble();
    }
    public void displayData() {
        System.out.println("Mã điểm: " + markId);
        System.out.println("Tên học sinh: " + student.getStudentName());
        System.out.println("Tên môn học: " + subject.getSubjectName());
        System.out.println("Điểm số: " + point);
    }
}
