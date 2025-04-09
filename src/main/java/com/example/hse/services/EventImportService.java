package com.example.hse.services;

import com.example.hse.models.BirthDay;
import com.example.hse.models.Event;
import com.example.hse.models.Meeting;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventImportService {
    public static void call(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            // Пропускаем заголовок
            reader.readLine();

            // Читаем строки и добавляем события
            while ((line = reader.readLine()) != null) {
                String[] eventData = line.split(", ");
                if (eventData.length >= 7) {
                    String eventType = eventData[3]; // Тип события
                    String date = eventData[1]; // Дата
                    String time = eventData[2]; // Время
                    String nameOrPartner = eventData[4]; // Именинник или Партнер
                    String placeOrMeetPlace = eventData[5]; // Место
                    String ageOrMeetPlaceDetails = eventData[6]; // Возраст или место встречи

                    Event event = null;
                    if ("День рождения".equals(eventType)) {
                        event = new BirthDay(LocalDate.parse(date), LocalTime.parse(time), nameOrPartner, placeOrMeetPlace, Integer.parseInt(ageOrMeetPlaceDetails));
                    } else if ("Встреча".equals(eventType)) {
                        event = new Meeting(LocalDate.parse(date), LocalTime.parse(time), nameOrPartner, placeOrMeetPlace);
                    }
                    EventService.saveEvent(event);
                }
            }
        }
    }
}
