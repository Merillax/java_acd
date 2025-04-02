package org.example;
import java.util.Random;
import java.util.Scanner;
// 1 вариант
public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Введите количество строк двумерного массива: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов двумерного массива: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
            }
        }

        int[] B = new int[rows];

        for (int j = 0; j < rows; j++) {
            int kolvo = 0;
            for (int i = 0; i < cols; i++) {
                if (matrix[j][i] >= 0) {
                    kolvo += 1;
                }
            }
            B[j] = kolvo;
        }

        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Вектор B (индексы строк с минимальными значениями в столбцах):");
        for (int j = 0; j < cols; j++) {
            System.out.print(B[j] + " ");
        }
    }
}
