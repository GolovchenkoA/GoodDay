package ua.golovchenko.artem.goodday;

import org.junit.Test;
import ua.golovchenko.artem.goodday.utils.CSVUtils;

import java.time.LocalTime;
import java.util.Collection;

import static org.junit.Assert.*;

public class GreetingTestDataDrivenCSV {

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

            if(timeOfDay.equals(TimeOfDayIdentifier.TimeOfDay.NIGHT)){
                time = LocalTime.of(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second));
                 assertEquals("NIGHT", identifier.isNight(time));
            }

            if(timeOfDay.equals(TimeOfDayIdentifier.TimeOfDay.MORINIG)){
                time = LocalTime.of(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second));
                assertEquals("MORNING", identifier.isNight(time));
            }

            if(timeOfDay.equals(TimeOfDayIdentifier.TimeOfDay.DAY)){
                time = LocalTime.of(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second));
                 assertEquals("DAY", identifier.isNight(time));
            }

             if(timeOfDay.equals(TimeOfDayIdentifier.TimeOfDay.EVENING)){
                time = LocalTime.of(Integer.parseInt(hour),Integer.parseInt(minute), Integer.parseInt(second));
                 assertEquals("EVENING", identifier.isNight(time));
            }

        }

    }
}