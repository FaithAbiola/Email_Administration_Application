package org.faithabiola;

import org.faithabiola.emailapp.Email;

public class Main {
    public static void main(String[] args) {
     Email email = new  Email("Faith", "Abiola");

        System.out.println(email.showInfo());

//     email.setAlternateEmail("alt@gmail.com");
//        System.out.println(email.getAlternateEmail());
    }
}
