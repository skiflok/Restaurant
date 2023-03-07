package app.statistic.event;

import app.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class NoAvailableVideoEventDataRow {
    List<Advertisement> optimalPlaylist;
    long amount;
    int totalDuration;

    Date currentDate;

    public NoAvailableVideoEventDataRow(List<Advertisement> optimalPlaylist,
                                        long amount,
                                        int totalDuration) {
        this.optimalPlaylist = optimalPlaylist;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
}
