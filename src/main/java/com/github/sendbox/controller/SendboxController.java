package com.github.sendbox.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/sendbox")
@Slf4j
public class SendboxController {

    @GetMapping(value = "/testException")
    public ResponseEntity getTestException(String name) throws Exception {
        if (name == null || "".equals(name))
            throw new Exception("name is null!");
        log.info("request success!");
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/getFile")
    public ResponseEntity<byte[]> getFile(String fff) {
        File file = new File("E:/test.txt");
        InputStream inputStream;
        byte[] body = new byte[1];
        try {
            inputStream = new FileInputStream(file);
            body = new byte[inputStream.available()];
            inputStream.read(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=yhwtest.csv");

        return new ResponseEntity<byte[]>(body, httpHeaders, HttpStatus.OK);
    }
}
