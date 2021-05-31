package com.joker.demo.controller;


import com.joker.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/images", method = RequestMethod.POST)
    public String images(List<MultipartFile> file){
        String result = "";
        result = getDescribe(file, result);
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String image(User user){
        String result = user.getNickname();
        List<MultipartFile> avatar = user.getAvatar();
        List<MultipartFile> background = user.getBackground();
        result = getDescribe(avatar,result);
        result = getDescribe(background,result);
        return result;
    }

    private String getDescribe(List<MultipartFile> fileList,String result){
        for (MultipartFile multipartFile : fileList) {
            String originalFilename = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();
            result = result.concat(originalFilename).concat(" -size- ").concat(String.valueOf(size)).concat("; ");
        }
        return result;
    }


}
