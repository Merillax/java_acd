package org.example;
import java.util.Scanner;
// 4 вариант
public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        System.out.print("Введите число y: ");
        int y = scanner.nextInt();

        int result = (int) ((x + y > 20) ? (Math.pow(x, 2) * 3) : Math.pow(y, 3));

        System.out.println("Результат: " + result);

        scanner.close();
    }
}
