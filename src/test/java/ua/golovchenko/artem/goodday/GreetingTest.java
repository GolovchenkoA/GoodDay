package ua.golovchenko.artem.goodday;

import org.junit.Assert;
import org.junit.Test;
import ua.golovchenko.artem.goodday.utils.CSVUtils;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.junit.Assert.*;


public class GreetingTest {

    private static final String GOOD_MORNING_EN = "Good morning, World!";
    private static final String GOOD_DAY_EN = "Good day, World!";
    private static final String GOOD_EVENING_EN ="Good evening, World!";
    private static final String GOOD_NIGHT_EN = "Good night, World!";
    private static final String UNKNOWN_TIME_OF_THE_DAY_EN = "Hello!";

    private static final String GOOD_MORNING_RU = "Доброе утро, Мир!";
    private static final String GOOD_DAY_RU = "Добрый день, Мир!";
    private static final String GOOD_EVENING_RU ="Добрый вечер, Мир!";
    private static final String GOOD_NIGHT_RU = "Доброй ночи, Мир!";
    private static final String UNKNOWN_TIME_OF_THE_DAY_RU = "Здравствуйте";


    private static final LocalTime morning = LocalTime.of(6,0,0);
    private static final LocalTime evening = LocalTime.of(19,0,0);
    private static final LocalTime day = LocalTime.of(15,0,0);
    private static final LocalTime night = LocalTime.of(2,0,0);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");


    @Test
    public void testGreetingInEnglish() throws Exception {

        Locale locale_en_US = new Locale.Builder().setLanguage("en").setRegion("US").build();
        assertEquals(GOOD_MORNING_EN, Greeting.getGreeting(morning, locale_en_US));
        assertEquals(GOOD_DAY_EN, Greeting.getGreeting(day, locale_en_US));
        assertEquals(GOOD_EVENING_EN, Greeting.getGreeting(evening,locale_en_US));
        assertEquals(GOOD_NIGHT_EN, Greeting.getGreeting(night, locale_en_US));
    }

    @Test
    public void testGreetingInEnglishByDefault() throws Exception {

        assertEquals(GOOD_MORNING_EN, Greeting.getGreeting(morning, null));
        assertEquals(GOOD_DAY_EN, Greeting.getGreeting(day, null));
        assertEquals(GOOD_EVENING_EN, Greeting.getGreeting(evening,null));
        assertEquals(GOOD_NIGHT_EN, Greeting.getGreeting(night, null));
    }



    @Test
    public void testGreetingInRussian() throws Exception {

        Locale locale_ru_RU = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
        assertEquals(GOOD_MORNING_RU, Greeting.getGreeting(morning, locale_ru_RU));
        assertEquals(GOOD_DAY_RU, Greeting.getGreeting(day, locale_ru_RU));
        assertEquals(GOOD_EVENING_RU, Greeting.getGreeting(evening,locale_ru_RU));
        assertEquals(GOOD_NIGHT_RU, Greeting.getGreeting(night, locale_ru_RU));
    }

    @Test
    public void testGetTestData() throws IOException {
        String pathToFile = "src/test/resources/DateTimeOfDay.csv";
        String[] row1 = new String[] {"0","0","0","NIGHT"};
        String[] row2 = new String[] {"12","0","0","DAY"};
        String[] row3 = new String[] {"8","0","0","MORNING"};
        Collection<String[]> testData = new ArrayList<String[]>();
        testData.add(row1);
        testData.add(row2);
        testData.add(row3);

        Collection<String[]> dataFromFile = CSVUtils.getTestData(pathToFile);

        Assert.assertTrue(dataFromFile.retainAll(testData));

    }

}