package ra.run;

import java.util.Scanner;

import static ra.service.StudentService.studentManagement;
import static ra.service.SubjectService.subjectManagement;


public class SchoolManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("************************SCHOOLS-MANAGEMENT*************************\n" +
                    "1. Quản lý học sinh\t\n" +
                    "2. Quản lý môn học\t\n" +
                    "3 .Quản lí điểm thi\t\n" +
                    "4 .Thoát\t");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    subjectManagement();
                    break;
                case 3:
                    markManagement();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static void markManagement() {
        while (true) {
            System.out.println("1.Thêm mới điểm thi cho 1 sinh viên\t\t\t\t\t\t\n" +
                    "2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần\t\t    \n" +
                    "3.Thay đổi điểm theo mã id\t\t\t\t\t\t\t\n" +
                    "4.Xóa điểm theo mã id\t\t\t\t\t\t\t\n" +
                    "5.Hiển thị danh sách điểm thi theo mã môn học \n" +
                    "6.Hiển thị đánh giá học lực của từng học sinh theo mã môn học (giả sử <5 là yếu ," +
                    " <=6.5 là trung bình, <= 8 là khá, <= 9 là giỏi, còn lại là xuất sắc).\n");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}

