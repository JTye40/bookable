package com.jt40.bookable.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name = "type", nullable = false, length = 25)
    private String type;

    @Column(name = "source", nullable = false, length = 100)
    private String source;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(id, content.id) && Objects.equals(title, content.title) && Objects.equals(author, content.author) && Objects.equals(type, content.type) && Objects.equals(source, content.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, type, source);
    }
}
