package com.jt40.bookable.entities;

import com.jt40.bookable.converters.PositionMarkerConverter;
import com.jt40.bookable.models.PositionMarker;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "reading_positions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadingPosition extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Convert(converter = PositionMarkerConverter.class)
    @Column(name = "position_marker", columnDefinition = "jsonb")
    private PositionMarker positionMarker;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReadingPosition that = (ReadingPosition) o;
        return Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(user, that.user) && Objects.equals(positionMarker, that.positionMarker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, user, positionMarker);
    }
}
