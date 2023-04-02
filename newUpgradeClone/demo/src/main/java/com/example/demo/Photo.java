package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Photo")
public class Photo {

    @Id
    //   @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//file ka id target karenga

    @Column(name = "data",columnDefinition = "VARBINARY(MAX)")
    @JsonIgnore
    private byte[] data;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "file_name")
    @NotEmpty
    private String fileName;//filename ofcourse

    public Photo(){}
//    public Photo(Integer id, String fileName) {
//        this.id = id;
//        this.fileName = fileName;
//    }

    public Integer getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
