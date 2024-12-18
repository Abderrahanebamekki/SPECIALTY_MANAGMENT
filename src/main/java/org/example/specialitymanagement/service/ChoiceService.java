package org.example.specialitymanagement.service;


import org.example.specialitymanagement.model.Choice;
import org.example.specialitymanagement.model.Student;
import org.example.specialitymanagement.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChoiceService {
    @Autowired
    private ChoiceRepository choiceRepository;

    public void addChoice(Choice choice) {
        choiceRepository.save(choice);
    }

    public void updateChoice(Choice choice) {
        if (choiceRepository.existsById(choice.getId())) {
            choiceRepository.save(choice);
        }
    }

    public void deleteChoice(Choice.ChoiceId id) {
        if (choiceRepository.existsById(id)) {
            choiceRepository.deleteById(id);
        }
    }




}
