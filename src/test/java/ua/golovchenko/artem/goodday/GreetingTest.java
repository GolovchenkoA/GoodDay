package ua.golovchenko.artem.goodday;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

public class GreetingTest {

    private static final String GOOD_MORNING = "Good morning, World!"; // в 06:00 - 09:00
    private static final String GOOD_DAY = "Good day, World!"; // в 09:00 - 19:00
    private static final String GOOD_EVENING ="Good evening, World!"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT = "Good night, World!"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY = "Hello!"; // в 23:00 - 06:00

    private static final LocalTime morning = LocalTime.of(6,0,0);
    private static final LocalTime evening = LocalTime.of(19,0,0);
    private static final LocalTime day = LocalTime.of(15,0,0);
    private static final LocalTime night = LocalTime.of(2,0,0);

    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);

    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss[.SSSSSS]");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");


    @Test
    public void testGoodMorning() throws Exception {
        assertEquals(GOOD_MORNING, Greeting.getGreeting(morning));
        assertEquals(GOOD_DAY, Greeting.getGreeting(day));
        assertEquals(GOOD_EVENING, Greeting.getGreeting(evening));
        assertEquals(GOOD_NIGHT, Greeting.getGreeting(night));
    }
}