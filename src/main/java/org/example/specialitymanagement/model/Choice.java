package org.example.specialitymanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {

    @EmbeddedId
    private ChoiceId id;

    private int  choiceOrder;

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChoiceId {

        @ManyToOne(cascade = CascadeType.ALL)
        private Speciality speciality;

        @ManyToOne(cascade = CascadeType.ALL)
        private Student student;

    }

}
