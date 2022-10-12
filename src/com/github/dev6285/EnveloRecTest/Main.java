package com.github.dev6285.EnveloRecTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        WelcomeMsg welcomeMsg = new WelcomeMsg();
        welcomeMsg.sayHello();                      // Introduction and commands summary.

        UserMenu userMenu = new UserMenu();
        userMenu.loadUserMenu();
//
//        //================================================
//        // Enter data using BufferReader
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        // Reading data using readLine
//        String name = null;
//        try {
//            name = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (name.equals("n1")) {
//            System.out.println("it was n1");
//        } else {
//            System.out.println("it was something else");
//            // Printing the read line
//            System.out.println(name);
            //===================================================


//        QuoteGrabber quoteGrabber = new QuoteGrabber();
//        quoteGrabber.scrapQuoteFromApi();
//        quoteGrabber.displayQuote();


//        }
    }
}