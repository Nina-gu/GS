package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "palindrome")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Palindrome {

    @Id
    private String longest;

    @OneToOne
    private InputString inputString;

    public void setLongest(String longest) {
        this.longest = longest;
    }

    public String getLongest() {
        return longest;
    }
}
