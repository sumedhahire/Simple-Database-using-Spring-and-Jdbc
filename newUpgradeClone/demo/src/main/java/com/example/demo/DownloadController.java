package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Controller
public class DownloadController {
    private final PhotoService photoService;

    public DownloadController(PhotoService photoService){
        this.photoService = photoService;
    }
    @GetMapping("/download")
    public String getDownloadPage(){
        return "download";
    }
    //    @PostMapping("/download/{id}")
//    public String updateUser(@PathVariable String id) {
//        // do something with the user ID and the user object
//        return "redirect:/download/" + id;
//    }
    @PostMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> download(@RequestParam("id") String id, Model model) throws IOException {
        Photo photo = photoService.searchResult(id);

        if(photo == null ) {
            Resource errorPage = new ClassPathResource("templates/error-404.html");
            if (errorPage.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.TEXT_HTML)
                        .body(errorPage.getInputStream().readAllBytes());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }else {
            byte[] data = photo.getData();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(photo.getContentType()));
            ContentDisposition build = ContentDisposition.builder("inline")
                    .filename(photo.getFileName()).build();
            headers.setContentDisposition(build);
            //----
            model.addAttribute("id", id);
            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        }
    }
    @GetMapping("/download/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> download(@PathVariable("id") Integer id){
        Photo photo = photoService.getID(id);

        if(photo == null ) throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment")
                .filename(photo.getFileName()).build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
