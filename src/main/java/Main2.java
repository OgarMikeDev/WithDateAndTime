public class Main2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        String line = "";
        for (int i = 0; i < 100_000; i++) {
            line += Math.random();
        }

        long end = System.currentTimeMillis();

        long difference = end - start;
        System.out.println("Цикл for работал " + (difference / 1000) + " секунд!");
    }
}
