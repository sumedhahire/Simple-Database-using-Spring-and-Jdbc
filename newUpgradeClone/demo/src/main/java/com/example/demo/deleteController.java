package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class deleteController {
    private final PhotoService photoService;

    public deleteController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/delete")
    public String getDelete(){
        return "delete";
    }
    @PostMapping("/delete")
    @ResponseBody
    public void deleteFileById(@RequestParam("id") int id) {
        // Your code to delete the file with the specified ID goes here
            photoService.remove(id);
    }

}
