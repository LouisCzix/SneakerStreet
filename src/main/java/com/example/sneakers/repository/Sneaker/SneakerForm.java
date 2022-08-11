package com.example.sneakers.repository.Sneaker;

import com.example.sneakers.entity.sneaker.Sneaker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter

public class SneakerForm {
    @Id
    private String id;
    private String name;
    private Number size;
    private Number value;

    public SneakerForm(String id, String name, Number size, Number value) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.value = value;
    }

    public Sneaker convertFormToEntity() {
        return new Sneaker(id, name, size, value);
    }
}
