package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repo extends CrudRepository<Photo,Integer> {
    Photo findByFileName(String firstName);
}
