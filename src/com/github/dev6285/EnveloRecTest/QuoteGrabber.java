package com.github.dev6285.EnveloRecTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class QuoteGrabber {
        private String quote;

    public QuoteGrabber(){
        quote = "Quote not obtained yet.";
    }

    /*
    Engine for scraping quotes is a simplified solution from https://stackoverflow.com/questions/5867975/reading-websites-contents-into-string
    My first thought was to parse the JSON from the https://api.kanye.rest/, but after reading
    the documentation for the API (https://github.com/ajzbc/kanye.rest) I've decided it'll be easier and faster
    to scrap only the String based on the simplified version (https://api.kanye.rest/text).

    !!! Well, to make it clean and legitimate this should be an asynchronous call, but I'm afraid I won't have time
        before the task deadline for debuging the DB part related issues (e.g. numbering of quotes in the DB
        if you type "next" faster than the API delivers new quotes. The menu commands would need to wait for
        the asynch call to give the "ready" signal from the API data grabber, etc.)
     */
    public void scrapQuoteFromApi() {
        try {
            URL url = new URL("https://api.kanye.rest/text");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            inputStream.close();
            setQuote(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    /*
    Forwards the quote that was scraped most recently. There's room here for some kind of validation, for e.g. if the
    API server would change specification, or for catching http errors (404 etc).
     */
    public String getQuote() {
        return quote;
    }

    /*
    Prints the quote that was scraped most recently.
     */
    public void displayQuote() {
        System.out.println(getQuote());
    }

    /*
    Shows the initial quote when user starts the up.
     */
    public void showInitialQuoteInMenu(){
        scrapQuoteFromApi();
        System.out.println("Quote: ");
        displayQuote();
    }
}



