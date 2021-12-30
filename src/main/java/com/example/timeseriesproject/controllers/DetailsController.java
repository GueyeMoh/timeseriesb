package com.example.timeseriesproject.controllers;

import com.example.timeseriesproject.models.Details;
import com.example.timeseriesproject.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DetailsController {
    @Autowired
    DetailsRepository detailsRepository;

    @GetMapping("/details")
    public List<Details> getDetails(){
        return detailsRepository.findAll();
    }
    @GetMapping("/details/{id}")
    public Details getDetailsById(@PathVariable Long id){
        return detailsRepository.findById(id).orElseThrow(); // voyons voir si cv marcher
    }
    @PostMapping("/details")
    public Details addDetails(@RequestBody Details d){
        return detailsRepository.save(d);
    }
    @PutMapping("/details/{id}")
    public Details editDetails(@RequestBody Details d, @PathVariable Long id){
        Details details = detailsRepository.findById(id).orElseThrow(); //de m
        details.setValeur(d.getValeur());
        details.setDate(d.getDate());
        details.setCommentaire(d.getCommentaire());
        return detailsRepository.save(details);
    }
    @DeleteMapping("/details/{id}")
    public void deleteDetails(@PathVariable Long id){
        detailsRepository.deleteById(id);
    }
}
