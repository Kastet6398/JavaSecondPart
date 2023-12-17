package fields;

public record Date(int sec, int min, int hr, int day) {
    public Date {
        if (sec < 0 || sec > 59)
            throw new IllegalArgumentException("Invalid second value");
        if (min < 0 || min > 59)
            throw new IllegalArgumentException("Invalid minute value");
        if (hr < 0 || hr > 23)
            throw new IllegalArgumentException("Invalid hour value");
    }
}
