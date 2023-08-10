import java.util.*;

public class EntryGrouper {
    public List<PatternGroup> group(List<Entry> entries) {
        Map<String, PatternGroup> patternGroupMap = new HashMap<>();

        for (int i = 0; i < entries.size(); i++) {
            for (int j = i + 1; j < entries.size(); j++) {
                Entry entry1 = entries.get(i);
                Entry entry2 = entries.get(j);

                String[] words1 = entry1.getText().split(" ");
                String[] words2 = entry2.getText().split(" ");

                if (words1.length != words2.length) {
                    continue;
                }

                int differingWordCount = 0;
                String differingWord1 = "";
                String differingWord2 = "";

                for (int k = 0; k < words1.length; k++) {
                    if (!words1[k].equalsIgnoreCase(words2[k])) {
                        differingWordCount++;
                        differingWord1 = words1[k];
                        differingWord2 = words2[k];
                    }

                    if (differingWordCount > 1) {
                        break;
                    }
                }

                if (differingWordCount == 1) {
                    String pattern = entry1.getText().replace(differingWord1, "*");
                    patternGroupMap.computeIfAbsent(pattern, k -> new PatternGroup())
                            .addEntry(entry1, differingWord1);
                    patternGroupMap.get(pattern).addEntry(entry2, differingWord2);
                }
            }
        }

        return new ArrayList<>(patternGroupMap.values());
    }
}
