package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "string")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputString {
    @Id
    private String inputString;

    @OneToOne(mappedBy = "inputString")
    private Palindrome longest;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}

