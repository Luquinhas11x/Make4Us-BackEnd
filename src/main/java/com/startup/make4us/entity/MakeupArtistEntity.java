package com.startup.make4us.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "makeup_artist")
public class MakeupArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "makeup_artist_name")
    private String makeupArtistName;

    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;

    @Column(name = "age")
    private String age;

    @Column(name = "email")
    private String email;
}
