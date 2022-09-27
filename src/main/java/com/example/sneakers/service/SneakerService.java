package com.example.sneakers.service;

import com.example.sneakers.entity.sneaker.Sneaker;
import com.example.sneakers.repositories.Sneaker.SneakerForm;
import com.example.sneakers.repositories.Sneaker.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SneakerService {

    @Autowired
    private SneakerRepository sneakerRepository;

    public SneakerForm createSneaker(SneakerForm sneakerForm) {
        Sneaker sneaker = sneakerForm.convertFormToEntity();
        Sneaker sneakerResponse = sneakerRepository.save(sneaker);
        return sneakerResponse.convertEntityToModel();
    }

    public Page<SneakerForm> getAllSneakers(Pageable pageable) {
        return sneakerRepository.findAll(pageable).map(Sneaker::convertEntityToModel);
    }
}
