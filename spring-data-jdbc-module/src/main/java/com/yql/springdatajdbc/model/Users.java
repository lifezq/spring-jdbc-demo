package com.yql.springdatajdbc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @Package com.yql.springdatajdbc.model
 * @ClassName User
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/20
 */
public class Users {
    @Id
    private Long id;
    private String name;
    private String address;
    private Integer age;
    private String gender;
    private Double salary;
    private LocalDateTime created;

    public Users() {
    }

    public Users(String name, String address, Integer age, String gender, Double salary, LocalDateTime created) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
