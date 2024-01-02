package com.restapi.bootrestbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.bootrestbook.entities.Book;

public interface BookRepo extends CrudRepository <Book,Integer>{

    public Book findById(int id);
    
}
