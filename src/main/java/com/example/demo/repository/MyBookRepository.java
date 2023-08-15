package com.example.demo.repository;

import com.example.demo.model.entity.MyBoookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyBookRepository extends MongoRepository<MyBoookEntity, String> {
    List<MyBoookEntity> findAll();
    MyBoookEntity save(MyBoookEntity myBoookEntity);
    void deleteAll();
}
