package com.example.servezy;

public class Person {
    private String FirstName;
    private String LastName;
    private String Address;
    private String PhoneNum;
    private boolean isVolunteer;

    public Person(String FirstName, String LastName, String Address, String PhoneNum, boolean isVolunteer) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.PhoneNum = PhoneNum;
        this.isVolunteer = true;
    }
}
