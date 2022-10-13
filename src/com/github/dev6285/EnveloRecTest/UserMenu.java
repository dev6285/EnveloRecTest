package com.github.dev6285.EnveloRecTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMenu {
    private static int nextCounter;                     // Counter for checking how many quotes have been requested
    private static QuoteGrabber quoteGrabber;
    private static UserMenu INSTANCE;

    private UserMenu() {
        nextCounter = 0;
        quoteGrabber = new QuoteGrabber();
        loadUserMenu();
    }

    public static UserMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserMenu();
        }
        return INSTANCE;
    }

    public static void loadUserMenu() {
        quoteGrabber.showInitialQuoteInMenu();                   //show a quote for the first time when App is started
        processUserCommands();                                   //logic behind user typed commands in console

    }

    private static void processUserCommands() {
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
                quoteGrabber.scrapQuoteFromApi();
                while (QuoteDb.checkIfItsAlreadyInTheDb(quoteGrabber.getQuote())) { // is the latest quote already in the DB?
                    quoteGrabber.scrapQuoteFromApi();
                }

                QuoteDb.addContent(quoteGrabber.getQuote());
                setNextCounter();

                quoteGrabber.displayQuote();
                processUserCommands();
                break;

            case ":q!":
                System.out.println("Ok, bye!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose something else.");
                processUserCommands();
                break;


            /*
            debug tools:
             */
            case "SELECT * FROM quotesDb":      // I'm kidding, just showing off with my mad SQL skills ;)
            case "db":
                QuoteDb.fullDbDisplay();
                break;
            case "show last":
                QuoteDb.displayDB(nextCounter - 1);
                processUserCommands();
                break;
        }
    }

    public static void setNextCounter() {
        nextCounter++;
    }

}