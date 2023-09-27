package ra.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private Date birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
    }

    public Student(int studentId, String studentName, Date birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputData(Scanner scanner, Student[] arrStudent) {
        System.out.println("nhập mã học sinh :");
        studentId = Integer.parseInt(scanner.nextLine());

        do {
            System.out.println("Nhập tên học sinh : ");
            studentName = scanner.nextLine();
            if (studentName.trim().isEmpty()) {
                System.err.println("Tên học sinh không được để trống. Vui lòng nhập lại.");
            }
        } while (studentName.trim().isEmpty());

        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String dateStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                this.birthDay = dateFormat.parse(dateStr);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }

        do {
            System.out.println("Nhập địa chỉ :");
            address = scanner.nextLine();
            if (address.trim().isEmpty()) {
                System.err.println("Địa chỉ không được để trống. Vui lòng nhập lại.");
            }
        } while (address.trim().isEmpty());

        System.out.println("Giới tính :");
        gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("nhập số điện thoại :");
        this.phone = scanner.nextLine();
        if (phone.length() == 10 || phone.length() == 11) {
            if (phone.startsWith("0")) {
            } else {
                System.out.println("Số điện thoại phải bắt đầu bằng số 0. Vui lòng nhập lại.");
            }
        } else {
            System.out.println("Số điện thoại phải có 10 hoặc 11 số. Vui lòng nhập lại.");
            this.phone = scanner.nextLine();
        }
    }

    public void displayData() {
        System.out.println("Mã học sinh :" + studentId + "| Tên học sinh :" + studentName + " | Ngày sinh : " + birthDay
                + " | Địa chỉ :" + address + " | Giới tính :" + (gender ? "nam" : "nữ") + " | số điện thoại :" + phone);
    }

}
