package ua.golovchenko.artem.goodday;

import java.time.LocalTime;

/**
 * Created by Artem on 08.08.2017.
 */
public class TimeOfDayIdentifierImpl implements TimeOfDayIdentifier {

    private static final LocalTime NIGHT_BEGIN = LocalTime.of(23,0,0);;
    private static final LocalTime EVENING_BEGIN = LocalTime.of(19,0,0);;
    private static final LocalTime DAY_BEGIN = LocalTime.of(9,0,0);;
    private static final LocalTime MORINIG_BEGIN = LocalTime.of(6,0,0);;

    @Override
    public Enum<TimeOfDay> getTimeOfDay(LocalTime time) {
        TimeOfDay timeOfDay = null;
        if(isEvening(time)){ return timeOfDay.EVENING;}
        if(isDay(time)){return timeOfDay.DAY;}
        if(isMorning(time)){return timeOfDay.MORINIG;}
        if( isNight(time)){timeOfDay = timeOfDay.NIGHT;}

        return timeOfDay;
    }

    @Override
    public boolean isNight(LocalTime time) {
        boolean isNight = false;
        if((time.equals(NIGHT_BEGIN) || time.isAfter(NIGHT_BEGIN))
                || (((time.isAfter(LocalTime.of(0,0,0))&& time.isBefore(MORINIG_BEGIN))
                || time.equals(LocalTime.of(0,0,0))))){
            isNight = true;
        }
        return isNight;
    }

    @Override
    public boolean isMorning(LocalTime time) {
        boolean isMorinig = false;
        if((time.equals(MORINIG_BEGIN) || time.isAfter(MORINIG_BEGIN)) && time.isBefore(DAY_BEGIN)){
            isMorinig = true;
        }
        return isMorinig;
    }

    @Override
    public boolean isDay(LocalTime time) {
        boolean isDay = false;
        if((time.equals(DAY_BEGIN) || time.isAfter(DAY_BEGIN)) && time.isBefore(EVENING_BEGIN)){
            isDay = true;
        }
        return isDay;
    }

    @Override
    public boolean isEvening(LocalTime time) {
        boolean isEvening = false;

        if((time.equals(EVENING_BEGIN)) || time.isAfter((EVENING_BEGIN)) && time.isBefore(NIGHT_BEGIN)){
            isEvening = true;
        }
        return isEvening;
    }
}
