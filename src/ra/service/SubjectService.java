package ra.service;

import ra.model.Subject;

import java.util.Scanner;

public class SubjectService {
    static Subject[] subjects = new Subject[20];
    static int subjectCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void subjectManagement() {
        while (true) {
            System.out.println(" **********************SUBJECT-MANAGEMENT*************************\n" +
                    "1.Thêm mới môn học\t\t\t\t\t\t\t\t \n" +
                    "2.Hiển thị danh sách tất cả môn học đã lưu trữ\t\t\t\t   \n" +
                    "3.Thay đổi thông tin học môn học theo mã id\t\t\t\t\n" +
                    "4.Xóa môn học theo mã id (kiểm tra xem nếu môn học  có điểm thi thì không xóa được)\t\t\t\t\t\t\t\t\t\t\n" +
                    " 5.Thoát\n");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createSubject();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    changeMarkId();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static void createSubject() {
        System.out.println("nhập số lượng môn học :");
        int sj = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sj; i++) {
            subjects[subjectCount] = new Subject();
            subjects[subjectCount].inputData(scanner, subjects);
            subjectCount++;
        }
    }

    public static void displayData() {
        for (int i = 0; i < subjectCount; i++) {
            subjects[i].displayData();
            System.out.println();
        }
    }

    public static void changeMarkId() {
        System.out.print("Nhập mã môn học cần chỉnh sửa thông tin: ");
        String subjectIdToModify = scanner.nextLine();

        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].getSubjectId().equals(subjectIdToModify) ) {
                subjects[i].inputData(scanner, subjects);
                return;
            }
        }
        System.err.println("Không tìm thấy môn học có mã " + subjectIdToModify);
    }

    public static void deleteSubject() {
        System.out.println("nhập mã môn học cần xóa :");
        String subjectIdDelete = scanner.nextLine();

        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i].getSubjectId().equals( subjectIdDelete)) {
                for (int j = 0; j < subjectCount - 1; j++) {
                    subjects[j] = subjects[j + 1];
                }
                subjectCount--;
                System.out.println("Môn học có mã :" + subjectIdDelete + "Đã bị xóa");
                return;
            }
        }
        System.out.println("Không tìm thấy môn học có mã " + subjectIdDelete);
    }
}

