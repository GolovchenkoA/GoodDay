package ua.golovchenko.artem.goodday;

import java.time.LocalTime;

/**
 * Created by Artem on 08.08.2017.
 *
 *
 *
 */
public class Greeting {
    private static final String GOOD_MORNING = "Good morning, World!"; // в 06:00 - 09:00
    private static final String GOOD_DAY = "Good day, World!"; // в 09:00 - 19:00
    private static final String GOOD_EVENING ="Good evening, World!"; // в 19:00 - 23:00
    private static final String GOOD_NIGHT = "Good night, World!"; // в 23:00 - 06:00
    private static final String UNKNOWN_TIME_OF_THE_DAY = "Hello!"; // в 23:00 - 06:00



    /**
     * @return String
     *
     */

    public static String getGreeting(LocalTime curTime){
        String message = null;
        //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //j ava . ti.Jнl . temporal

/*        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        sdf.format(date);*/


        try{
            TimeOfDayIdentifier.TimeOfDay now = getTimeOfDay(curTime);

            switch (now){
                case NIGHT:message = GOOD_NIGHT;
                    break;
                case MORINIG:
                    message = GOOD_MORNING;
                    break;
                case DAY:
                    message = GOOD_DAY;
                    break;
                case EVENING:
                    message = GOOD_EVENING;
                    break;
                default:
                    message = UNKNOWN_TIME_OF_THE_DAY;

            }
        }catch (NullPointerException e){

            message = UNKNOWN_TIME_OF_THE_DAY;
        }

        return message;
    }


    private static TimeOfDayIdentifier.TimeOfDay getTimeOfDay(LocalTime now) throws NullPointerException{
        TimeOfDayIdentifier identifier = new TimeOfDayIdentifierImpl();
        TimeOfDayIdentifier.TimeOfDay timeOfDay = null;

        if(identifier.isEvening(now)){
            return timeOfDay.EVENING;
        }


        if((identifier.isDay(now))){
            return timeOfDay.DAY;
        }

        if((identifier.isMorning(now))){
            return timeOfDay.MORINIG;
        }

        if((identifier.isNight(now))){
            timeOfDay = timeOfDay.NIGHT;
        }

        return timeOfDay;
    }

}
