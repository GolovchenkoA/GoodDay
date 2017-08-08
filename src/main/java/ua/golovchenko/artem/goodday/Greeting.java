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
    private static final LocalTime NIGHT_BEGIN = LocalTime.of(23,0,0);;
    private static final LocalTime EVENING_BEGIN = LocalTime.of(19,0,0);;
    private static final LocalTime DAY_BEGIN = LocalTime.of(9,0,0);;
    private static final LocalTime MORINIG_BEGIN = LocalTime.of(6,0,0);;

    public enum TimeOfDay{NIGHT,MORINIG,DAY,EVENING};


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
            TimeOfDay now = getTimeOfDay(curTime);

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


    private static TimeOfDay getTimeOfDay(LocalTime now) throws NullPointerException{
        TimeOfDay timeOfDay = null;

        if(isEvening(now)){
            return timeOfDay.EVENING;
        }


        if((now.equals(DAY_BEGIN) || now.isAfter(DAY_BEGIN)) && now.isBefore(EVENING_BEGIN)){
            return timeOfDay.DAY;
        }

        if((now.equals(MORINIG_BEGIN) || now.isAfter(MORINIG_BEGIN)) && now.isBefore(DAY_BEGIN)){
            return timeOfDay.MORINIG;
        }

        if( (now.equals(NIGHT_BEGIN) || now.isAfter(NIGHT_BEGIN)) && now.isBefore(MORINIG_BEGIN)){
            timeOfDay = timeOfDay.NIGHT;
        }

        return timeOfDay;
    }

    private static boolean isEvening(LocalTime now) {
        boolean isEvening = false;

        if((now.equals(EVENING_BEGIN)) || now.isAfter((EVENING_BEGIN)) && now.isBefore(NIGHT_BEGIN)){
            isEvening = true;
        }
        return isEvening;

    }
}
