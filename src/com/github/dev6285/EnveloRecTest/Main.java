package com.github.dev6285.EnveloRecTest;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        WelcomeMsg welcomeMsg = new WelcomeMsg();
        welcomeMsg.sayHello();                      // Introduction and commands summary.

        QuoteGrabber quoteGrabber = new QuoteGrabber();
        quoteGrabber.scrapQuoteFromApi();
        quoteGrabber.displayQuote();
    }
}