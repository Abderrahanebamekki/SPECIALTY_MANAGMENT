package org.example.specialitymanagement.controller;


import org.example.specialitymanagement.model.Speciality;
import org.example.specialitymanagement.model.Student;
import org.example.specialitymanagement.service.SpecialityService;
import org.example.specialitymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SpecialityService specialityService;



    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
            return ResponseEntity.ok("Student added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to add student: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseEntity.ok("Student updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            return ResponseEntity.ok(new ApiResponse<>("Students retrieved successfully", students));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error fetching students: " + e.getMessage()));
        }
    }



    @GetMapping("/search_name")
    public ResponseEntity<?> searchName(@RequestParam String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("searched successfully" , studentService.findStudentByName(name)));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(e.getMessage()));
        }
    }

    @GetMapping("/search_id")
    public ResponseEntity<?> searchId(@RequestParam String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("searched successfully" , studentService.findStudentById(id)));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(e.getMessage()));
        }
    }


    @GetMapping("/student_choices")
    public ResponseEntity<?> getStudentChoices() {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("get student with choices successfully" , studentService.getStudentsWithChoicess() ));

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage()));
        }
    }


    @GetMapping("/Affected_spe")
    public ResponseEntity<?> affectedSpe() {
        return ResponseEntity.ok(new ApiResponse<>("affected spe" , studentService.getStudentDetailsWithAssignedSpecialities()));
    }



}
