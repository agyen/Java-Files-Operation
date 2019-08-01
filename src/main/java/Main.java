import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    private void run() {
        FileOperation fop = new FileOperation();
        System.out.println("Number of words: " + fop.wordCount());
        System.out.println("Number of words longer than five: " + fop.wordCountLongerThanFive());
        System.out.println("*******************************************************");

        for (Map.Entry<Integer, Integer> words : fop.wordsLengthHistogram().entrySet())
            System.out.println("Word Length: " + words.getKey() + ", Count: " + words.getValue());
    }
}
