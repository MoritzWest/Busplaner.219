package BE219Thenextchapter.dto;

import BE219Thenextchapter.model.BusStop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//werden zur Laufzeit erstellt
@Setter
@NoArgsConstructor //erstellt leeren Konstruktor

public class BusLineDTO {

    private long busLineId;
    private int busLineNumber;
    private int frequency;
    private BusStop startBusStopId;
    private long busPlan;
    private BusStop endBusStop;
    private List<Long> busPlanIds;

    public BusLineDTO(long busLineId, int busLineNumber, int frequency, BusStop startBusStopId, long busPlan, BusStop endBusStop, List<Long> busPlanIds) {
        this.busLineId = busLineId;
        this.busLineNumber = busLineNumber;
        this.frequency = frequency;
        this.startBusStopId = startBusStopId;
        this.busPlan = busPlan;
        this.endBusStop = endBusStop;
        this.busPlanIds = busPlanIds;
    }
}

