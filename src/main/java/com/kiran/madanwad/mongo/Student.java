package com.kiran.madanwad.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubject;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;


    public Student(String firstname,
                   String lastname,
                   String email,
                   Gender gender,
                   Address address,
                   List<String> favouriteSubject,
                   BigDecimal totalSpentInBooks,
                   LocalDateTime created) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubject = favouriteSubject;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
