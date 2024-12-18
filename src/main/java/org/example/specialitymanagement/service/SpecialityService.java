package org.example.specialitymanagement.service;


import org.example.specialitymanagement.model.Speciality;
import org.example.specialitymanagement.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {


    @Autowired
    private SpecialityRepository specialityRepository;


    public void checkSpecialityName(String specialityName) {
        if (specialityRepository.existsSpecialityByName(specialityName) > 0) {
            throw new IllegalArgumentException("Speciality with name " + specialityName+ " already exists.");
        }
    }
    public void addSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }


    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    public void updateSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }

    public void deleteSpeciality(Long specialityId) {
        specialityRepository.deleteById(specialityId);
    }

    public List<Speciality> getSpecialityByName(String name) {
        return specialityRepository.findByName(name);
    }

    public Speciality getSpecialityById(Long specialityId) {
        return specialityRepository.findById(specialityId).get();
    }

}
