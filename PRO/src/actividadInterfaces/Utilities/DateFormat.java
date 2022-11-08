package actividadInterfaces.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    private LocalDate birthday;
    /**
     * Defines the format that we want.
     */
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor for parse our date String to a format recognizable for our computer.
     * @param birthday
     */
    public DateFormat(String birthday) {
        this.birthday = LocalDate.parse(birthday,format);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday,format);
    }
}
