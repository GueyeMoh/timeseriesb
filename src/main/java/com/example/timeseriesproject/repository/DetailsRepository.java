package com.example.timeseriesproject.repository;

import com.example.timeseriesproject.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
}
