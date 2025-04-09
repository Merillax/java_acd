package com.example.hse.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Meeting extends Event{
    private String partner;
    private String meetPlace;

    public Meeting(LocalDate date, LocalTime time, String partner, String meetPlace) {
        super(date, time);
        this.partner = partner;
        this.meetPlace = meetPlace;
    }

    public String getMeetPlace() {
        return meetPlace;
    }

    public void setMeetPlace(String meetPlace) {
        this.meetPlace = meetPlace;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
