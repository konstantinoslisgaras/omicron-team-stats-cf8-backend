package solipsismal.olympiacosfcapp.core.enums;

import lombok.Getter;

@Getter
public enum Day {
    DO_NOT_USE(0, "DO_NOT_USE"),
    MONDAY(1, "MON"),
    TUESDAY(2, "TUE"),
    WEDNESDAY(3, "WED"),
    THURSDAY(4, "THU"),
    FRIDAY(5, "FRI"),
    SATURDAY(6, "SAT"),
    SUNDAY(7, "SUN");

    private final int dayNumber;
    private final String abbreviation;

    Day(int dayNumber, String abbreviation) {
        this.dayNumber = dayNumber;
        this.abbreviation = abbreviation;
    }

    private boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    private boolean isWeekday() {
        return (!isWeekend() && !(this == DO_NOT_USE));
    }
}
