import java.io.*;
import java.util.*;

public class FileHandler {
    public FileHandler() {
    }
    public static List<String> readFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    public void writeFile(String filename, List<String> lines) throws IOException {
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }
}
