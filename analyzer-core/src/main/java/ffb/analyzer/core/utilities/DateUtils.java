package ffb.analyzer.core.utilities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Utility functions related to working with dates.
 */
public final class DateUtils {
    private DateUtils() {

    }

    /**
     * @return {@link LocalDate} from the provided date string in the specified format.
     */
    public static LocalDate fromString(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * @return {@link LocalDate} from the provided epoch millisecond timestamp.
     */
    public static LocalDate fromEpochMillisecond(long date) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault());
    }

}
