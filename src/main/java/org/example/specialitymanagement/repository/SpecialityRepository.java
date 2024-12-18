package org.example.specialitymanagement.repository;


import org.example.specialitymanagement.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality , Long> {

    @Query("select s from Speciality as s where s.name like %:name%")
    List<Speciality> findByName(@Param("name") String name);

    @Query("SELECT COUNT(s) FROM Speciality s WHERE s.name = :specialityName")
    int existsSpecialityByName(@Param("specialityName") String specialityName);


}
