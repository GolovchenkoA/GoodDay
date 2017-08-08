package ua.golovchenko.artem.goodday;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.Assert.*;

public class GreetingTest {

    private static final String GOOD_MORNING_EN = "Good morning, World!"; // в 06:00 - 09:00
    private static final String GOOD_DAY_EN = "Good day, World!"; // в 09:00 - 19:00
    private static final String GOOD_EVENING_EN ="Good evening, World!"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT_EN = "Good night, World!"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY_EN = "Hello!"; // в 23:00 - 06:00

    private static final String GOOD_MORNING_RU = "Доброе утро, Мир!"; // в 06:00 - 09:00
    private static final String GOOD_DAY_RU = "Добрый день, Мир!"; // в 09:00 - 19:00
    private static final String GOOD_EVENING_RU ="Добрый вечер, Мир!"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT_RU = "Доброй ночи, Мир!"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY_RU = "Здравствуйте"; // в 23:00 - 06:00


    private static final LocalTime morning = LocalTime.of(6,0,0);
    private static final LocalTime evening = LocalTime.of(19,0,0);
    private static final LocalTime day = LocalTime.of(15,0,0);
    private static final LocalTime night = LocalTime.of(2,0,0);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");


    @Test
    public void testGoodMorningInEnglish() throws Exception {

        Locale locale_en_US = new Locale.Builder().setLanguage("en").setRegion("US").build();
        assertEquals(GOOD_MORNING_EN, Greeting.getGreeting(morning, locale_en_US));
        assertEquals(GOOD_DAY_EN, Greeting.getGreeting(day, locale_en_US));
        assertEquals(GOOD_EVENING_EN, Greeting.getGreeting(evening,locale_en_US));
        assertEquals(GOOD_NIGHT_EN, Greeting.getGreeting(night, locale_en_US));
    }

    @Test
    public void testGoodMorningInRussian() throws Exception {

        Locale locale_ru_RU = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
        assertEquals(GOOD_MORNING_RU, Greeting.getGreeting(morning, locale_ru_RU));
        assertEquals(GOOD_DAY_RU, Greeting.getGreeting(day, locale_ru_RU));
        assertEquals(GOOD_EVENING_RU, Greeting.getGreeting(evening,locale_ru_RU));
        assertEquals(GOOD_NIGHT_RU, Greeting.getGreeting(night, locale_ru_RU));
    }


}