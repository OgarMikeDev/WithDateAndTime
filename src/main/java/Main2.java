public class Main2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int number = 10;
        for (int i = 0; i < 1_000_000_000; i++) {
            number += i + i;
        }

        long end = System.currentTimeMillis() - start;
        System.out.println("За " + end + " миллисекунд[ы] выполнилось 1 миллиарда операций");
    }
}
