package org.example;
import java.util.Scanner;
// 1 вариант
public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        System.out.print("Введите число y: ");
        int y = scanner.nextInt();

        int max = (x > y) ? x : y;
        int min = x == max ? y : x;

        System.out.println("Результат: " + (Math.pow(max, 5) - 3.2 * min) / (1 + min));

        scanner.close();
    }
}
