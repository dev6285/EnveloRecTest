package com.github.dev6285.EnveloRecTest;

import java.util.ArrayList;
import java.util.List;

public class QuoteDb {
    static List<String> quotesDb;
    private static QuoteDb INSTANCE;

    private QuoteDb() {
        quotesDb = new ArrayList<>();
    }

    /*
    I've used a singleton pattern because we need only one DB.
     */
    public static QuoteDb getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuoteDb();
        }
        return INSTANCE;
    }

    /*
    Adds a quote to the DB
     */
    public static void addContent(String addedContent) {
        quotesDb.add(addedContent);
    }

    /*
    Displays a record from the DB based on its index number.
     */
    public static void displayDB(int index) {
        System.out.println(quotesDb.get(index));
    }

    /*
    Tests if the current quote was already shown during current session.
     */
    public static boolean checkIfItsAlreadyInTheDb(String quoteTested) {
        return quotesDb.contains(quoteTested);
    }

    /*
    Displays entire database of quotes that have been shown so far.
     */
    public static void fullDbDisplay() {
        System.out.println("Full database of quotes so far:");
        quotesDb.forEach(quote ->{
            System.out.println(quote);
        });
    }

}
