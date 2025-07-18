package org.studyeasy.SpringRestdemo.util.AppUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import org.springframework.web.multipart.MultipartFile;
import org.imgscalr.Scalr;

public class AppUtil {
    public static String get_photo_upload_path(String fileName, String folder_name, long album_id) throws IOException{
        String path = "src\\main\\resources\\static\\uploads\\"+album_id+"\\"+folder_name;
        Files.createDirectories(Paths.get(path));
        return new File(path).getAbsolutePath() + "\\" + fileName;

    }

    public static BufferedImage getThumbnail(MultipartFile orginalFile, Integer width) throws IOException{  
        BufferedImage thumbImg = null;  
        BufferedImage img = ImageIO.read(orginalFile.getInputStream());  
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);   
        return thumbImg;  
    }
    
    
}
