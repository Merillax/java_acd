package com.example.hse.controllers;

import com.example.hse.models.BirthDay;
import com.example.hse.models.Event;
import com.example.hse.models.Meeting;
import com.example.hse.services.EventExportService;
import com.example.hse.services.EventImportService;
import com.example.hse.services.EventService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {
    @GetMapping("/events")
    public String getEvents(Model model, @RequestParam(name = "sort", required = false) String sort){
        List<Event> events = EventService.getEvents(sort);
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/events/new")
    public String showEventForm() {
        return "eventForm";
    }

    @PostMapping("/events/new")
    public String createEvent(
            @RequestParam("eventType") String eventType,
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            @RequestParam(value = "birthdayBoy", required = false) String birthdayBoy,
            @RequestParam(value = "birthdayPlace", required = false) String birthdayPlace,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "partner", required = false) String partner,
            @RequestParam(value = "meetPlace", required = false) String meetPlace,
            Model model) {

        Event event;
        if ("birthday".equals(eventType)) {
            EventService.saveEvent(new BirthDay(LocalDate.parse(date), LocalTime.parse(time), birthdayBoy, birthdayPlace, age));
        } else if ("meeting".equals(eventType)) {
            EventService.saveEvent(new Meeting(LocalDate.parse(date), LocalTime.parse(time), partner, meetPlace));
        }

        return "redirect:/events";
    }

    @GetMapping("/events/export")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> exportEventsToText() throws IOException {
        ByteArrayResource data = EventExportService.call(EventService.getEvents(null));
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=events.txt")
                .contentLength(data.contentLength())
                .body(data);
    }

    @PostMapping("/events/import")
    public String importEventsFromText(@RequestParam("file") MultipartFile file) throws IOException {
        EventImportService.call(file);
        return "redirect:/events";
    }
}
