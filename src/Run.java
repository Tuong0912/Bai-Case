import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        DangNhapDangKy();
    }

    DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();
    Scanner scanner = new Scanner(System.in);

    public static void DangNhapDangKy() {
        Quanlytk quanlytk = new Quanlytk();
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Đổi mật khẩu");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> quanlytk.login();
                    case 2 -> quanlytk.dangKy();
                    case 3 -> quanlytk.doiMatKhau();
                    case 4 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại");
            }
        }
    }

    public void QuanLy() {
        while (true) {
            System.out.println("--------MENU--------");
            System.out.println("0. Exit ");
            System.out.println("1. Thêm sinh viên vào danh sách ");
            System.out.println("2. Hiển thị danh sách sinh viên ra màn hình ");
            System.out.println("3. Kiểm tra danh sách có rỗng hay không  ");
            System.out.println("4. Lấy số lượng sinh viên trong danh sách ");
            System.out.println("5. Làm rỗng danh sách sinh viên");
            System.out.println("6. Kiểm tra sinh viên có tồn tại trong danh sách hay không dựa trên mã sinh viên ");
            System.out.println("7. Xóa 1 sinh viên dựa trên mã sinh viên");
            System.out.println("8. Tìm tất cả sinh viên dựa trên Tên được nhập từ bàn phím ");
            System.out.println("9. Xuất ra danh sách sinh viên có điểm từ thấp đến cao");
            System.out.println("10. Chỉnh sửa sinh viên theo mã sinh viên");
            System.out.println("12. Đăng xuất");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 0 -> System.exit(0);
                    case 1 -> danhSachSinhVien.themSinhVienVaoDanhSach();
                    case 2 -> danhSachSinhVien.show();
                    case 3 -> System.out.println("Kiem tra danh sach rong : " + danhSachSinhVien.check());
                    case 4 ->
                            System.out.println("So luong sinh vien hien tai : " + danhSachSinhVien.laySoLuongSinhVien());
                    case 5 -> {
                        System.out.println("Danh sách trước khi làm rỗng :");
                        danhSachSinhVien.show();
                        System.out.println("Danh sách sau khi làm rỗng :");
                        danhSachSinhVien.lamRongDanhSach();
                    }
                    case 6 -> danhSachSinhVien.kiemTraSinhVienCoTrongDanhSach();
                    case 7 -> danhSachSinhVien.xoaSinhVienKhoiDanhSach();
                    case 8 -> danhSachSinhVien.timSinhVienTheoTen();
                    case 9 -> {
                        danhSachSinhVien.sapXepSinhVienTheoDiem();
                        danhSachSinhVien.show();
                    }
                    case 10 -> danhSachSinhVien.editSinhVien();
                    case 11 -> System.out.println("Chưa có gì hết á :))");
                    case 12 -> {
                        DangNhapDangKy();
                        scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.out.println("Chỉ nhập số từ 0 -> 12 , trừ 11 :))");
            }
        }
    }
}