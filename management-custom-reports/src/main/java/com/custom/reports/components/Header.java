package com.custom.reports.components;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
public class Header {
    String reportTitle;
    LocalDateTime dateTime;
}
