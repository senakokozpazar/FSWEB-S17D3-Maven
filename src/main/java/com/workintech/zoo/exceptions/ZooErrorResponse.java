package com.workintech.zoo.exceptions;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZooErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
