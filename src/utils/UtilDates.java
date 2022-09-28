package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilDates {

    public LocalDate StringToLocalDate(String value){
        value = this.validacaoDataDefault(value);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(value, formatter);
    }

    public LocalDate StringToLocalDate(String value, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(value, formatter);
    }

    public String localDateToString(LocalDate value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return value.format(formatter);
        
    }

    public String localDateToString(LocalDate value, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return value.format(formatter);
    }

    private String validacaoDataDefault(String value) {
        if (value.isBlank() || value.isEmpty()){
            return this.localDateToString(LocalDate.now());
        }
        return value;
    }
}
