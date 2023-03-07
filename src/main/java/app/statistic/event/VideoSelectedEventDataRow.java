package app.statistic.event;

import java.util.Date;

public class VideoSelectedEventDataRow {
    int totalDuration;

    Date currentDate;

    public VideoSelectedEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
}
