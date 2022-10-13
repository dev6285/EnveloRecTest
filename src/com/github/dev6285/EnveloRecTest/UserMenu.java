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
//                setNextCounter();
                System.out.println("Quote:");
                QuoteGrabber quoteGrabber = new QuoteGrabber();
                quoteGrabber.scrapQuoteFromApi();

//                System.out.println(QuoteDb.testT(quoteGrabber.getQuote())); // is it in the DB already?
                while (QuoteDb.checkIfItsAlreadyInTheDb(quoteGrabber.getQuote())) {
                    if (QuoteDb.checkIfItsAlreadyInTheDb(quoteGrabber.getQuote())) {
                        System.out.println("debug: quote WAS in the DB, scraping for a new one");
                        quoteGrabber.scrapQuoteFromApi();
                    } else {
                        System.out.println("debug: WAS not in the DB, adding to DB");
                        QuoteDb.addContent(quoteGrabber.getQuote());
                        setNextCounter();
                    }
                }

//                if (QuoteDb.testT(quoteGrabber.getQuote())) {
//                    QuoteDb.addContent(quoteGrabber.getQuote());
//                } else {
//                    quoteGrabber.scrapQuoteFromApi();
//                }

//                QuoteDb.addContent(quoteGrabber.getQuote());
//                System.out.println("debug (DB preview): ");
//                QuoteDb.displayDB(getNextCounter());

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

            /*
            debug tools:
             */
            case "db":
                QuoteDb.fullDbDisplay();
                break;
            case "show last":
                QuoteDb.displayDB(getNextCounter());
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