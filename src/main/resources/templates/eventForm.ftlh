<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Создать запись</title>
</head>
<body>
    <h1>Создать событие</h1>
    <form action="/events/new" method="post">
        <label for="eventType">Тип события:</label>
        <select name="eventType" id="eventType">
            <option value="birthday">День рождения</option>
            <option value="meeting">Встреча</option>
        </select>
        <br><br>

        <!-- Для дня рождения -->
        <div id="birthdayFields">
            <label for="birthdayBoy">Именинник:</label>
            <input type="text" name="birthdayBoy" id="birthdayBoy" required>
            <br>

            <label for="birthdayPlace">Место:</label>
            <input type="text" name="birthdayPlace" id="birthdayPlace" required>
            <br>

            <label for="age">Возраст:</label>
            <input type="number" name="age" id="age" required>
            <br>
        </div>

        <!-- Для встречи -->
        <div id="meetingFields" style="display:none;">
            <label for="partner">С кем встреча:</label>
            <input type="text" name="partner" id="partner" required>
            <br>

            <label for="meetPlace">Место встречи:</label>
            <input type="text" name="meetPlace" id="meetPlace" required>
            <br>
        </div>

        <label for="date">Дата:</label>
        <input type="date" name="date" required>
        <br>

        <label for="time">Время:</label>
        <input type="time" name="time" required>
        <br>

        <button type="submit">Создать</button>
    </form>

    <script>
        // Показываем/скрываем поля и изменяем их обязательность в зависимости от типа события
        document.getElementById("eventType").addEventListener("change", function() {
            const eventType = this.value;

            // Для Дня рождения
            if (eventType === "birthday") {
                document.getElementById("birthdayFields").style.display = "block";
                document.getElementById("meetingFields").style.display = "none";

                // Делаем поля для дня рождения обязательными
                document.getElementById("birthdayBoy").required = true;
                document.getElementById("birthdayPlace").required = true;
                document.getElementById("age").required = true;

                // Убираем обязательность для полей встречи
                document.getElementById("partner").required = false;
                document.getElementById("meetPlace").required = false;
            }
            // Для Встречи
            else if (eventType === "meeting") {
                document.getElementById("birthdayFields").style.display = "none";
                document.getElementById("meetingFields").style.display = "block";

                // Делаем поля для встречи обязательными
                document.getElementById("partner").required = true;
                document.getElementById("meetPlace").required = true;

                // Убираем обязательность для полей дня рождения
                document.getElementById("birthdayBoy").required = false;
                document.getElementById("birthdayPlace").required = false;
                document.getElementById("age").required = false;
            }
        });

        // Инициализация с текущим значением, чтобы сразу отобразить нужные поля при загрузке страницы
        document.getElementById("eventType").dispatchEvent(new Event('change'));
    </script>
</body>
</html>
