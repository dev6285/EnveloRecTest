package com.github.dev6285.EnveloRecTest;

public class Main {

    public static void main(String[] args) {
        WelcomeMsg.getInstance();                   // Introduction and commands summary.

        QuoteDb.getInstance();                      // Setup the database for quotes.

        UserMenu.getInstance();                     // Setup the user UI.
    }
}