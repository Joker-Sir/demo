package com.joker.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 处理404异常
 * */
@Controller
@Slf4j
public class ErrorMappingHandler implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public String handError(HttpServletResponse response){
        if (response.getStatus() == 404){
            log.info("404Error");
        }
        return "not found";
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
