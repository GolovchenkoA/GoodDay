package ua.golovchenko.artem.goodday;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TimeOfDayIdentifierImplTest {

    private static final String GOOD_MORNING = "Good morning, World!"; // в 06:00 - 09:00
    private static final String GOOD_DAY = "Good day, World!"; // в 09:00 - 19:00
    private static final String GOOD_EVENING ="Good evening, World!"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT = "Good night, World!"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY = "Hello!"; // в 23:00 - 06:00

    private static final LocalTime morning = LocalTime.of(6,0,0);
    private static final LocalTime evening = LocalTime.of(19,0,0);
    private static final LocalTime day = LocalTime.of(15,0,0);
    private static final LocalTime night = LocalTime.of(2,0,0);

    TimeOfDayIdentifier timeOfDayIdentifier = new TimeOfDayIdentifierImpl();

    @Before
    public void init(){

    }

    @Test
    public void testIsEvening() throws Exception {
        assertEquals(false, timeOfDayIdentifier.isEvening(morning));
        assertEquals(false, timeOfDayIdentifier.isEvening(night));
        assertEquals(false, timeOfDayIdentifier.isEvening(day));
        assertEquals(true, timeOfDayIdentifier.isEvening(evening));

    }

    @Test
    public void testIsDay(){
        assertEquals(false, timeOfDayIdentifier.isDay(morning));
        assertEquals(false, timeOfDayIdentifier.isDay(evening));
        assertEquals(false, timeOfDayIdentifier.isDay(night));
        assertEquals(true, timeOfDayIdentifier.isDay(day));
    }



    @Test
    public void testIsMorning(){
        assertEquals(true, timeOfDayIdentifier.isMorning(morning));
        assertEquals(false, timeOfDayIdentifier.isMorning(evening));
        assertEquals(false, timeOfDayIdentifier.isMorning(day));
        assertEquals(false, timeOfDayIdentifier.isMorning(night));
    }


    @Test
    public void testIsNight(){
        assertEquals(false, timeOfDayIdentifier.isNight(morning));
        assertEquals(false, timeOfDayIdentifier.isNight(evening));
        assertEquals(false, timeOfDayIdentifier.isNight(day));
        assertEquals(true, timeOfDayIdentifier.isNight(night));
    }


}