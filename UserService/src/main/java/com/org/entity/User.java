package com.org.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.org.payload.Rating;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings;

}