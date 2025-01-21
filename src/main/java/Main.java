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

        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        LocalDate birthday = LocalDate.of(2000, 12, 6);
        System.out.println("Birthday LocalDate.of(): " + birthday);

        LocalDate adulthood = birthday.plusYears(18);
        System.out.println("18 лет мне исполнилось в " + adulthood + " году!");

        LocalDateTime dateTimeNY = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Дата и время в Нью-Йорке сейчас: " + dateTimeNY);

        String strDate = "21?01?2025";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd?MM?yyyy");
        LocalDate localDateFromStrDate = LocalDate.parse(strDate, dateTimeFormatter);
        System.out.println("Преобразованная дата из строкового значения: " + localDateFromStrDate);

        LocalDateTime localDateTimeForParsing = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatterForParsing =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        DateTimeFormatter dateTimeFormatterForParsing =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatterForParsing =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .localizedBy(new Locale("us"));
        String strDateTimeFromLDT = dateTimeFormatterForParsing.format(localDateTimeForParsing);
        System.out.println("Преобразованная дата из LocalDateTime: " + strDateTimeFromLDT);

        LocalDateTime firstDateTime = LocalDateTime.now();
        LocalDateTime secondDateTime = LocalDateTime.now().plusDays(2);

//        if (firstDateTime.isBefore(secondDateTime)) {
//            System.out.println("Первая дата раньше второй!");
//        } else if (firstDateTime.isEqual(secondDateTime)) {
//            System.out.println("Даты равны!");
//        } else if (firstDateTime.isAfter(secondDateTime)) {
//            System.out.println("Первая дата позже второй!");
//        }

        if (firstDateTime.compareTo(secondDateTime) < 0) {
            System.out.println("Первая дата раньше второй!");
        } else if (firstDateTime.compareTo(secondDateTime) == 0) {
            System.out.println("Даты равны!");
        } else if (firstDateTime.compareTo(secondDateTime) > 0) {
            System.out.println("Первая дата позже второй!");
        }

        long difference = firstDateTime.until(secondDateTime, ChronoUnit.HOURS);
        System.out.println(
                "Разница между датами \n" + firstDateTime +
                        "\n" + secondDateTime +
                        "\nравна " + difference + " часам!");
    }
}
