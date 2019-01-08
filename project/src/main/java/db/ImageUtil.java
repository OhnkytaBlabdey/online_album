package db;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageUtil {
    public static final String JPG = "jpg";
    public static final String PNG = "png";
    public static final String BMP = "bmp";
    public static final String GIF = "gif";

    public static void showImage(HttpServletResponse response, String path, boolean isResponseClose){
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(path);
            byte data[] = new byte[5000];
            while (fileInputStream.read(data) > 0){
                outputStream.write(data);
            }
            fileInputStream.close();
            response.setContentType("image/*");
            outputStream.write(data);
            if(isResponseClose){
                outputStream.close();;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
