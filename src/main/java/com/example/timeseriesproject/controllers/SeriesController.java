package com.example.timeseriesproject.controllers;

import com.example.timeseriesproject.exception.ResourceNotFoundException;
import com.example.timeseriesproject.models.Series;
import com.example.timeseriesproject.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class SeriesController {
    @Autowired
    SeriesRepository seriesRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Series> getSeries() {
        return seriesRepository.findAll();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable Long id){
        Series series = seriesRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Error with that identifier"+id));
        return ResponseEntity.ok(series);
    }
    @PostMapping("/user")
    public Series addSeries(@RequestBody Series series){
        return seriesRepository.save(series);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Series> editSeries(@RequestBody Series s, @PathVariable Long id){
        Series series = seriesRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Error with that identifier"+id));
        series.setDescription(s.getDescription());
        series.setTitre(s.getTitre());
        return ResponseEntity.ok(series);
    }
    @DeleteMapping("/user/{id}")
    public void deleteSeries(@PathVariable Long id){
        seriesRepository.deleteById(id);
    }














    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}