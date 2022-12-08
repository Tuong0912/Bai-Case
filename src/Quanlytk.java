import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Quanlytk {
    Scanner scanner = new Scanner(System.in);
    static Map<String, String> quanlytk = new HashMap<>();

    public Quanlytk() {
        quanlytk = ReadAndWrite.read();
    }

    public void login() {

        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(password)) {
                System.out.println("Đăng nhặp thành công");
                new Run().QuanLy(); //////////********\\\\\\\\\\
            } else {
                System.out.println("Nhập lại mật khẩu");
                String password1 = scanner.nextLine();
                if (quanlytk.get(name).equals(password1)) {
                    System.out.println("Đăng nhập thành công");
                    new Run().QuanLy();
                } else {
                    System.out.println("Đăng nhập thất bại");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Tài Khoản không tồn tại , mời bạn đăng ký hoặc đăng nhập lại");
        }
    }

    public void dangKy() {

        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu có ít nhất 1 chữ viết hoa , 1 số và 1 ký tự đặc biệt và dài từ 8 đến 15 ký tự :DD ");
        String pass = scanner.nextLine();
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,15})");
        if (!quanlytk.isEmpty() && quanlytk.containsKey(pass)) {
            System.out.println("Tài khoản đã tồn tại");
        } else if (p.matcher(pass).find()) {
            TaiKhoan taiKhoan = new TaiKhoan(name, pass);
            quanlytk.put(taiKhoan.getAcc(), taiKhoan.getPassword());
            System.out.println("Đăng kí thành công");
        } else {
            System.out.println("Mật khẩu không đủ độ an toàn , mời nhập lại ");
        }
        ReadAndWrite.write(quanlytk);
    }

    public void doiMatKhau() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(pass)) {
                System.out.println("Nhập mật khẩu mới");
                String pass1 = scanner.nextLine();

                Pattern p = Pattern.compile("((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,15})");
                if (p.matcher(pass1).find()) {
                    quanlytk.put(name, pass1);
                    System.out.println("Đổi mật khẩu thành công");
                }else {
                    System.out.println("Mật khẩu không đủ an toàn , mời nhập lại");
                }
            } else {
                System.out.println("Sai mật khẩu");
            }
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }
}