import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("Date: " + date);

        LocalDate today = LocalDate.now();
        System.out.println("Local date: " + today);

        LocalDate birthDay = LocalDate.of(1999, 12, 6);
        System.out.println("День моего рождения: " + birthDay.plusYears(1));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        LocalDateTime nowNY = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Date and time in New York: " + nowNY);

        String strDate = "20/01/2025";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(strDate, dateTimeFormatter);
        System.out.println("Текущая дата, преобразованная из str: " + localDate);

//        DateTimeFormatter actualDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        DateTimeFormatter actualDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter actualDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .localizedBy(new Locale("us"));
        LocalDateTime actualLocalDateTime = LocalDateTime.now();
        String updateDateAndTime = actualDateTimeFormatter.format(actualLocalDateTime);
        System.out.println("Преобразование даты и времени: " + updateDateAndTime);

        LocalDateTime firstDateAndTime = LocalDateTime.now();
        LocalDateTime secondDateAndTime = LocalDateTime.now().plusDays(2);

//        if (firstDateAndTime.isAfter(secondDateAndTime)) {
//            System.out.println("Первая дата позже второй!");
//        } else if (firstDateAndTime.isEqual(secondDateAndTime)) {
//            System.out.println("Даты равны!");
//        } else if (firstDateAndTime.isBefore(secondDateAndTime)) {
//            System.out.println("Первая дата раньше второй!");
//        }

        if (firstDateAndTime.compareTo(secondDateAndTime) > 0) {
            System.out.println("Первая дата позже второй!");
        } else if (firstDateAndTime.compareTo(secondDateAndTime) == 0) {
            System.out.println("Даты равны!");
        } else if (firstDateAndTime.compareTo(secondDateAndTime) < 0) {
            System.out.println("Первая дата раньше второй!");
        }

        long difference = firstDateAndTime.until(secondDateAndTime, ChronoUnit.DAYS);
        System.out.println(
                "Разница между числами " + firstDateAndTime + ", " + secondDateAndTime +
                        " равна " + difference + " дня");
    }
}
