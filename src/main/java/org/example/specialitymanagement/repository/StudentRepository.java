package org.example.specialitymanagement.repository;

import org.example.specialitymanagement.model.Choice;
import org.example.specialitymanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , String> {


    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:firstName%")
    List<Student> findByFirstName(@Param("firstName") String firstName);


    @Query("select s from Student  s where s.numStudent like %:numStudent%")
    List<Student> findByNumStudentName(@Param("numStudent") String numStudent);

    @Query("SELECT c.id.student, " +
            "c.id.speciality.name, " +
            "c.choiceOrder, " +
            "((c.id.student.avgS1 + c.id.student.avgS2 + c.id.student.avgS3 + c.id.student.avgS4) / 4) AS avgOfAverages " +
            "FROM Choice c " +
            "ORDER BY avgOfAverages DESC")
    List<Object[]> findAllStudentsWithChoicesOrderedByAverage();

    @Query("""
    SELECT 
        s.numStudent AS numStudent,
        s.firstName AS firstName,
        s.lastName AS lastName,
        (s.avgS1 + s.avgS2 + s.avgS3 + s.avgS4) / 4 AS average,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 1 THEN sp.name ELSE NULL END), 'Nan') AS choice1,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 2 THEN sp.name ELSE NULL END), 'Nan') AS choice2,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 3 THEN sp.name ELSE NULL END), 'Nan') AS choice3,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 4 THEN sp.name ELSE NULL END), 'Nan') AS choice4
    FROM Student s
    LEFT JOIN Choice ch ON ch.id.student.numStudent = s.numStudent
    LEFT JOIN Speciality sp ON ch.id.speciality.id = sp.id
    group by s.numStudent
""")
    List<Object[]> fetchStudentDetailsWithChoicesUpToFour();

    @Query("""
    SELECT 
        s.numStudent AS numStudent,
        s.firstName AS firstName,
        s.lastName AS lastName,
        (s.avgS1 + s.avgS2 + s.avgS3 + s.avgS4) / 4 AS average,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 1 THEN sp.name ELSE NULL END), 'Nan') AS choice1,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 2 THEN sp.name ELSE NULL END), 'Nan') AS choice2,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 3 THEN sp.name ELSE NULL END), 'Nan') AS choice3,
        COALESCE(MAX(CASE WHEN ch.choiceOrder = 4 THEN sp.name ELSE NULL END), 'Nan') AS choice4
    FROM Student s
    LEFT JOIN Choice ch ON ch.id.student.numStudent = s.numStudent
    LEFT JOIN Speciality sp ON ch.id.speciality.id = sp.id
    GROUP BY s.numStudent
    ORDER BY average DESC
""")
    List<Object[]> fetchStudentDetailsWithChoicesSortedDesc();








}
