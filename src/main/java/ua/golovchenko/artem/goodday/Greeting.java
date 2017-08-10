package ua.golovchenko.artem.goodday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Artem on 08.08.2017.
 */
public class Greeting {
    private static final Logger logger = LoggerFactory.getLogger(Greeting.class);
    private static ResourceBundle messages;
    private static final String GOOD_MORNING = "good_morning_world";
    private static final String GOOD_DAY = "good_day_world";
    private static final String GOOD_EVENING ="good_evening_world";
    private static final String GOOD_NIGHT = "good_night_world";
    private static final String UNKNOWN_TIME_OF_THE_DAY = "Hello!";

    /**
     * @return String
     *
     */

    public static String getGreeting(LocalTime curTime, Locale locale){
        logger.debug("Method call getGreeting(LocalTime {}, Locale {})", curTime, locale);

        if(locale == null){ //Default locale en_US
            logger.debug("locale is null. Set defaul (en_US)");
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
            logger.info("Time of day undefined. Set default {}", e);
            msg = UNKNOWN_TIME_OF_THE_DAY;
        }

        return msg;
    }

    private static TimeOfDayIdentifier.TimeOfDay getTimeOfDay(LocalTime now) throws NullPointerException{
        logger.debug("Method call getTimeOfDay(LocalTime {})", now);

        TimeOfDayIdentifier identifier = new TimeOfDayIdentifierImpl();
        TimeOfDayIdentifier.TimeOfDay timeOfDay = null;

        if(identifier.isEvening(now)){return timeOfDay.EVENING;}
        if((identifier.isDay(now))){return timeOfDay.DAY;}
        if((identifier.isMorning(now))){return timeOfDay.MORINIG;}
        if((identifier.isNight(now))){timeOfDay = timeOfDay.NIGHT;}

        return timeOfDay;
    }

}
