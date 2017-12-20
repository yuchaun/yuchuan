package com.jltour.utils;

import com.google.common.io.Files;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzhaolin on 2017/5/20.
 */
public class FileUtils {

    public static List<String> getImageSuffixList(){
        List<String> suffixList = new ArrayList<String>();
        suffixList.add("png");
        suffixList.add("jpg");
        suffixList.add("jpeg");
        suffixList.add("gif");
        suffixList.add("bmp");
        return suffixList;
    }


    public static boolean isImageFile(MultipartFile file) {
        if (file != null && !file.isEmpty() && imageValidate(Files.getFileExtension(file.getOriginalFilename()))){
            return true;
        }else{
            return false;
        }
    }

    public static boolean imageValidate(String contentType){
        List<String> suffixList = getImageSuffixList();
        if(!suffixList.contains(contentType.toLowerCase())){
            return false;
        }else{
            return true;
        }
    }
}
