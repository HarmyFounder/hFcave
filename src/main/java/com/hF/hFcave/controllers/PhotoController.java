package com.hF.hFcave.controllers;

import com.hF.hFcave.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/pic/akari")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/random")
    public String getPhotoLink() throws IOException {
        int rand = (int) (Math.random() *10);
        return photoService.getPhotoLinks().get(rand);
    }

}
