package ru.averkiev.springlesson.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {
    @NotEmpty(message = "name not empty!")
    @Size(min = 2, max = 30, message = "name > 2 and name < 30!")
    private String name;

    @Min(value = 0, message = "Age >= 0!")
    private int age;

    @NotEmpty(message = "email not empty")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
