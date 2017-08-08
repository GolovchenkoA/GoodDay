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

    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);

    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss[.SSSSSS]");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");


    @Test
    public void testGoodMorning() throws Exception {

        //String time = "2001-01-01 06:00:00";
        //String time = "06:00:00.000";
        //String time = "2001/01/01 06:00:00";
/*        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        LocalTime now = localDateTime.toLocalTime();*/
        //LocalTime now = LocalTime.parse(time,DateTimeFormatter.ISO_LOCAL_TIME);
            LocalTime now = LocalTime.of(4,0,0);

        //assertEquals(GOOD_MORNING,Greeting.getGreeting(now));
        assertEquals(GOOD_MORNING, Greeting.getGreeting(now));

    }
}