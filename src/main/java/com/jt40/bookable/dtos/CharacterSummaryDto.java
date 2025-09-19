package com.jt40.bookable.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterSummaryDto {

    private String name;

    private String traits;

    private String imageUrl;
}
