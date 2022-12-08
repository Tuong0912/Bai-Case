import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWrite {
    public ReadAndWrite() {
    }

    public static void write(Map<String, String> dstk) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\Module-2\\QuanlySV\\src\\taikhoan.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dstk);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public static Map<String, String> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\Module-2\\QuanlySV\\src\\taikhoan.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, String>) objectInputStream.readObject();
        } catch (Exception var2) {
            return new HashMap<>();
        }
    }

}
