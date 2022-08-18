package xyz.subho.inventory.utilities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Utility {

    public static LocalDateTime epochToLocalDateTime(Long epoch) {
        return LocalDateTime.ofEpochSecond(epoch, 0, ZoneOffset.UTC);
    }

    public static Long localDateTimeToEpoch(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
