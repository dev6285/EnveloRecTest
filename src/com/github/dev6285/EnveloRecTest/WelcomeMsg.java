package com.github.dev6285.EnveloRecTest;

public class WelcomeMsg {
    private static WelcomeMsg INSTANCE;

    public WelcomeMsg(){
        sayHello();
    }
    public static WelcomeMsg getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WelcomeMsg();
        }
        return INSTANCE;
    }

    final String welcomeMsg = "==============================================================\n" +
            "Hi!\n" +
            "Welcome to my \"Akademia Envelo w PKP Informatyka\" test.\n" +
            "Here you'll find the task#3 \"API Kanye Rest\" console app.\n" +
            "Type \"NEXT\" for a different quote.\n" +
            "Type \":q!\" to exit.\n" +
            "==============================================================\n";

    public void sayHello() {
        System.out.println(welcomeMsg);
    }
}
