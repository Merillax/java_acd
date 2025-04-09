package com.example.hse.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BirthDay extends Event{
    private String birthdayBoy;
    private String birthdayPlace;
    private Integer age;
    public BirthDay(LocalDate date, LocalTime time, String birthdayBoy, String birthdayPlace, Integer age){
        super(date, time);
        this.age = age;
        this.birthdayPlace = birthdayPlace;
        this.birthdayBoy = birthdayBoy;
    }

    public String getBirthdayBoy() {
        return birthdayBoy;
    }

    public void setBirthdayBoy(String birthdayBoy) {
        this.birthdayBoy = birthdayBoy;
    }

    public String getBirthdayPlace() {
        return birthdayPlace;
    }

    public void setBirthdayPlace(String birthdayPlace) {
        this.birthdayPlace = birthdayPlace;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
