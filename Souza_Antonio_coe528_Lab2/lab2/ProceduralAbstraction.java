package lab2;

import java.util.Scanner;

public class ProceduralAbstraction {
    //I put the methods at the bottom just to make it easier for me to see the main function

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reverse Factorial
        System.out.println("Welcome to my reverse factorial. I will ask you to enter a POSITIVE number, and I will return the smallest positive integer 'j' for which j! is greater than or equal to x");
        System.out.print("Enter a positive number: ");
        int x = Integer.parseInt(scanner.nextLine());
        reverseFactorial(x);

        // Nice Matrix
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        if (rows != cols) {
            System.out.println("The matrix is not square, so it cannot be a Nice matrix.");
            return;
        }

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                arr[i][j] = scanner.nextInt();
                printMatrix(arr, rows, cols);
            }
        }

        if (isMatrixNice(arr)) {
            System.out.println("The matrix is a Nice matrix.");
        } else {
            System.out.println("The matrix is not a Nice matrix.");
        }
    }

    public static void reverseFactorial(int x) {
        int fact = 1;
        int i = 1;

        while (true) {
            fact = fact * i;
            System.out.print(i);

            if (fact < x) {
                System.out.print("*");
                i = i + 1;
                continue;
            }
            if (fact == x) {
                System.out.println("\n" + i + "! is equal to " + x);
                break;
            }
            if (fact > x) {
                System.out.println("\n" + i + "! is equal to " + fact + ", which is greater than " + x);
                break;
            }
        }
    }

    public static void printMatrix(int[][] arr, int rows, int cols) {
        System.out.println("Current matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isMatrixNice(int[][] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[0][i];
        }

        // Check rows
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }

        // Check columns
        for (int i = 0; i < n; i++) {
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                colSum += arr[j][i];
            }
            if (colSum != sum) {
                return false;
            }
        }

        // Check diagonals
        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += arr[i][i];
            diag2Sum += arr[i][n - 1 - i];
        }
        if (diag1Sum != sum || diag2Sum != sum) {
            return false;
        }

        System.out.println("The sum is: " + sum);
        return true;
    }
}