import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class DanhSachSinhVien implements Serializable {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<SinhVien> danhSach = new ArrayList<>();

    private final WriteAndRead writeAndRead;


    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>();
        writeAndRead = new WriteAndRead();
        danhSach = writeAndRead.read();
    }

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach, WriteAndRead writeAndRead) {
        this.danhSach = danhSach;
        this.writeAndRead = writeAndRead;
    }

    public void themSinhVien(SinhVien sv) {
        this.danhSach.add(sv);
    }

    public void themSinhVienVaoDanhSach() {
        System.out.println("Nhập mã sinh viên");
        String maSinhVien = scanner.nextLine();

        System.out.println("Nhập họ và tên");
        String hoVaTen = scanner.nextLine();

        System.out.println("Nhập năm sinh");
        int namSinh = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập điểm trung bình");
        int diemTrungBinh = Integer.parseInt(scanner.nextLine());

        SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
        danhSach.add(sv);
        writeAndRead.write(danhSach);
    }

    public void show() {
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }

    public void editSinhVien() {
        System.out.println("Nhập id sinh viên cần sửa");
        String maSinhVien = String.valueOf(scanner.nextLine());
        int findIndex = findIndex(maSinhVien);
        if (findIndex != -1) {
            System.out.println("Nhập họ và tên");
            String hoVaTen = scanner.nextLine();
            System.out.println("Nhập năm sinh");
            int namSinh = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập điểm trung bình");
            int diemTrungBinh = Integer.parseInt(scanner.nextLine());
            SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
            edit(findIndex, sv);
            show();
        }
    }

    public void edit(int index, SinhVien sv1) {
        this.danhSach.set(index, sv1);
    }

    public int findIndex(String masinhvien) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (masinhvien.equals(danhSach.get(i).getMaSinhVien())) {
                return i;
            }
        }
        return -1;
    }

    public void timSinhVienTheoTen() {
        System.out.println("Nhập họ và tên ");
        String hoVaTen = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm");
        timSinhVien(hoVaTen);
    }

    public void timSinhVien(String ten) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getHoVaTen().equals(ten)) {
                System.out.println(danhSach.get(i));
            }
        }
    }

    public boolean check() {
        return this.danhSach.isEmpty();
    }

    public int laySoLuongSinhVien() {
        return this.danhSach.size();
    }


    public void lamRongDanhSach() {
        this.danhSach.clear();
    }


    public void xoaSinhVienKhoiDanhSach() {
        System.out.println("Nhập mã sinh viên");
        String maSinhVien = scanner.nextLine();
        SinhVien sv = new SinhVien(maSinhVien);
        xoaSinhVien(sv);
        show();
        writeAndRead.write(danhSach);
    }

    public void xoaSinhVien(SinhVien sv) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSinhVien().equals(sv.getMaSinhVien())) {
                danhSach.remove(i);
            }
        }
    }

    public void kiemTraSinhVienCoTrongDanhSach() {
        System.out.println("Nhập mã sinh viên: ");
        String maSinhVien = scanner.nextLine();
        SinhVien sv = new SinhVien(maSinhVien);
        System.out.println("Kiếm tra sinh viên có trong danh sách: " + kiemTraTonTai(sv));
    }

    public String kiemTraTonTai(SinhVien sv) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSinhVien().equals(sv.getMaSinhVien())) {
                return danhSach.get(i).toString();
            }
        }
        return "Không có sinh viên đấy trong danh sách";
    }


    public void sapXepSinhVienTheoDiem() {
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.getDiemTrungBinh() < o2.getDiemTrungBinh()) {
                    return -1;
                } else if (o1.getDiemTrungBinh() > o2.getDiemTrungBinh()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}