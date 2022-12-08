import java.io.*;
import java.util.ArrayList;

public class WriteAndRead {
    private static final String ACCOUNT_FILE_NAME = "C:\\Users\\Admin\\Module-2\\QuanlySV\\src\\sinhvien.txt";

    public void write(ArrayList<SinhVien> sinhViens){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File(ACCOUNT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sinhViens);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public ArrayList<SinhVien> read(){
        ArrayList<SinhVien> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(ACCOUNT_FILE_NAME));
            ois = new ObjectInputStream(fis);
            studentList = (ArrayList<SinhVien>) ois.readObject();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (EOFException e){
            System.out.println("");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    private void closeStream(InputStream is) {
        if (is != null){
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os){
        if (os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}