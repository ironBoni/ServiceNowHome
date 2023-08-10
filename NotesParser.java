import java.util.ArrayList;
import java.util.List;

public class NotesParser {
    private final int LENGTH_OF_PREFIX = 20;
    public List<Entry> parse(List<String> lines) {
        List<Entry> entries = new ArrayList<>();

        for (String line : lines) {
            entries.add(new Entry(line.substring(0, LENGTH_OF_PREFIX - 1), line.substring(LENGTH_OF_PREFIX)));
        }

        return entries;
    }
}
