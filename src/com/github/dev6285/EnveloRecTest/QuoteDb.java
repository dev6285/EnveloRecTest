package com.github.dev6285.EnveloRecTest;

import java.util.ArrayList;
import java.util.List;

public class QuoteDb {
    static List<String> quotesDb;
    private static QuoteDb INSTANCE;

    private QuoteDb() {
        quotesDb = new ArrayList<>();
    }

    public static QuoteDb getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuoteDb();
        }
        return INSTANCE;
    }


    public static void addContent(String addedContent) {
        quotesDb.add(addedContent);
    }

    public static void displayDB(int index) {
        System.out.println(quotesDb.get(index));
    }

    public static boolean checkIfItsAlreadyInTheDb(String quoteTested) {
        return quotesDb.contains(quoteTested);
    }

    public static void fullDbDisplay() {
        System.out.println("Full DB be like:");
        quotesDb.forEach(quote ->{
            System.out.println(quote);
        });
    }

}
