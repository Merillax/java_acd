package com.example.hse.services;

import com.example.hse.models.BirthDay;
import com.example.hse.models.Event;
import com.example.hse.models.Meeting;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
public class EventExportService {
    public static ByteArrayResource call(List<Event> events) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        writer.write("Дата, Время, Тип события, Именинник/Партнер, Место, Возраст/Место встречи");
        writer.newLine();

        for (Event event : events) {
            StringBuilder eventData = new StringBuilder();
            eventData.append(event.getDate())
                    .append(", ")
                    .append(event.getTime())
                    .append(", ")
                    .append(event instanceof BirthDay ? "День рождения" : "Встреча")
                    .append(", ")
                    .append(event instanceof BirthDay ? ((BirthDay) event).getBirthdayBoy() : ((Meeting) event).getPartner())
                    .append(", ")
                    .append(event instanceof BirthDay ? ((BirthDay) event).getBirthdayPlace() : ((Meeting) event).getMeetPlace())
                    .append(", ")
                    .append(event instanceof BirthDay ? ((BirthDay) event).getAge() : "");

            writer.write(eventData.toString());
            writer.newLine();
        }

        writer.close();

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
        return resource;
    }
}
