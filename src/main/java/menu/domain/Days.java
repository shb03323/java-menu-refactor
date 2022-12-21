package menu.domain;

public enum Days {

    MONDAY(1, "월요일"),
    TUESDAY(2, "화요일"),
    WEDNESDAY(3, "수요일"),
    THURSDAY(4, "목요일"),
    FRIDAY(5, "금요일");

    private final int sequence;
    private final String dayName;

    Days(int sequence, String dayName) {
        this.sequence = sequence;
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }
}
