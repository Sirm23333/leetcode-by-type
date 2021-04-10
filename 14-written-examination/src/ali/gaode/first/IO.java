package ali.gaode.first;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

//读取一个网络url 将内容写到本地文件
public class IO {
    public void save(String url , String filePath) throws Exception {
        URL u = null;
        File file = null;
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try{
            u = new URL(url);
            file = new File(filePath);
            fileOutputStream = new FileOutputStream(file);
            inputStream = u.openStream();
            byte[] b = new byte[1024];
            int len = 0;
            while((len = inputStream.read(b)) > -1){
                fileOutputStream.write(b,0,len);
            }
        }finally {
            fileOutputStream.close();
            inputStream.close();
        }
    }
}
