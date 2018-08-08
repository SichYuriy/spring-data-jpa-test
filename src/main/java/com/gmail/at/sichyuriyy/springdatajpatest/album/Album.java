package com.gmail.at.sichyuriyy.springdatajpatest.album;

import com.gmail.at.sichyuriyy.springdatajpatest.author.Author;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private Author author;
}
