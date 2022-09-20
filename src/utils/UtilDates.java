package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilDates {

    public static LocalDateTime StringToLocalDateTime(String value, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(value, formatter);
    }

    public static String localDateTimeToString(LocalDateTime value, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return value.format(formatter);
    }
}
