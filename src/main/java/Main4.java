import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main4 {
    public static void main(String[] args) {
        //System.out.println("All birthdays:\n" + collectBirthdays(2000, 12, 6));
        System.out.println("All birthdays:\n" + collectBirthdays2(2000, 12, 6));
        System.out.println("Времени прошло с дата основания java:\n" + getPeriodFromBirthday(LocalDate.now(), LocalDate.of(1995, 5, 23)));
    }

    public static String collectBirthdays(int year, int month, int day) {
        StringBuilder allBirthdays = new StringBuilder();
        LocalDate nowDate = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (int index = 0; birthday.isBefore(nowDate); index++) {
            String strDate = dateTimeFormatter.format(birthday);
            allBirthdays.append(index + " - " + strDate + " - " + birthday.getDayOfWeek() + "\n");
            birthday = birthday.plusYears(1);
        }
        return String.valueOf(allBirthdays);
    }

    public static String collectBirthdays2(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);

        LocalDate today = LocalDate.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        String allDates = "";
        for (int i = 0; birthday.isBefore(today); i++) {

            String strDate = birthday.format(dateTimeFormatter);
            allDates += i + " - " + strDate + " - " + birthday.getDayOfWeek() + "\n";

            birthday = birthday.plusYears(1);
        }
        return allDates;
    }

    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        int differenceYears = firstDate.getYear() - secondDate.getYear();
        int differenceMonths = Math.abs(firstDate.getMonthValue() - secondDate.getMonthValue());
        int differenceDays = Math.abs(firstDate.getDayOfMonth() - secondDate.getDayOfMonth());
        String fullDifference = "years: " + differenceYears + ", months: " + differenceMonths + ", days: " + differenceDays;
        return fullDifference;
    }
}
