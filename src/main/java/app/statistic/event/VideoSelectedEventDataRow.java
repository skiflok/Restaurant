package app.statistic.event;

import app.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow{

    List<Advertisement> optimalPlaylist;
    long amount;
    int totalDuration;

    Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalPlaylist,
                                        long amount,
                                        int totalDuration) {
        this.optimalPlaylist = optimalPlaylist;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
