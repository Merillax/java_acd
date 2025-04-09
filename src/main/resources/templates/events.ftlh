<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Записная книжка</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .entry {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            padding: 15px 20px;
        }
        .entry h2 {
            margin-top: 0;
            color: #333;
        }
        .entry p {
            margin: 5px 0;
            color: #555;
        }
    </style>
</head>
<body>
    <!-- Кнопка для перехода на страницу создания нового события -->
    <a href="/events/new" class="add-event-button">Создать новое событие</a>
    <br>
    <a href="/events/export" class="add-event-button">Экспорт</a>
    <br>
    <form action="/events/import" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept=".txt"/>
        <button type="submit">📥 Загрузить события</button>
    </form>
    <h1>Моя записная книжка</h1>

    <#list events as entry>
        <div class="entry">
            <#-- Определим тип вручную -->
            <#if entry.birthdayBoy??>
                <h2>День рождения</h2>
            <#elseif entry.partner??>
                <h2>Встреча</h2>
            <#else>
                <h2>Запись</h2>
            </#if>

            <p><strong>Дата:</strong> ${entry.date}</p>
            <p><strong>Время:</strong> ${entry.time}</p>

            <#if entry.birthdayBoy??>
                <p><strong>Именинник:</strong> ${entry.birthdayBoy}</p>
                <p><strong>Место:</strong> ${entry.birthdayPlace}</p>
                <p><strong>Возраст:</strong> ${entry.age}</p>
            </#if>

            <#if entry.partner??>
                <p><strong>С кем встреча:</strong> ${entry.partner}</p>
                <p><strong>Место встречи:</strong> ${entry.meetPlace}</p>
            </#if>
        </div>
    </#list>
</body>
</html>
