import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main3 {
    public static void main(String[] args) {
        LocalDateTime nowDateAndTime = LocalDateTime.ofEpochSecond(
                System.currentTimeMillis() / 1000, 0, ZoneOffset.ofHours(3));
        System.out.println("Преобразованная метки времени в дату и время: " + nowDateAndTime);

        LocalDateTime actualDateAndTime = LocalDateTime.now();
        long timeStamp = actualDateAndTime.toEpochSecond(ZoneOffset.ofHours(3));
        System.out.println("Преобразованная даты и времени в метку времени: " + timeStamp);
    }
}
