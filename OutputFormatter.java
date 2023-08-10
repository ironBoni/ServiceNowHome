import java.util.ArrayList;
import java.util.List;

public class OutputFormatter {
    private final String PREFIX_STRING = "The changing word was: ";
    private final String DELIMITER = ", ";
    public List<String> format(List<PatternGroup> groups) {
        List<String> output = new ArrayList<>();
        List<String> writtenInPattern;
        for (PatternGroup group : groups) {
            writtenInPattern = new ArrayList<>();
            for (Entry entry : group.getEntries()) {
                // in order to make sure identical sentences not written twice in the same pattern.
                if(writtenInPattern.contains(entry.toString()))
                    continue;
                output.add(entry.toString());
                writtenInPattern.add(entry.toString());
            }
            output.add(PREFIX_STRING + String.join(DELIMITER, group.getDifferingWords()));
        }

        return output;
    }
}
