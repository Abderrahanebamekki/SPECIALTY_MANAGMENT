package org.example.specialitymanagement.Dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceRequest {
    private Long specialty ;
    private int orderChoice ;
}
