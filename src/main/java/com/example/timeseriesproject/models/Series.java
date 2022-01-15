package com.example.timeseriesproject.models;

import com.example.timeseriesproject.security.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinTable(	name = "user_series",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(	name = "series_details",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "datails_id"))
    private List<Details> d;



}
