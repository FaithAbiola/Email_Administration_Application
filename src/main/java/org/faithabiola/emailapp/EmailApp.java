package org.faithabiola.emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //User info
        System.out.println("Enter first name:");
        String firstName = s.next();
        System.out.println("Enter last name:");
        String lastName = s.next();

        //Creating an object for Email class
        Email em1 = new Email( firstName, lastName );
        int choice = -1;
        do{
            System.out.println("\n*******\nEnter your choice\n1. Show Info\n2. Change password\n3. Change mailbox capacity\n4. Set alternate mail\n5. Store data in file\n6. Display data from file\n7. Exit");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.changePassword();
                    break;
                case 3:
                    em1.setMailCapacity();
                    break;
                case 4:
                    em1.setAlternateEmail();
                    break;
                case 5:
                    em1.storeFile();
                    break;
                case 6:
                    em1.readFile();
                    break;
                case 7:
                    System.out.println("Thank you for using our application!");
                    break;
                default:
                    System.out.println("Invalid choice\nEnter proper choice again");
            }
        } while (choice!=7);

    }
}

