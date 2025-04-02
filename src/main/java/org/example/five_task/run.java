package org.example.five_task;

public class run {
    public static void main(String[] args) {
        Contact contact = new Contact(1, "Иван", "Петров", "Москва, ул. Ленина, 10", "+7 999 123-45-67", "Друг детства");

        System.out.println(contact);

        contact.setNote("Коллега по работе");

        System.out.println(contact);
    }
}
