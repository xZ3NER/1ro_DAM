package ExamenUT7y8.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Extras {

    private Extras() {
    }

    public static String DoOperationWithDate(String date, int difference) throws ParseException { //Se puede con dias, meses, etc
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date newDate;
        newDate = dateFormat.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.add(Calendar.YEAR, difference); //+difference (if 5, YEAR+5)

        newDate = calendar.getTime();

        return dateFormat.format(newDate);
    }

    public static String GetSystemDate() {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(date);
    }

    public static String GetRandomNumberAsString() {
        String random;

        // Generate random number between 0 to 20
        random = String.valueOf(Math.random()*20);

        return random;
    }

    public static int GetRandomNumberAsInt() {
        int random;

        // Generate random number between 0 to 20
        random = (int) (Math.random()*20);

        return random;
    }

    public static double GetRandomNumberAsDouble() {
        double random;

        // Generate random number between 0 to 20
        random = Math.random()*20;

        return random;
    }
}
