package com.github.dev6285.EnveloRecTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        WelcomeMsg welcomeMsg = new WelcomeMsg();
        welcomeMsg.sayHello();                      // Introduction and commands summary.

        QuoteDb.getInstance();                      // Setup the database for quotes.

        UserMenu userMenu = new UserMenu();
        userMenu.loadUserMenu();                    // Setup the user UI.

    }
}