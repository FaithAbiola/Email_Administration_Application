package org.faithabiola.emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner s = new Scanner(System.in);
    private String firstName;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private Integer mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
        System.out.println("New Employee: " + this.firstName + " " + this.lastname);

        //Calling methods
        this.department = this.setDepartment();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();
    }

    //Generate mail method
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastname.toLowerCase() + "@" + this.department.toLowerCase() + "." + companySuffix;
    }
    //Asking for department
    private String setDepartment() {
        System.out.println("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Dev";
                case 3:
                    return "Acc";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice, enter the correct code");
            }
        } while (!flag);
        return null;
    }
    //Generate Random password method
    private String generatePassword(int length) {
        Random rand = new Random();
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String  symbols = "!@#$%&?";
        String values = capitalChars + smallChars + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(rand.nextInt(values.length()));
        }
        return password;
    }

    //Change password method
    public void changePassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password(Y/N");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else {
                    System.out.println("Incorrect password");
                }
            }
            else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password change option cancelled");
            }
            else {
                System.out.println("Enter valid choice");
            }
        } while (!flag);
    }
    //Set mailbox capacity
    public void setMailCapacity() {
        System.out.println("Current mailbox capacity=" + this.mailboxCapacity + "mb");
        System.out.println("Enter new mailbox capacity");
        this.mailboxCapacity = s.nextInt();
        System.out.println("Mailbox capacity has been changed successfully");
    }
    //Set alternate email
    public void setAlternateEmail() {
        System.out.println("Enter new alternate mail");
        this.alternateEmail = s.next();
        System.out.println("Alternate email is set");
    }
    //Display user information method
    public void getInfo() {
        System.out.println("New:" + this.firstName + " " + this.lastname);
        System.out.println("Department:" + this.department);
        System.out.println("Email:" + this.email);
        System.out.println("Password:" +  this.password);
        System.out.println("Mailbox capacity:" + this.mailboxCapacity + "mb");
        System.out.println("Alternate mail:" + this.alternateEmail);
    }

    //Store in File
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("/Users/Decagon/Desktop/info.txt");
            in.write("First name:" + this.firstName);
            in.append("\nLast name:" + this.lastname);
            in.append("\nEmail:" + this.email);
            in.append("\nPassword:" + this.password);
            in.append("\nCapacity:" + this.mailboxCapacity);
            in.append("\nAlternate mail:" + this.alternateEmail);
            in.close();
            System.out.println("Data Stored...");

        } catch (Exception e) {
            System.out.println(e);}
    }
    //Reading file method
    public void readFile() {
        try {
            FileReader f1 = new FileReader("/Users/Decagon/Desktop/info.txt");
            int i;
            while((i = f1.read()) != -1) {
                System.out.print((char)i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);}
    }

}


