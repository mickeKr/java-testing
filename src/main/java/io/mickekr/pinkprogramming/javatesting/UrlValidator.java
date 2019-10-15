package io.mickekr.pinkprogramming.javatesting;

import java.net.URL;

public class UrlValidator {
    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }
}
