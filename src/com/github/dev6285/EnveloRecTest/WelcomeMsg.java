package com.github.dev6285.EnveloRecTest;

public class WelcomeMsg {
    final String welcomeMsg = "==============================================================\n" +
            "Hi!\n" +
            "Welcome to my \"Akademia Envelo w PKP Informatyka\" test.\n" +
            "Here you'll find the task#3 \"API Kanye Rest\" console app.\n" +
            "Type \"NEXT\" for a different quote.\n" +
            "Type \":q!\" to exit.\n" +
            "==============================================================\n\n";

    /*  This could be a getter, but this way we can add some data validation, like different msg for different users,
     or msg depending on the current date etc. */
    public void sayHello() {
        System.out.println(welcomeMsg);
    }
}
