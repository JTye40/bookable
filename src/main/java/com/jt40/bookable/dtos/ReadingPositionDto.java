package com.jt40.bookable.dtos;

import com.jt40.bookable.models.PositionMarker;

public record ReadingPositionDto(PositionMarker marker, String positionReference) {
}
