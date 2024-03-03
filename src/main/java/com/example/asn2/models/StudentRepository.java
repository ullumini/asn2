package com.example.asn2.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByGender(String gender);
    List<Student> findByWeight(int weight);
    List<Student> findByHeight(int height);
    List<Student> findByHairc(String hairc);
    List<Student> findByGpa(double gpa);
    Student findBySid(int sid);
}


