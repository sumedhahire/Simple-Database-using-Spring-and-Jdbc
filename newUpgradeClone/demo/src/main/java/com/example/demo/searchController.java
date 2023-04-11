package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class searchController {

    @Autowired
    private PhotoService photoService;
    @GetMapping("/search")
    public String getSearch(){
        return "search";
    }

//    @PostMapping("/search")
//    public ResponseEntity<byte[]> searchPhoto(@RequestParam("id") String id) {
//        Photo photo = photoService.searchResult(id);
//        if (photo == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        } else {
//            byte[] data = photo.getData();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.valueOf(photo.getContentType()));
//            ContentDisposition disposition = ContentDisposition.builder("inline")
//                    .filename(photo.getFileName()).build();
//            headers.setContentDisposition(disposition);
//            return new ResponseEntity<>(data, headers, HttpStatus.OK);
//        }
//    }
    @PostMapping("/search")
    public String searchPhoto(@RequestParam("id") String filename,Model model){
        Photo photo = photoService.searchResult(filename);
        if (photo == null) {
            model.addAttribute("photo", null);
        } else {
            model.addAttribute("photo", photo);
        }
        return "search";
    }


}
