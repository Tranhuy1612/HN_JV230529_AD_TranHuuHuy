package ra.service;

import ra.model.Student;

import java.util.Scanner;

public class StudentService {
    static Student[] arrStudent = new Student[100];
    static int studentCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void studentManagement() {
        while (true) {
            System.out.println(" **********************STUDENT-MANAGEMENT************************\n" +
                    "1.Thêm mới học sinh\t\t\t\t\t\t\t\t  \n" +
                    "2.Hiển thị danh sách tất cả học sinh đã lưu trữ\t\t\t\t \n" +
                    "3.Thay đổi thông tin học sinh theo mã id\t\t\t\t\t\n" +
                    "4.Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)\t\t\t\t\t\t\t\t\t\n" +
                    " 5.Thoát\n");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    changeStudentId();
                    break;
                case 4:
                    deleteStudent();
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

    public static void createStudent() {
        System.out.print("Nhập số lượng học sinh : ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrStudent[studentCount] = new Student();
            arrStudent[studentCount].inputData(scanner, arrStudent);
            studentCount++;
        }
    }

    public static void displayData() {
        for (int i = 0; i < studentCount; i++) {
            arrStudent[i].displayData();
            System.out.println();
        }
    }

    public static void changeStudentId() {
        System.out.print("Nhập mã học sinh cần chỉnh sửa thông tin: ");
        int studentIdToModify = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentCount; i++) {
            if (arrStudent[i].getStudentId() == studentIdToModify) {
                arrStudent[i].inputData(scanner, arrStudent);
                return;
            }
        }
        System.err.println("Không tìm thấy học sinh có mã " + studentIdToModify);
    }

    public static void deleteStudent() {
        System.out.println("nhập mã học sinh cần xóa :");
        int studentIdDelete = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentCount; i++) {
            if (arrStudent[i].getStudentId() == studentIdDelete) {
                for (int j = 0; j < studentCount - 1; j++) {
                    arrStudent[j] = arrStudent[j + 1];
                }
                studentCount--;
                System.out.println("Học sinh có mã :" + studentIdDelete + "Đã bị xóa");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có mã " + studentIdDelete);
    }
}
