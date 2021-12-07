package org.softserveacademy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String email;
}
