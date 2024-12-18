package org.example.specialitymanagement.controller;

import org.example.specialitymanagement.Dao.ChoiceRequest;
import org.example.specialitymanagement.model.Choice;
import org.example.specialitymanagement.model.Speciality;
import org.example.specialitymanagement.model.Student;
import org.example.specialitymanagement.service.ChoiceService;
import org.example.specialitymanagement.service.SpecialityService;
import org.example.specialitymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private StudentService studentService;


    @PostMapping("/new_choice/{numStudent}")
    public ResponseEntity<?> addChoice(@RequestBody List<ChoiceRequest> choices , @PathVariable String numStudent) {
        System.out.println(choices);
        try {
            for( ChoiceRequest choice:choices) {
                Long specId = choice.getSpecialty();
                Speciality spe = specialityService.getSpecialityById(specId);
                Student s = studentService.getStudentById(numStudent);

                Choice choice1 = new Choice(new Choice.ChoiceId(spe , s) , choice.getOrderChoice());
                choiceService.addChoice(choice1);
            }
            return ResponseEntity.ok(new ApiResponse<>("Add choices successful"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage()));
        }

    }

    @PutMapping("/update_choice/{numStudent}")
    public ResponseEntity<?> updateChoice(@RequestBody List<ChoiceRequest> choices , @PathVariable String numStudent) {
       try {
           for( ChoiceRequest choice:choices) {
               Long specId = choice.getSpecialty();
               Speciality spe = specialityService.getSpecialityById(specId);
               Student s = studentService.getStudentById(numStudent);

               Choice choice1 = new Choice(new Choice.ChoiceId(spe , s) , choice.getOrderChoice());
               choiceService.updateChoice(choice1);
           }
           return ResponseEntity.ok(new ApiResponse<>("Update choice successful"));
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage()));
       }
    }

    @DeleteMapping("/delete_choice")
    public ResponseEntity<?> deleteChoice(@RequestBody Choice.ChoiceId id) {
       try{
           choiceService.deleteChoice(id);
           return ResponseEntity.ok(new ApiResponse<>("Delete choice successful"));
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage()));
       }
    }



}

