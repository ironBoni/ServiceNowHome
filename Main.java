import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final String INPUT_FILE_NAME = "input.txt";
        final String OUTPUT_FILE_NAME = "output.txt";
        List<String> lines = FileHandler.readFile(INPUT_FILE_NAME);

        NotesParser parser = new NotesParser();
        List<Entry> entries = parser.parse(lines);

        EntryGrouper grouper = new EntryGrouper();
        List<PatternGroup> groups = grouper.group(entries);

        OutputFormatter formatter = new OutputFormatter();
        List<String> output = formatter.format(groups);

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeFile(OUTPUT_FILE_NAME, output);
    }
}
