package com.example.demo;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.core.io.*;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
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


//    @GetMapping("/photo")
//    @ResponseBody
//    public Iterable<Photo> get(){
//        return photoService.get();
//
//    }
    //working------------------below
//        @GetMapping("/photo")
//        @ResponseBody
//        public ResponseEntity<Iterable<Photo>> get() {
//            Iterable<Photo> photos = photoService.get();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_XML);
//
//            MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
//            converter.setPrettyPrint(true);
//
//            return new ResponseEntity<>(photos, headers, HttpStatus.OK);
//        }

//    @GetMapping("/photo")
//    public String getphoto(){
//        return "photo";
//    }

//    @PostMapping("/api/photo")
//    @ResponseBody
//    public Iterable<Photo> get(){
//        return photoService.get();
//
//    }


//    @PostMapping("/api/photo")
//    public ResponseEntity<String> handleFormSubmit(@Valid @RequestBody MyForm myForm, BindingResult bindingResult) {
//
//            return ResponseEntity.ok().body("Success");
//        }
//    }

    // Other controller methods

    @GetMapping("/photo")
    public String get(Model model){
        Iterable<Photo> photos = photoService.get();
        model.addAttribute("photos", photos);
        return "photo";
    }


    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/loginout")
    public String getLoginout(){
        return "loginout";
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

    @GetMapping("/secret")
    public String getSecret(){
        return "secret";
    }
}
