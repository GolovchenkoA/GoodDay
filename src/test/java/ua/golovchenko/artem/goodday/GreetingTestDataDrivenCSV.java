package ua.golovchenko.artem.goodday;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.golovchenko.artem.goodday.utils.CSVUtils;

import java.time.LocalTime;
import java.util.Collection;

import static org.junit.Assert.*;

public class GreetingTestDataDrivenCSV {

    private static final Logger logger = LoggerFactory.getLogger(GreetingTestDataDrivenCSV.class);
    private static String MORNING = "MORNING";
    private static String DAY = "DAY";
    private static String EVENING = "EVENING";
    private static String NIGHT = "NIGHT";
    private static String TEST_DATA_FILE = "src/test/resources/DateTimeOfDay.csv";

    TimeOfDayIdentifier identifier = new TimeOfDayIdentifierImpl();

    @Test
    public void testGetGreetingWithDataFromCSV() throws Exception {

        LocalTime time = null;

        Collection<String[]> testData = CSVUtils.getTestData(TEST_DATA_FILE);

        for(String[] row : testData){
            String hour = row[0];
            String minute = row[1];
            String second = row[2];
            String timeOfDay = row[3];

            logger.debug("hour: {} minute: {} second: {} timeOfDay[from file]: {} ", hour, minute, second, timeOfDay);

            time = LocalTime.of(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second));

            if(timeOfDay.equals(NIGHT)){
                 assertEquals(TimeOfDayIdentifier.TimeOfDay.NIGHT, identifier.getTimeOfDay(time));
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.MORINIG, identifier.getTimeOfDay(time));
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.DAY, identifier.getTimeOfDay(time));
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.EVENING, identifier.getTimeOfDay(time));
            }

            if(timeOfDay.equals(MORNING)){
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.NIGHT, identifier.getTimeOfDay(time));
                assertEquals(TimeOfDayIdentifier.TimeOfDay.MORINIG, identifier.getTimeOfDay(time));
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.DAY, identifier.getTimeOfDay(time));
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.EVENING, identifier.getTimeOfDay(time));
            }

            if(timeOfDay.equals(DAY)){
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.NIGHT, identifier.getTimeOfDay(time));
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.MORINIG, identifier.getTimeOfDay(time));
                assertEquals(TimeOfDayIdentifier.TimeOfDay.DAY, identifier.getTimeOfDay(time));
                assertNotEquals(TimeOfDayIdentifier.TimeOfDay.EVENING, identifier.getTimeOfDay(time));
            }

             if(timeOfDay.equals(EVENING)){
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.NIGHT, identifier.getTimeOfDay(time));
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.MORINIG, identifier.getTimeOfDay(time));
                 assertNotEquals(TimeOfDayIdentifier.TimeOfDay.DAY, identifier.getTimeOfDay(time));
                 assertEquals(TimeOfDayIdentifier.TimeOfDay.EVENING, identifier.getTimeOfDay(time));
            }

        }

    }
}