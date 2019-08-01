import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths; 
import java.util.Map;
import java.util.TreeMap;

public class FileOperation {
    Path file;

    public FileOperation() {
        file = Paths.get("src/main/resources/south.txt");
        System.out.println("Filename: " + file.getFileName().toString());
        System.out.println("File exits: " + file.toFile().exists());
        System.out.println("Size of file: " + file.toFile().length() + " bytes");
    }


    public int wordCount() {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while ((line = br.readLine()) != null){
                count = count + line.split(" ").length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int wordCountLongerThanFive() {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while ((line = br.readLine()) != null){
                for (String word: line.split(" ")) {
                    if (word.length() > 5)
                        count = count + 1;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Map<Integer, Integer> wordsLengthHistogram(){
        Map<Integer, Integer> histogram = new TreeMap<>();
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while ((line = br.readLine()) != null){
                for (String word: line.split(" ")) {
                    int length = word.length();
                    if ( histogram.containsKey(length) ){
                        histogram.put(length, histogram.get(length) + 1);
                    }else {
                        histogram.put(length, 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return histogram;
    }
}
