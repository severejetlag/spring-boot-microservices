package com.example.songsapi.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SONGS")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name ="LENGTH")
    private int length;

    @Column(name = "ARTIST")
    private String artist;

    public Song(String title, int length, String artist) {
        this.title = title;
        this.length = length;
        this.artist = artist;
    }
}