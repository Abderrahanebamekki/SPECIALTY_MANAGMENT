package org.example.specialitymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private String numStudent;

    private String firstName;

    private String lastName;

    private Double avgS1 ;

    private Double avgS2 ;

    private Double avgS3 ;

    private Double avgS4 ;


}
