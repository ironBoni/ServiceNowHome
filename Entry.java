public class Entry {
    private final String timestamp;
    private final String text;

    public Entry(String timestamp, String text) {
        this.timestamp = timestamp;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return timestamp + " " + text;
    }
}
