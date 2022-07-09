package com.wzl.controller;


import com.wzl.entity.User;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
public class UploadController {
    @PostMapping("/fileUpload")
    public String threeFileUpload(
            @RequestParam("file") CommonsMultipartFile files[],
            HttpServletRequest request, ModelMap model) {

        List<String> list = new ArrayList<String>();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path ="C:\\nginx-1.22.0\\html\\images\\";
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        String newFileName="";
        for (int i = 0; i < files.length; i++) {
            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String[] str=fileName.split("\\.");
            int len = str.length;
            fileName = "."+fileName.split("\\.")[len-1];
            newFileName = UUID.randomUUID()+fileName;
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + newFileName);
            list.add(path + newFileName);

        }
        // 保存文件地址，用于JSP页面回显--------但我不做JSP了~~

        return newFileName;
    }
}
