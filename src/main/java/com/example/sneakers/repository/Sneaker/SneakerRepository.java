package com.example.sneakers.repository.Sneaker;

import com.example.sneakers.entity.sneaker.Sneaker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SneakerRepository extends MongoRepository<Sneaker, String> {

}
