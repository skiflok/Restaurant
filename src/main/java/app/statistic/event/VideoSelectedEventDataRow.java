package app.statistic.event;

import java.util.Date;

public class VideoSelectedEventDataRow implements EventDataRow{
    int totalDuration;

    Date currentDate;

    public VideoSelectedEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
