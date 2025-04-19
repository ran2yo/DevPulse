package com.library.devpulse.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "users")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;


    //JPA가 리플렉션으로 사용할 기본 생성자
    protected User() {}

    private User(String name, int age, String gender, String email, String phone, String address, String city) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}
