import java.util.*;

public class PatternGroup {
    private final List<Entry> entries = new ArrayList<>();
    private Set<String> differingWords = new HashSet<>();

    public void addEntry(Entry entry, String differingWord) {
        entries.add(entry);
        differingWords.add(differingWord);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Set<String> getDifferingWords() {
        return differingWords;
    }
}
