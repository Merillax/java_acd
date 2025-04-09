package com.example.hse.services;

import com.example.hse.models.BirthDay;
import com.example.hse.models.Event;
import com.example.hse.models.Meeting;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EventService {
    private static List<Event> events = new ArrayList<>();
    {
        events.add(new BirthDay(LocalDate.parse("2025-01-01"), LocalTime.parse("20:00"), "boy", "bor", 23));
        events.add(new Meeting(LocalDate.parse("2025-02-01"), LocalTime.parse("21:00"), "boy", "bor"));
        events.add(new Meeting(LocalDate.parse("2025-03-01"), LocalTime.parse("22:00"), "boy", "bor"));
        events.add(new BirthDay(LocalDate.parse("2025-04-01"), LocalTime.parse("23:00"), "boy2", "bor2", 23));
        events.add(new BirthDay(LocalDate.parse("2025-05-01"), LocalTime.parse("23:30"), "boy3", "bor3", 23));
    }

    public static List<Event> getEvents(String sort) {
        sort = (sort == null) ? "" : sort;
        switch (sort) {
            case "date" -> events.sort(Comparator.comparing(Event::getDate));
            case "time" -> events.sort(Comparator.comparing(Event::getTime));
            case "-date" -> events.sort(Comparator.comparing(Event::getDate).reversed());
            case "-time" -> events.sort(Comparator.comparing(Event::getTime).reversed());
        };
        return events;
    }

    public static void saveEvent(Event event) {
        events.add(event);
    }
}
