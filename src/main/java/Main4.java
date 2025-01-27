import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main4 {
    public static void main(String[] args) {
        //System.out.println("All birthdays:\n" + collectBirthdays(2000, 12, 6));
        System.out.println("All birthdays:\n" + collectBirthdays2(2000, 12, 6));
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

    public static String collectBirthdays2(int year, int month, int day){
        LocalDate birthday = LocalDate.of(year, month, day);

        LocalDate today = LocalDate.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String strDate = birthday.format(dateTimeFormatter);

        String allDates = "";
        for(int i = 0; birthday.isBefore(today); i++ ){

            allDates += i + " - " + strDate + " - " + birthday.getDayOfWeek() + "\n";

            birthday = birthday.plusYears(1);
        }
        return allDates;
    }
}
