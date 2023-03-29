package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,length = 11)
    private String cpf;
    @Column(nullable = false)
    private String birthdate;

    public Student(){}

    public Student(String name, String cpf, String birthdate)
    {
        super();
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
