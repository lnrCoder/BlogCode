package com.lnr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @description
 * @Author lnrCoder
 * @Date 2019-10-31
 */
@RestController
public class TestController {

    @RequestMapping("/get")
    public String get() {
        return "hello world !";
    }
}
