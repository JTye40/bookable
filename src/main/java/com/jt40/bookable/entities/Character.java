package com.jt40.bookable.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "traits", columnDefinition = "TEXT")
    private String traits;

    @Column(name = "image_url")
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(content, character.content) && Objects.equals(name, character.name) && Objects.equals(traits, character.traits) && Objects.equals(imageUrl, character.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, name, traits, imageUrl);
    }
}
