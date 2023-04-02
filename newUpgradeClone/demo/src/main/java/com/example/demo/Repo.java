package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<Photo,Integer> {
}
