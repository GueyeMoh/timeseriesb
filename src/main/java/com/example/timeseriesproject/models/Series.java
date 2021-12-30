package com.example.timeseriesproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;



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
    /*
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinTable(	name = "user_series",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    private User user = new User();
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinTable(	name = "series_details",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "datails_id"))
    private Details d = new Details();
    */


}
