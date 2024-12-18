package org.example.specialitymanagement.service;


import org.example.specialitymanagement.Dao.StudentChoiceDTO;
import org.example.specialitymanagement.model.Speciality;
import org.example.specialitymanagement.model.Student;
import org.example.specialitymanagement.repository.SpecialityRepository;
import org.example.specialitymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SpecialityService specialityRepository;

    public void addStudent(Student student) {
        if (studentRepository.existsById(student.getNumStudent())) {
            throw new IllegalArgumentException("A student with the same ID already exists: " + student.getNumStudent());
        }
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public List<Student> findStudentByName(String name) {
        return studentRepository.findByFirstName(name);
    }

    public List<Student> findStudentById(String id) {
        return studentRepository.findByNumStudentName(id);
    }




    public List<StudentWithChoices> getStudentsWithChoicess() {
        return studentRepository.fetchStudentDetailsWithChoicesUpToFour().stream()
                .map(row -> new StudentWithChoices(
                        (String) row[0],  // numStudent
                        (String) row[1],  // firstName
                        (String) row[2],  // lastName
                        (Double) row[3],  // Average
                        (String) row[4],  // choice1
                        (String) row[5],  // choice2
                        (String) row[6],  // choice3
                        (String) row[7]   // choice4
                ))
                .collect(Collectors.toList());
    }
    public record StudentWithChoices(
            String numStudent,
            String firstName,
            String lastName,
            Double average,
            String choice1,
            String choice2,
            String choice3,
            String choice4
    ) {}

    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public List<StudentChoiceDTO> getStudentDetailsWithAssignedSpecialities() {
        List<Object[]> results = studentRepository.fetchStudentDetailsWithChoicesSortedDesc();

        List<Speciality> specialitiesData = specialityRepository.getAllSpecialities();

        Map<String, Integer> remainingPlaces = new HashMap<>();
        for (Speciality speciality : specialitiesData) {
            remainingPlaces.put(speciality.getName(), speciality.getNumberOfPlaces());
        }

        List<StudentChoiceDTO> studentChoices = new ArrayList<>();
        for (Object[] row : results) {
            StudentChoiceDTO dto = new StudentChoiceDTO(
                    (String) row[0], // numStudent
                    (String) row[1],              // firstName
                    (String) row[2],              // lastName
                    ((Number) row[3]).doubleValue(), // average
                    (String) row[4],              // choice1
                    (String) row[5],              // choice2
                    (String) row[6],              // choice3
                    (String) row[7]               // choice4
            );

            String assignedSpeciality = assignSpeciality(dto, remainingPlaces);
            dto.setAssignedSpeciality(assignedSpeciality);
            studentChoices.add(dto);
        }

        return studentChoices;
    }

    private String assignSpeciality(StudentChoiceDTO dto, Map<String, Integer> remainingPlaces) {
        List<String> choices = Arrays.asList(dto.getChoice1(), dto.getChoice2(), dto.getChoice3(), dto.getChoice4());

        for (String choice : choices) {
            if (choice != null && !"Nan".equals(choice) && remainingPlaces.containsKey(choice)) {
                int placesLeft = remainingPlaces.get(choice);
                if (placesLeft > 0) {
                    remainingPlaces.put(choice, placesLeft - 1);
                    return choice;
                }
            }
        }

        return "Nan";
    }


}
