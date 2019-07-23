package fileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 写入换行：
 *     win: \r\n
 *     linux /n
 *     mac  /r
 */

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\test\\append.txt");
        FileOutputStream fos=new FileOutputStream(file,true);

        for (int i = 0; i < 10; i++) {
            String data="第"+i+"次添加"+"\r\n";
            fos.write(data.getBytes());
        }

        fos.close();
    }
}
