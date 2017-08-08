package ua.golovchenko.artem.goodday;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by Artem on 08.08.2017.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale currentLocale = Locale.getDefault();
        String message = Greeting.getGreeting(LocalTime.now(), currentLocale);
        System.out.println(message);
    }
}
