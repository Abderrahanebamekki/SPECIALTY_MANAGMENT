package org.example.specialitymanagement.controller;


import org.example.specialitymanagement.model.Speciality;
import org.example.specialitymanagement.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @PostMapping("/new_speciality")
    public ResponseEntity<?> addSpeciality(@RequestBody Speciality speciality) {
        try {
            specialityService.checkSpecialityName(speciality.getName());
            specialityService.addSpeciality(speciality);
            return ResponseEntity.ok("added speciality successfully");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(e.getMessage()));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/update_speciality")
    public ResponseEntity<?> updateSpeciality(@RequestBody Speciality speciality) {
        try {
            specialityService.updateSpeciality(speciality);
            return ResponseEntity.ok("updated speciality successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/delete_speciality/{id}")
    public ResponseEntity<?> deleteSpeciality(@PathVariable Long id) {
        try {
            specialityService.deleteSpeciality(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Delete speciality successfully"));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/specialities")
    public ResponseEntity<?> getAllSpecialities() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("Data retrieved successfully" , specialityService.getAllSpecialities()));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(e.getMessage()));
        }
    }

    @GetMapping("/specialty_name")
    public ResponseEntity<?> getSpecialityBySpecialityName(@RequestParam String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>("searched successfully" , specialityService.getSpecialityByName(name)));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(e.getMessage()));
        }
    }


}
