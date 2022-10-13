package com.github.dev6285.EnveloRecTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMenu {
    private static int nextCounter;    // Counter for checking how many quotes have been requested
    private static UserMenu INSTANCE;

    private UserMenu() {
        nextCounter = 0;
    }

    public static UserMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserMenu();
        }
        return INSTANCE;
    }

    public static void loadUserMenu() {
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


                while (!QuoteDb.checkIfItsAlreadyInTheDb(quoteGrabber.getQuote())) { // is the quote in the DB already?
//                    if (QuoteDb.checkIfItsAlreadyInTheDb(quoteGrabber.getQuote())) {
//                        System.out.println("debug: quote WAS in the DB, scraping for a new one");
                        quoteGrabber.scrapQuoteFromApi();
//                    } else {
                        System.out.println("debug: WAS not in the DB, adding to DB");
                        QuoteDb.addContent(quoteGrabber.getQuote());
                        setNextCounter();
                    }

                quoteGrabber.displayQuote();
                System.out.println("next counter: "+getNextCounter());
                loadUserMenu();
                break;
            case ":q!":
                System.out.println("Ok, bye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please chose something else.");
                loadUserMenu();
                break;

            /*
            debug tools:
             */
            case "db":
                QuoteDb.fullDbDisplay();
                break;
            case "show last":
                QuoteDb.displayDB(nextCounter-1);
                loadUserMenu();
                break;
        }
    }

    public static void setNextCounter() {
        nextCounter++;
    }

    public static int getNextCounter() {
        return nextCounter;
    }
}