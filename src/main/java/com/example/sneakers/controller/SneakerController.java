package com.example.sneakers.controller;
import com.example.sneakers.entity.sneaker.Sneaker;
import com.example.sneakers.repositories.Sneaker.SneakerForm;
import com.example.sneakers.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
    @RequestMapping("/api")
    public class SneakerController {

        @Autowired
        private SneakerService sneakerService;

        @PostMapping("/sneaker")
        public ResponseEntity<SneakerForm> createSneaker(@RequestBody SneakerForm sneakerForm) {
            return ResponseEntity.status(HttpStatus.CREATED).body(sneakerService.createSneaker(sneakerForm));
        }


        @GetMapping("/sneakers")
        public ResponseEntity<Page<Sneaker>> getAllSneakers(@PageableDefault (sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

            Page<SneakerForm> sneaker = sneakerService.getAllSneakers(pageable);

            return ResponseEntity.ok(sneaker.map(SneakerForm::convertFormToEntity));
        }
    }

