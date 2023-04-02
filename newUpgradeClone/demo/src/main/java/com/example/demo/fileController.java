package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.core.io.*;
import java.io.IOException;

@Controller
public class fileController {
    private final PhotoService photoService;

    public fileController(PhotoService photoService){
        this.photoService = photoService;
    }

    @GetMapping("/home")
    public String getHome(){
        return "getHomeView";
    }


    @GetMapping("/photo")
    @ResponseBody
    public Iterable<Photo> get(){
        return photoService.get();

    }

    @GetMapping("/photo/{id}")
    @ResponseBody
    public Photo get(@PathVariable Integer id){
        if(photoService.getID(id)==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photoService.getID(id);
    }
    @GetMapping("/upload")
    public String getUpload(){
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Photo create(@RequestParam("file") MultipartFile file) throws IOException {
        return photoService.put(file.getOriginalFilename(),file.getContentType(),file.getBytes());
    }
}
