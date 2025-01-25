package lab2TesIndividual;

import java.util.Scanner;

public class rev {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a positive number:");
        int num = Integer.parseInt(s.nextLine());

       
        int fact=1;
        int j =1; //j is the number that is being factorialed
        int i =1;
        switch (num){
            case 0:
                System.out.println("0! is equal to 1, which is greater than 1");
                System.exit(num);
        
            case 1:
                    System.out.println("1! is equal to 1");
                    System.exit(num);
        }

        while (num >= 2) {
            fact = fact * i;
            System.out.print(i);
            
        
            if (fact < num) {
                System.out.print("*");
                i = i + 1;
                continue;
            }
            if (fact == num) {
                System.out.println("\n" + i + "! is equal to " + num);
                break;
            }
            if (fact > num) {
                System.out.println("\n" + i + "! is equal to " + fact + ", which is greater than " + num);
                break;
            }
        }

        
    }
}
