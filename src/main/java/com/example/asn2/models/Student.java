package com.example.asn2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int sid; // student ID
    private String name;
    private String gender;
    private int weight;
    private int height;
    private String hairc; // hair colour
    private String major;
    private double gpa;

    public Student() {
    }

    public Student(String name, String gender, int weight, int height, String hairc, String major, double gpa) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.hairc = hairc;
        this.major = major;
        this.gpa = gpa;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHairc() {
        return hairc;
    }

    public void setHairc(String hairc) {
        this.hairc = hairc;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }    
     
}

// package com.example.asn2.models;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="users")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int uid;
//     private String name;
//     private String password;
//     private int size;

//     // doesn't take parameters
//     public User() {
//     }
//     // takes parameters
//     public User(String name, String password, int size) {
//         this.name = name;
//         this.password = password;
//         this.size = size;
//     }
//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }
//     public String getPassword() {
//         return password;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
//     public int getSize() {
//         return size;
//     }
//     public void setSize(int size) {
//         this.size = size;
//     }
//     public int getUid() {
//         return uid;
//     }
//     public void setUid(int uid) {
//         this.uid = uid;
//     }
     
// }
