package ua.golovchenko.artem.goodday;

import java.time.LocalTime;

/**
 * Created by Artem on 08.08.2017.
 */
public interface TimeOfDayIdentifier {
    public enum TimeOfDay{NIGHT,MORINIG,DAY,EVENING};

    public Enum<TimeOfDay> getTimeOfDay(LocalTime time);
    public boolean isNight(LocalTime time);
    public boolean isMorning(LocalTime time);
    public boolean isDay(LocalTime time);
    public boolean isEvening(LocalTime time);
}
