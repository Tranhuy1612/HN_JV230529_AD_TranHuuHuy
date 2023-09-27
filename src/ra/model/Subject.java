package ra.model;

import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData(Scanner scanner, Subject[] subjects) {
        System.out.print("Nhập mã môn học : ");
        this.subjectId = scanner.nextLine();
        while (!subjectId.matches("MH\\d{3}")) {
            System.err.println("Mã môn học không hợp lệ . nhập lại");
            this.subjectId = scanner.nextLine();
        }

        do {
            System.out.println("Nhập Tên môn học  :");
            subjectName = scanner.nextLine();
            if (subjectName.trim().isEmpty()) {
                System.err.println("Mô tả không được để trống. Vui lòng nhập lại.");
            }
        } while (subjectName.trim().isEmpty());

    }

    public void displayData() {
        System.out.println("Mã môn học :" + subjectId + " | Tên môn học :" + subjectName);
    }

}
