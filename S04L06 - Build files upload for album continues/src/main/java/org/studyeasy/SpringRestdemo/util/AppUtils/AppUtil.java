package org.studyeasy.SpringRestdemo.util.AppUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppUtil {
    public static String get_photo_upload_path(String fileName, long album_id) throws IOException{
        Files.createDirectories(Paths.get("src\\main\\resources\\static\\uploads\\"+album_id));
        return new File("src\\main\\resources\\static\\uploads\\"+album_id).getAbsolutePath() + "\\" + fileName;

    }
    
    
}
