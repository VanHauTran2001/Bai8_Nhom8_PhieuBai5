
package Bai8_Nhom8_PhieuBai5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class DBClass {
    public void luuFile(String fileName , Object object) throws Exception{
        FileOutputStream fs = new FileOutputStream(fileName);
        
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(object);
        fs.close();
        os.close();
    }
    public Object docFile(String fileName) throws Exception{
        Object kq = null;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        kq = inputStream.readObject();
        fileInputStream.close();
        inputStream.close();
        return kq;
    }
}
