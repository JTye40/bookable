package com.jt40.bookable;

import com.jt40.bookable.repositories.ReadingPositionRepository;
import com.jt40.bookable.models.PositionMarker;
import com.jt40.bookable.entities.ReadingPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ReadingPositionRepositoryTest {

    @Autowired
    private ReadingPositionRepository repository;

    void testPositionMarkerJsonbMapping() {

        PositionMarker marker = PositionMarker.builder()
                .type("book")
                .page(150)
                .chapter(7)
                .build();

        ReadingPosition position = ReadingPosition.builder()
                .positionMarker(marker)
                .build();

        ReadingPosition saved = repository.save(position);
        ReadingPosition found = repository.findById(saved.getId()).orElseThrow();

        assertThat(found.getPositionMarker().getType()).isEqualTo("book");
        assertThat(found.getPositionMarker().getPage()).isEqualTo(150);
        assertThat(found.getPositionMarker().getChapter()).isEqualTo(7);
    }
}
