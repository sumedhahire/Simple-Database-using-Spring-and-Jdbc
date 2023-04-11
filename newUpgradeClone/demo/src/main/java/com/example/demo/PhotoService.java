package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    private final Repo repo;
    public PhotoService(Repo repo) {
        this.repo = repo;
    }

    public Iterable<Photo> get() {
        return repo.findAll();
    }

    public Photo getID(Integer id){
        return  repo.findById(id).orElse(null);
    }

    public Photo put(String filename, String contentType, byte[] data) {
        Photo photo=new Photo();
        photo.setFileName(filename);
//        String LUUID=String.format("%040d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
        photo.setContentType(contentType);
        photo.setData(data);
        repo.save(photo);
        return photo;
    }

    public Photo searchResult(String str){
        return repo.findByFileName(str);
    }
    public void remove(Integer id) {
        repo.deleteById(id);
    }
}
