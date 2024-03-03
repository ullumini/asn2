package com.example.asn2.controllers;

import java.util.List;
import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.transaction.annotation.Transactional;

import com.example.asn2.models.Student;
import com.example.asn2.models.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

@Controller
public class StudentsController {  
    
    @Autowired
    private StudentRepository StudentRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/")
    public RedirectView success_redirect(){
        return new RedirectView("students/view");
    } 
    
    @GetMapping("/students/view")
    public String getAllStudents(Model model){
        System.out.println("Getting all students");
        // get all users from database
        List<Student> students = StudentRepo.findAll();
        // end of database call
        model.addAttribute("stu", students);
        return "students/showAll";
    }

    @GetMapping("/students/viewAlt")
    public String getAllStudentsAlt(Model model){
        System.out.println("Getting all students Altview");
        // get all users from database
        List<Student> students = StudentRepo.findAll();
        // end of database call
        model.addAttribute("stu", students);
        return "students/showAllAlt";
    }

    @GetMapping("/students/successpage")
    public String viewSuccess(){
        return "students/success";
    }

    @GetMapping("/students/errorpage")
    public String viewError(){
        return "students/error";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        System.out.println("ADD Student");
        String newName = newstudent.get("name");
        String newGender = newstudent.get("gender");
        int newWeight = Integer.parseInt(newstudent.get("weight"));
        int newHeight = Integer.parseInt(newstudent.get("height"));
        String newHairc = newstudent.get("hairc");
        String newMajor = newstudent.get("major");
        double newGpa = Double.parseDouble(newstudent.get("gpa"));

        StudentRepo.save(new Student(newName, newGender, newWeight, newHeight, newHairc, newMajor, newGpa));
        response.setStatus(201); 

        return "students/success";
    }

    @PostMapping("/students/update")
    @Transactional
    public String updateStudent(@RequestParam("sid") int sid, @RequestParam Map<String, String> updateStudent, HttpServletResponse response)
    {
        System.out.println("UPDATE student");
        Student student = StudentRepo.findBySid(sid);
        if (student == null) {return "students/error";}

        if (updateStudent.get("name") != "") {student.setName(updateStudent.get("name"));}
        if (updateStudent.get("major") != "") {student.setMajor(updateStudent.get("major"));}
        if (updateStudent.get("gpa") != "") {student.setGpa(Double.parseDouble(updateStudent.get("gpa")));}
        if (updateStudent.get("gender") != "") {student.setGender(updateStudent.get("gender"));}
        if (updateStudent.get("hairc") != "") {student.setHairc(updateStudent.get("hairc"));}
        if (updateStudent.get("weight") != "") {student.setWeight(Integer.parseInt(updateStudent.get("weight")));}
        if (updateStudent.get("height") != "") {student.setHeight(Integer.parseInt(updateStudent.get("height")));}

        StudentRepo.save(student);
        response.setStatus(200);
        return "students/success";

    }

    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam("sid") int sid, HttpServletResponse response) {
        System.out.println("DELETE student");
        Student student = StudentRepo.findBySid(sid);
        if (student == null) {return "students/error";}
        StudentRepo.deleteById(sid);
        return ("students/success");
    }

}