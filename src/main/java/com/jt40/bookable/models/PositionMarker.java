package com.jt40.bookable.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionMarker {

    private String type;           // book | audiobook | ebook
    private Integer page;          // page number
    private Integer chapter;       // chapter number
    private String location;       // ebook "loc-2543"
    private Integer timeInSeconds; // audiobook position
    private Double percentage;     // percent completed
    private String notes;          // optional user notes
}
