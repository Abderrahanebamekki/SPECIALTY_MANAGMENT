package org.example.specialitymanagement.Dao;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentChoiceDTO {
    private String numStudent;
    private String firstName;
    private String lastName;
    private Double average;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String assignedSpeciality;

    public StudentChoiceDTO(String numStudent, String firstName, String lastName, Double average,
                            String choice1, String choice2, String choice3, String choice4) {
        this.numStudent = numStudent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }
}

