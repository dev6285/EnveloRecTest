package com.github.dev6285.EnveloRecTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMenu {

    public void loadUserMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userCommand = "";
        try {
            userCommand = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (userCommand) {
            case "next":
            case "NEXT":
                System.out.println("Quote:");
                QuoteGrabber quoteGrabber = new QuoteGrabber();
                quoteGrabber.scrapQuoteFromApi();
                quoteGrabber.displayQuote();
                loadUserMenu();
                break;
            case ":q!":
                System.out.println("Ok, bye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please chose something else.");
                loadUserMenu();
                break;
        }
    }
}