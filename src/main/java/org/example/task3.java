package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
// 1 вариант
public class task3 {
    final static int N = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        List<Integer> resultArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (array[i] == N) {
             resultArr.add(i);
            }
        }

        System.out.println("Массив индексов элементов равных N: ");
        System.out.println(resultArr);
    }
}
