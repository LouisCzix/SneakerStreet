package com.example.sneakers.entity.sneaker;


import com.example.sneakers.repository.Sneaker.SneakerForm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "sneakers")
public class Sneaker {

    @Id
    private String id;
    private String name;
    private Number size;
    private Number value;

    public Sneaker(String id, String name, Number size, Number value) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.value = value;
    }

    public SneakerForm convertEntityToModel() {
        return new SneakerForm( id, name, size, value);
    }
}
