package ua.golovchenko.artem.goodday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by Artem on 08.08.2017.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        logger.info("The program is started");

        Locale currentLocale = Locale.getDefault();
        String message = Greeting.getGreeting(LocalTime.now(), currentLocale);
        System.out.println(message);

        logger.info("The program is finished");
    }
}
