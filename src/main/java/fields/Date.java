package fields;

import generalinterfaces.FunctionAfterWait;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public record Date(int sec, int min, int hr, int day) implements Comparable<Date> {
    public Date {
        if (sec < 0 || sec > 59)
            throw new IllegalArgumentException("Invalid second value");
        if (min < 0 || min > 59)
            throw new IllegalArgumentException("Invalid minute value");
        if (hr < 0 || hr > 23)
            throw new IllegalArgumentException("Invalid hour value");
    }

    public void waitDate() throws InterruptedException {
        Thread.sleep(toSec() * 1000L);
    }

    public void waitDate(FunctionAfterWait f, Object... args) {
            new Thread(() -> {
                try {
                    Thread.sleep(toSec() * 1000L);
                } catch (InterruptedException _) {
                }
                f.run(args);
            }).start();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return sec == date.sec && min == date.min && hr == date.hr && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sec, min, hr, day);
    }

    @Override
    public String toString() {
        return String.format("%s and %02d:%02d:%02d", STR."\{day} day\{day == 1 ? "" : "s"}", hr, min, sec);
    }

    public int toSec() {
        return sec + min * 60 + hr * 3600 + day * 86400;
    }

    @Override
    public int compareTo(Date o) {
        return toSec() - o.toSec();
    }
}
