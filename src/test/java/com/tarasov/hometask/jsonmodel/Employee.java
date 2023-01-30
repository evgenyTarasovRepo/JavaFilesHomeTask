package com.tarasov.hometask.jsonmodel;

import java.util.Arrays;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String salary;
    private boolean permanent;
    private String address;
    private int [] phoneNumbers;
    private String role;
    private String[] cities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(int[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", permanent=" + permanent +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", role='" + role + '\'' +
                ", cities=" + Arrays.toString(cities) +
                '}';
    }
}
