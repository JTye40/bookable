package com.jt40.bookable.repositories;

import com.jt40.bookable.entities.ReadingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingPositionRepository extends JpaRepository<ReadingPosition, Long> {
}
