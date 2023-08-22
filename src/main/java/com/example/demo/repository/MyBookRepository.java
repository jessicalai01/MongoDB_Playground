package com.example.demo.repository;

import com.example.demo.model.entity.MyBookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyBookRepository extends MongoRepository<MyBookEntity, String> {
    List<MyBookEntity> findAll();
    MyBookEntity save(MyBookEntity myBookEntity);
    void deleteAll();
}
