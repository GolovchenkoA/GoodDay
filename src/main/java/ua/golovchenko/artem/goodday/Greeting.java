package ua.golovchenko.artem.goodday;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Artem on 08.08.2017.
 */
public class Greeting {
    private static ResourceBundle messages;
    private static final String GOOD_MORNING = "good_morning_world"; // в 06:00 - 09:00
    private static final String GOOD_DAY = "good_day_world"; // в 09:00 - 19:00
    private static final String GOOD_EVENING ="good_evening_world"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT = "good_night_world"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY = "Hello!"; // в 23:00 - 06:00

    /**
     * @return String
     *
     */

    public static String getGreeting(LocalTime curTime, Locale locale){
        if(locale == null){ //Default locale en_US
            locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
        }

        messages = ResourceBundle.getBundle("message", locale);
        String msg = null;

        try{
            TimeOfDayIdentifier.TimeOfDay now = getTimeOfDay(curTime);

            switch (now){
                case NIGHT:msg = messages.getString(GOOD_NIGHT);                break;
                case MORINIG:msg = messages.getString(GOOD_MORNING);            break;
                case DAY:msg = messages.getString(GOOD_DAY);                    break;
                case EVENING:msg = messages.getString(GOOD_EVENING);            break;
                default:msg = UNKNOWN_TIME_OF_THE_DAY;

            }
        }catch (NullPointerException e){

            msg = UNKNOWN_TIME_OF_THE_DAY;
        }

        return msg;
    }

    private static TimeOfDayIdentifier.TimeOfDay getTimeOfDay(LocalTime now) throws NullPointerException{
        TimeOfDayIdentifier identifier = new TimeOfDayIdentifierImpl();
        TimeOfDayIdentifier.TimeOfDay timeOfDay = null;

        if(identifier.isEvening(now)){return timeOfDay.EVENING;}
        if((identifier.isDay(now))){return timeOfDay.DAY;}
        if((identifier.isMorning(now))){return timeOfDay.MORINIG;}
        if((identifier.isNight(now))){timeOfDay = timeOfDay.NIGHT;}

        return timeOfDay;
    }

}
